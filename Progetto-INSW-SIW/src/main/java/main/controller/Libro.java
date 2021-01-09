package main.controller;

import java.io.File;
import java.sql.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.LibroDTO;
import persistence.DBManager;
import persistence.dao.LibroDAO;

@Controller
public class Libro {
	
	@GetMapping("/carica-libro")
	public String getCaricaLibro() {
		return "carica_libro";
	}
	
	@PostMapping("/do-carica-libro")
	public String getDoCaricaLibro(HttpSession session, 
									@RequestParam String isbn,
									@RequestParam String titolo,
									@RequestParam String autore,
									@RequestParam Date data,
									@RequestParam File file) {
	    
		LibroDAO lDao = DBManager.getInstance().libroDAO();
		if(lDao.findByPrimaryKey(isbn) != null) {
			System.out.println("Libro già caricato");
			return "index";
		}
		
		LibroDTO libro = new LibroDTO();
		libro.setIsbn(isbn);
		libro.setTitolo(titolo);
		libro.setAutore(autore);
		libro.setData(data);
		String url = "https://globux.altervista.org/" + isbn;
		libro.setContenuto(url);
		
		lDao.save(libro);
		
		System.out.println("Libro caricato!");
		return "index";
	}
	
}
