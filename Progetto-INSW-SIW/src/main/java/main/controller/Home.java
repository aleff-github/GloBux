package main.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import model.LibroDTO;
import model.UtenteDTO;
import persistence.DBManager;
import persistence.dao.UtenteDAO;

@Controller
public class Home {

	@GetMapping("/")
	public String getIndex(HttpSession session) {
		List<LibroDTO> libri = DBManager.getInstance().libroDAO().findAll();
		session.setAttribute("libri", libri);
		
		return "index";
	}
	
	@GetMapping("/404")
	public String get404(HttpSession session) {
		return "404";
	}
	
	@GetMapping("/profilo")
	public String getProfilo(HttpSession session) {
		UtenteDAO uDao = DBManager.getInstance().utenteDAO();
		UtenteDTO utente = uDao.findByPrimaryKey(session.getAttribute("username").toString());
		session.setAttribute("voti", utente.getVoti());
		session.setAttribute("numVotazioni", utente.getVotazioni());
		if(session.getAttribute("loggatoAdmin") != null)
			session.setAttribute("utentiRegistrati", uDao.getUtentiRegistrati());
		return "profilo";
	}

}
