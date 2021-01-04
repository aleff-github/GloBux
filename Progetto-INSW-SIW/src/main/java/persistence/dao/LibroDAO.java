package persistence.dao;

import java.util.List;

import model.LibroDTO;

public interface LibroDAO {

	public void save(LibroDTO libro);		
	public LibroDTO findByPrimaryKey(String isbn); 		
	public List<LibroDTO> findAll();
	public void update(LibroDTO libro);		
	public void delete(LibroDTO libro);		
	
}
