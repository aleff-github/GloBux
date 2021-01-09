package main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {

	@GetMapping("/")
	public String getIndex() {
		return "index";
	}
	
	@GetMapping("/termini-e-condizioni")
	public String getTerminiECondizioni() {
		return "termini-e-condizioni";
	}

}
