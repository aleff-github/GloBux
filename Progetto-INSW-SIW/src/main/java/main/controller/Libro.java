package main.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.concurrent.SuccessCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import model.LibreriaDTO;
import model.LibroDTO;
import persistence.DBManager;
import persistence.dao.LibreriaDAO;
import s3.ServiceAmazonS3;

@Controller
public class Libro {


	@GetMapping("/caricaLibro")
	public String getUpBook() {
		return "caricaLibro";
	}
	
	@GetMapping("/leggiLibro")
	public String readBook(@RequestParam String file, @RequestParam String titolo, HttpSession session) {
		
		session.setAttribute("file", file);
		session.setAttribute("titolo", titolo);
		return "leggiLibro";
	}
	
	@GetMapping("/votaLibro")
	public String getVotazione(@RequestParam Integer voto, HttpSession session, Model model) {
		String isbn = (String) session.getAttribute("isbn");
		LibroDTO libro = DBManager.getInstance().libroDAO().findByPrimaryKey(isbn);
		DBManager.getInstance().libroDAO().updateVoto(isbn, voto, libro.getNumeroVoti(), libro.getVoto());
		
//		return getBook(isbn, session, model);
		
		return "redirect:/libro?isbn=" + (String) session.getAttribute("isbn");
	
	}

	@GetMapping("/libro")  // /book?isbn=9788804668237
	public String getBook(@RequestParam String isbn, HttpSession session, Model model) {
		
		if(session.getAttribute("loggato") == null)
			return "redirect:/login";

		
		// ricerca del libro indicato dall'utente
		LibroDTO libro = DBManager.getInstance().libroDAO().findByPrimaryKey(isbn);
		
		session.setAttribute("id", null);
		session.setAttribute("votazione", null);
		
		if(libro == null)
			session.setAttribute("id", isbn);
		else {
			List<LibroDTO> libriAutore = DBManager.getInstance().libroDAO().findAllAutore(libro.getAutore());
			List<LibroDTO> libriGenere = DBManager.getInstance().libroDAO().findAllAutore(libro.getGenere());
			model.addAttribute("libriAutore", libriAutore);
			model.addAttribute("libriGenere", libriGenere);
			model.addAttribute("libro", libro);
			Integer voti = libro.getNumeroVoti();
			Integer voto = libro.getVoto();
			if(voti == 0)
				voti = 1;
			if(voto == 0)
				voto = 1;
			Integer votoFinale = voto/voti;
			session.setAttribute("votazione", votoFinale);
			session.setAttribute("isbn", libro.getIsbn());
		}
		
		// controlliamo se il libro è presente tra i preferiti dell'utente
		if(this.esisteInLibreriaUtente(isbn, (String)session.getAttribute("username"))) {
			model.addAttribute("preferito", true);
		}

		
		return "libro";
	}


	@PostMapping("/caricaLibro/up")
	@ResponseBody
	public String saveBook(@RequestParam String isbn, @RequestParam String titolo, @RequestParam String autore,
			@RequestParam String editore, @RequestParam String genere, @RequestParam Integer anno, @RequestParam String sottogenere, @RequestParam String sinossi,
			@RequestParam MultipartFile image, @RequestParam MultipartFile file, HttpSession session) {

		try {
			LibroDTO libro = new LibroDTO();
			String nameImage;
			String nameFile;

			// memorizziamo l'immagine e il contenuto in S3
			nameImage = ServiceAmazonS3.getInstance().uploadFileImage(image);
			nameFile = ServiceAmazonS3.getInstance().uploadFileEbook(file);

			libro.setIsbn(isbn); 
			libro.setTitolo(titolo);
			libro.setAutore(autore);
			libro.setEditore(editore);
			libro.setAnno(anno);
			libro.setGenere(genere);
			libro.setSottogenere(sottogenere);
			libro.setSinossi(sinossi);
			libro.setImage(nameImage);
			libro.setFile(nameFile);
			libro.setApprovato(false);
			libro.setUtente(session.getAttribute("username").toString());

			DBManager.getInstance().libroDAO().save(libro);

		} catch (IOException e) { e.printStackTrace(); return "ERROR"; }

		return "SUCCESS";
	}


	public String getIndex(HttpSession session) {
		//Per il carosello
	    List<LibroDTO> libri = DBManager.getInstance().libroDAO().findAll();
		session.setAttribute("libri", libri);
		return "index";
	}

	
	
	private boolean esisteInLibreriaUtente(String isbn, String username) {
		
		LibreriaDAO lDao = DBManager.getInstance().libreriaDAO();
		List<LibroDTO> libreria = lDao.findAllByUser(username);
		
		for(LibroDTO libro : libreria) {
			if(libro.getIsbn().equals(isbn))
				return true;
		}
		
		return false;
	}
	



}
