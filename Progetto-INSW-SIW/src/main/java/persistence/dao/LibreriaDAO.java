package persistence.dao;

import java.util.List;

import model.LibreriaDTO;
import model.LibroDTO;

public interface LibreriaDAO {

	public void save(LibreriaDTO libreria);		
	public LibreriaDTO findByPrimaryKey(String idlibreria); 		
	//public List<LibreriaDTO> findAll();
	//public void update(LibreriaDTO libreria);		
	public void delete(LibreriaDTO libreria);	
	public List<LibroDTO> findAllByPrimaryKey(String idlibreria);
	
}
