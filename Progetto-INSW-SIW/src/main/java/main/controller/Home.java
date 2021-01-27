package main.controller;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import model.LibroDTO;
import model.NewsDTO;
import model.UtenteDTO;
import persistence.DBManager;
import persistence.dao.NewsDAO;
import persistence.dao.UtenteDAO;

@Controller
public class Home {

	@GetMapping("/")
	public String getIndex(HttpSession session, Model model) {
		List<LibroDTO> libri = DBManager.getInstance().libroDAO().findAll();
		

		NewsDAO nDao = DBManager.getInstance().newsDAO();
		List<NewsDTO> nws = nDao.findAll();
		Collections.reverse(nws);
		
		
		model.addAttribute("newss", nws);
		model.addAttribute("libri", libri);
		
		
		return "index";
	}
	
	@GetMapping("/404")
	public String get404(HttpSession session) {
		return "404";
	}
	
	@GetMapping("/profilo")
	public String getProfilo(HttpSession session) {
		List<Integer> voti = DBManager.getInstance().libroDAO().findAllByUtente(session.getAttribute("username").toString());
		session.setAttribute("voti", voti.get(0));
		session.setAttribute("numVotazioni", voti.get(1));
		if(session.getAttribute("loggatoAdmin") != null)
			session.setAttribute("utentiRegistrati", DBManager.getInstance().utenteDAO().getUtentiRegistrati());
		return "profilo";
	}

}
