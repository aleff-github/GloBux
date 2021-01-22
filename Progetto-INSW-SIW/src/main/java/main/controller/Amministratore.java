package main.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.LibroDTO;
import persistence.DBManager;
import persistence.dao.LibroDAO;

@Controller
public class Amministratore {

	@GetMapping("/approva-libri")
	public String getLibriNonApprovati(HttpSession session) {
		session.setAttribute("libri",null);
		LibroDAO lDao = DBManager.getInstance().libroDAO();
		List<LibroDTO> lib = lDao.findAllNonApprovati();
		session.setAttribute("libri",lib);
		if(lib.size() > 0)
			session.setAttribute("libriDaApprovare",true);
		return "approvaLibri";
	}
	
	@GetMapping("/approva")
	public String getLibriNonApprovatiUpdate(HttpSession session, @RequestParam String isbn) {
		LibroDAO lDao = DBManager.getInstance().libroDAO();
		LibroDTO libro = lDao.findByPrimaryKey(isbn);
		if(libro == null)
			return "404";
		libro.setApprovato(true);
		lDao.update(libro);
		return getLibriNonApprovati(session);
	}
	
	@GetMapping("/non-approvare")
	public String getNonApprovareLibro(HttpSession session, @RequestParam String isbn) {
		LibroDAO lDao = DBManager.getInstance().libroDAO();
		LibroDTO libro = lDao.findByPrimaryKey(isbn);
		lDao.delete(libro);
		return getLibriNonApprovati(session);
	}
	
	
}
