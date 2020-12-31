package persistence.dao;

import java.util.List;

import model.UtenteDTO;

public interface UtenteDAO {

	public void save(UtenteDTO utente);		
	public UtenteDTO findByPrimaryKey(String username); 		
	public List<UtenteDTO> findAll();
	public void update(UtenteDTO utente);		
	public void delete(UtenteDTO utente);		
	
}
