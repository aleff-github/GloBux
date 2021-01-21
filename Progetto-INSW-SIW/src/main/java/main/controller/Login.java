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
public class Login {

	@GetMapping("/login")
	public String postLogin() {
		return "login";
	}
	
	@PostMapping("/doLogin")
	public String postDoLogin(HttpSession session, 
								@RequestParam String username, 
								@RequestParam String password) {
		String admin="admin";
		
		UtenteDAO uDao = DBManager.getInstance().utenteDAO();
		UtenteDTO utente = uDao.findByPrimaryKey(username);
		if(utente != null && utente.getPassword().equals(password)) {
			//Utente loggato
			if(utente.getUsername().equals(admin)) //Login da Admin
			    session.setAttribute("loggatoAdmin", true);
			
			session.setAttribute("password", password);
		    session.setAttribute("email", utente.getEmail());
		    session.setAttribute("loggato", true);
		    session.setAttribute("username", utente.getUsername());
		    
		    return "index";
		}
		else {
			 return "login";
		}
	}
	
	@GetMapping("/logout")
	public String getLogout(HttpSession session) {
		session.setAttribute("loggatoAdmin", null); //Serve per la home altrimenti da errore se uso false
		session.setAttribute("password", null);
	    session.setAttribute("email", null);
	    session.setAttribute("loggato", null);
	    session.setAttribute("username", null);
		return "index";
	}
	
}
