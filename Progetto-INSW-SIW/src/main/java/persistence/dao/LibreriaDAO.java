package persistence.dao;

import java.util.List;

import model.LibreriaDTO;
import model.LibroDTO;

public interface LibreriaDAO {

	public void save(LibreriaDTO libreria);		
	public LibreriaDTO findByPrimaryKey(String idlibreria);	
	public void delete(LibreriaDTO libreria);	
	public List<LibroDTO> findAllByUser(String idlibreria);
	
}
