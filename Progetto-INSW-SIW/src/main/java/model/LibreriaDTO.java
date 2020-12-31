package model;

import java.util.ArrayList;

public class LibreriaDTO {
	
	private String idUtente;
	private ArrayList<LibroDTO> libri;
	
	
	
	public String getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(String idUtente) {
		this.idUtente = idUtente;
	}
	public ArrayList<LibroDTO> getLibri() {
		return libri;
	}
	public void setLibri(ArrayList<LibroDTO> libri) {
		this.libri = libri;
	}
	
	
	
	

}
