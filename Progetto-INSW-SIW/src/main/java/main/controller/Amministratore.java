package main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Amministratore {

	@GetMapping("/approva-libri")
	public String getCategorie() {
		return "approvaLibri";
	}
	
}
