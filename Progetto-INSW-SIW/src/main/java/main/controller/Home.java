package main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {

	@GetMapping("/")
	public String getIndex() {
		return "index";
	}
	
	@GetMapping("/book")
	public String getBook() {
		return "book";
	}
	
	/*
	 * 
	 * Login(login, doLogin)
	 * 
	 * Controller(registrazione, doRegistrazione)
	 * 
	 * */

}
