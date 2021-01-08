package main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Book {

	 
	@GetMapping("/book")
	public String getBook() {
		return "book";
	}
	
	
	@GetMapping("/upbook")
	public String getUpBook() {
		return "upBook";
	}
}
