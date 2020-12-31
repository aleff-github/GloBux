package persistence.dao.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.LibroDTO;
import persistence.DBSource;
import persistence.dao.LibroDAO;

public class LibroDAOJDBC implements LibroDAO {

	DBSource dbSource;
	
	public LibroDAOJDBC(DBSource dbSource) {
		// TODO Auto-generated constructor stub
		this.dbSource = dbSource;
	}
	
	
	@Override
	public void save(LibroDTO libro) {
		// TODO Auto-generated method stub

	}

	@Override
	public LibroDTO findByPrimaryKey(String isbn) {
		return null;
	}

	@Override
	public List<LibroDTO> findAll() {
		List<LibroDTO> libri = new ArrayList<>();
		
		try {
			Connection conn = dbSource.getConnection();
			String query = "select * from libro";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				
				String isb = rs.getString("isbn");
				String titolo = rs.getString("titolo");
				String autore = rs.getString("autore");
				Date data = rs.getDate("data");
				String contenuto = rs.getString("contenuto");
				
				LibroDTO libro = new LibroDTO();
				libro.setIsbn(isb);
				libro.setTitolo(titolo);
				libro.setAutore(autore);
				libro.setData(data);
				libro.setContenuto(contenuto);
				
				libri.add(libro);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
		
		return libri;
	}

	@Override
	public void update(LibroDTO libro) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(LibroDTO libro) {
		// TODO Auto-generated method stub

	}

}
