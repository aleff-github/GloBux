package main.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.LibroDTO;
import persistence.DBManager;
import persistence.dao.LibroDAO;

@Controller
public class Categorie {

	@GetMapping("/categorie")
	public String getCategorie() {
		return "categorie";
	}
	
	@GetMapping("/categoria")
	public String getCategoriaClassica(HttpSession session, @RequestParam String cat) {
		session.setAttribute("categoria",cat);
		LibroDAO lDao = DBManager.getInstance().libroDAO();
		List<LibroDTO> lib = lDao.findAllGenere(cat);
		session.setAttribute("libri",lib);
		
		return "categoria";
	}
	
}
