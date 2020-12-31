package persistence.dao;

import java.util.List;

import model.LibreriaDTO;

public interface LibreriaDAO {

	public void save(LibreriaDTO libreria);		
	public LibreriaDTO findByPrimaryKey(String idUtente); 		
	public List<LibreriaDTO> findAll();
	public void update(LibreriaDTO studente);		
	public void delete(LibreriaDTO studente);		
	
}
