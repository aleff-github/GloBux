package main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Categorie {

	@GetMapping("/categorie")
	public String getCategorie() {
		return "categorie";
	}
	
	@GetMapping("/categoria")
	public String getCategoriaClassica() {
		return "categoria";
	}
	
	@GetMapping("libro/9780786102563")
	@ResponseBody
	public String getCategoria() {
		return "<h1> Libro Aperto </h1>";
	}
	
}
