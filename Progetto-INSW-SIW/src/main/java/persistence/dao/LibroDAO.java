package persistence.dao;

import java.util.List;

import model.LibroDTO;

public interface LibroDAO {

	public void save(LibroDTO libro);		
	public LibroDTO findByPrimaryKey(String isbn); 		
	public List<LibroDTO> findAll();
	public void update(LibroDTO libro);		
	public void delete(LibroDTO libro);		
	
	public List<LibroDTO> findAllAutore(String autore);
	public List<LibroDTO> findAllGenere(String genere);
	public void updateVoto(String isbn, Integer voto, Integer numeroVoti, Integer votazioni);
	public List<LibroDTO> findAllNonApprovati();
	public List<LibroDTO> findAllByUtente(String utente);
}
