package main.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.LibreriaDTO;
import model.LibroDTO;
import persistence.DBManager;
import persistence.dao.LibreriaDAO;
import persistence.dao.LibroDAO;

@Controller
public class Libreria {

	@GetMapping("/libreria")
	public String getLibreria(HttpSession session) {
		LibreriaDAO lDao = DBManager.getInstance().libreriaDAO();
		LibroDAO libDao = DBManager.getInstance().libroDAO();
		List<String> lib = lDao.findAllByUser((String) session.getAttribute("username"));
		List<LibroDTO> libri = new ArrayList();
		List<String> libriDaAggiungere = new ArrayList();
		for(String l : lib) {
			System.out.println(l);
			
			LibroDTO libro = libDao.findByPrimaryKey(l);
			
			if(libro == null) {
				libriDaAggiungere.add(l);
			}
			else {

				libri.add(libro);
			}
		}
		for(LibroDTO l: libri) {
			System.out.println(" /n"+l.getIsbn());
		}
		session.setAttribute("listaLibri", libri);
		session.setAttribute("listaId", libriDaAggiungere);
		return "libreria";
	}
	
	@PostMapping("/deleteLibro")
	public String deleteLibro(HttpSession session, @RequestParam String libreria, @RequestParam String libro) {
		LibreriaDTO lib = new LibreriaDTO();
		lib.setIdLibreria(libreria);
		lib.setLibro(libro);
		LibreriaDAO lDao = DBManager.getInstance().libreriaDAO();
		lDao.delete(lib);
		return getLibreria(session);
	}
	
	@PostMapping("/addLibro")
	public String addLibro(HttpSession session) {
		LibreriaDAO lDao = DBManager.getInstance().libreriaDAO();
		lDao.add((String) session.getAttribute("isbn"), (String) session.getAttribute("username"));
		return getLibreria(session);
	}
}
