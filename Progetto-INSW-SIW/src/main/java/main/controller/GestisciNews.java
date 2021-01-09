package main.controller;

import java.sql.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.NewsDTO;
import persistence.DBManager;
import persistence.dao.NewsDAO;

@Controller
public class GestisciNews {

	@GetMapping("/manageNews")
	public String getGestisciNews() {
		return "gestioneNews";
	}
	
	@PostMapping("/addNews")
	public String PostGestisciNews(HttpSession session, @RequestParam String titolo, 
			@RequestParam Date data, @RequestParam String immagine,
			@RequestParam String contenuto) {

	 	if (titolo == "" || immagine == "" || contenuto == "") {
	 		return "gestioneNews";
	 	}
	 	else {
	 		NewsDAO nDao = DBManager.getInstance().newsDAO();
	 		Date d = data;
	 		NewsDTO news = new NewsDTO();
	 		news.setTitolo(titolo);
	 		news.setData(d);
	 		news.setImmagine(immagine);
	 		news.setContenuto(contenuto);
	 		nDao.save(news);
	 		System.out.println("News aggiunta con successo!");
	 	}
		
		return "gestioneNews";
	}
	
	@PostMapping("/deleteNews")
	public String PostGestisciNews(HttpSession session, @RequestParam String titolo) {

	 	if (titolo == "") {
	 		return "gestioneNews";
	 	}
	 	else {
	 		NewsDAO nDao = DBManager.getInstance().newsDAO();
	 		NewsDTO news = new NewsDTO();
	 		news.setTitolo(titolo);
	 		nDao.delete(news);
	 		System.out.println("News eliminata con successo!");
	 	}
	 	
		return "gestioneNews";
	}
}
