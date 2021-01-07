package main.controller;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import model.NewsDTO;
import persistence.DBManager;
import persistence.dao.NewsDAO;

@Controller
public class News {

	@GetMapping("/news")
	public String getNews(HttpSession session) {
		NewsDAO nDao = DBManager.getInstance().newsDAO();
		List<NewsDTO> nws = nDao.findAll();
		Collections.reverse(nws);
		session.setAttribute("newss", nws);
		return "news"; 
	}
	
}
