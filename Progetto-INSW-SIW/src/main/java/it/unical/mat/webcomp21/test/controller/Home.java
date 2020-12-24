package it.unical.mat.webcomp21.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Home {

	
	@GetMapping("/")
	public String getIndex() {
		return "index";
	}
	
	
	@GetMapping("/home")
	@ResponseBody
	public String getHome() {
		return "<h1>Ciao Mondo</h1>";
	}
	
	
	
	
}
