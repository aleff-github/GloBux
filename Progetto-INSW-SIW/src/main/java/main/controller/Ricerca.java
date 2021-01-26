package main.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.LibroDTO;
import persistence.DBManager;
import persistence.dao.LibroDAO;

@Controller
public class Ricerca {

	@GetMapping("/ricerca-libro")
	public String getRicerca(HttpSession session, @RequestParam String ricerca) {
		session.setAttribute("ricerca",null);
		session.setAttribute("ricerca",ricerca);
		LibroDAO lDao = DBManager.getInstance().libroDAO();
		List<LibroDTO> lib = lDao.ricerca(ricerca);
		session.setAttribute("libri",null);
		session.setAttribute("libri",lib);
		return "ricerca";
	}
	
}
