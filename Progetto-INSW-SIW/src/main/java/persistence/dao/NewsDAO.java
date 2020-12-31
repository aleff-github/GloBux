package persistence.dao;

import java.util.List;

import model.NewsDTO;

public interface NewsDAO {

	public void save(NewsDTO news);		
	public NewsDTO findByPrimaryKey(String titolo); 		
	public List<NewsDTO> findAll();
	public void update(NewsDTO news);		
	public void delete(NewsDTO news);		
	
}
