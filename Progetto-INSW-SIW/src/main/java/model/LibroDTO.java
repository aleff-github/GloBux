package model;

import java.util.Date;

public class LibroDTO {

	private String isbn;
	private String titolo;
	private String autore;
	private String contenuto;
	private Date data;
	private String genere;
	private String sottogenere;
	
	
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getAutore() {
		return autore;
	}
	public void setAutore(String autore) {
		this.autore = autore;
	}
	public String getContenuto() {
		return contenuto;
	}
	public void setContenuto(String contenuto) {
		this.contenuto = contenuto;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getGenere() {
		return genere;
	}
	public void setGenere(String genere) {
		this.genere = genere;
	}
	public String getSottogenere() {
		return sottogenere;
	}
	public void setSottogenere(String sottogenere) {
		this.sottogenere = sottogenere;
	}
	
	
	
	
}
