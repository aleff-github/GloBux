package main.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.LibroDTO;
import model.UtenteDTO;
import persistence.DBManager;
import persistence.dao.UtenteDAO;

@Controller
public class Registrazione {
	
	@GetMapping("/registrazione")
	public String getRegistrazione() {
		return "registrazione";
	}
	
	@PostMapping("/doRegistrazione")
	public String registra(HttpSession session, 
							@RequestParam String username,
							@RequestParam String email,
							@RequestParam String password) {
		
		UtenteDAO uDao = DBManager.getInstance().utenteDAO();
		if(uDao.findByPrimaryKey(username) != null) {
			System.out.println("Utente già esistente");
			
			//Per il carosello
		    List<LibroDTO> libri = DBManager.getInstance().libroDAO().findAll();
			session.setAttribute("libri", libri);
			return getIndex(session);
		}
		
		UtenteDTO utente = new UtenteDTO();
		utente.setUsername(username);
		utente.setEmail(email);
		utente.setPassword(password);
		
		uDao.save(utente);
		
		//Per il carosello
	    List<LibroDTO> libri = DBManager.getInstance().libroDAO().findAll();
		session.setAttribute("libri", libri);
		return getIndex(session);
	}
	
	public String getIndex(HttpSession session) {
		//Per il carosello
	    List<LibroDTO> libri = DBManager.getInstance().libroDAO().findAll();
		session.setAttribute("libri", libri);
		return "index";
	}
}
