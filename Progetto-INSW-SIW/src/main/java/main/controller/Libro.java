package main.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;


import model.LibroDTO;
import persistence.DBManager;
import s3.ServiceAmazonS3;

@Controller
public class Libro {

	 
	@GetMapping("/libroA")
	public String getBook() {
		return "libro";
	}
	
	
	@GetMapping("/caricaLibro")
	public String getUpBook() {
		return "caricaLibro";
	}
	@GetMapping("/leggiLibro")
	public String readBook() {
		return "leggiLibro";
	}
	
	@GetMapping("/libro")  // /book?isbn=9788804668237
	public String getBook(@RequestParam String isbn, HttpSession session) {
		
		// ricerca del libro indicato dall'utente
		LibroDTO libro = DBManager.getInstance().libroDAO().findByPrimaryKey(isbn);
		
		// ricerca di tutti i libri dell'autore
//		List<LibroDTO> libriAutore = DBManager.getInstance().libroDAO().findAllAutore(libro.getAutore());
//		
//		// ricerca dei libri simili (per genere)
//		List<LibroDTO> libriGenere = DBManager.getInstance().libroDAO().findAllAutore(libro.getGenere());
//		
		if(libro == null)
			return "404";
		
		System.out.println("isbn: " + libro.getIsbn());
		System.out.println("titolo: " + libro.getTitolo());
		System.out.println("autore: " + libro.getAutore());
		System.out.println("editore: " + libro.getEditore());
		System.out.println("genere: " + libro.getGenere());
		System.out.println("sottogenere: " + libro.getSottogenere());
		System.out.println("sinossi: " + libro.getSinossi());
		System.out.println("contenuto: " + libro.getFile());
		System.out.println("nameimage: " + libro.getImage());
		
		
		session.setAttribute("libro", libro);
//		session.setAttribute("libriAutore", libriAutore);
//		session.setAttribute("libriGenere", libriGenere);
		
		return "libro";
	}
	
	@PostMapping("/caricaLibro/up")
	public RedirectView saveBook(@RequestParam String isbn, @RequestParam String titolo, @RequestParam String autore, 
			@RequestParam String editore, @RequestParam String genere, @RequestParam String sottogenere, @RequestParam String sinossi,
			@RequestParam MultipartFile image, @RequestParam MultipartFile file, HttpSession session) {
		
		// da aggiungere: controllo dell'utente loggato
		
		
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
			libro.setGenere(genere);
			libro.setSottogenere(sottogenere);
			libro.setSinossi(sinossi);
			libro.setImage(nameImage);
			libro.setFile(nameFile);
			
			// memorizziamo il libro nel DB
			DBManager.getInstance().libroDAO().save(libro);
			
		} catch (IOException e) { e.printStackTrace(); }
		

		return new RedirectView("/");
	}
	

	
	
	

	
	
	
}
