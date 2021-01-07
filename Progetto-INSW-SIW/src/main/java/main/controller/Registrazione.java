package main.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
			return "index";
		}
		
		UtenteDTO utente = new UtenteDTO();
		utente.setUsername(username);
		utente.setEmail(email);
		utente.setPassword(password);
		
		uDao.save(utente);
		
		System.out.println("Utente creato!");
		return "index";
	}
}
