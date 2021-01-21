package main.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import model.LibroDTO;
import persistence.DBManager;

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

}
