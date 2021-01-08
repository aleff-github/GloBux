package persistence.dao.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
		Connection conn = null;
		try {
			conn = dbSource.getConnection();
			
			String query = "INSERT INTO libro (isbn, titolo, autore, data, contenuto, genere, sottogenere) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, libro.getIsbn());
			statement.setString(2, libro.getTitolo());
			statement.setString(3, libro.getAutore());
			statement.setDate(4, (Date) libro.getData());
			statement.setString(5, libro.getContenuto());
			statement.setString(6, libro.getGenere());
			statement.setString(7, libro.getSottogenere());
			
			statement.executeQuery();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {/**/}
			}
		}
	}

	@Override
	public LibroDTO findByPrimaryKey(String isbn) {
		Connection conn = null;
		LibroDTO libro = null;
		try {
			conn = dbSource.getConnection();
			String query = "select * from libro where isbn = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, isbn);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				libro = new LibroDTO();
				libro.setAutore(result.getString("autore"));
				libro.setContenuto(result.getString("contenuto"));
				libro.setData(result.getDate("data"));
				libro.setIsbn(result.getString("isbn"));
				libro.setTitolo(result.getString("titolo"));
				libro.setGenere(result.getString("genere"));
				libro.setSottogenere(result.getString("sottogenere"));
				
				return libro;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {/**/}
			}
		}
		
		return libro;
	}

	@Override
	public List<LibroDTO> findAll() {
		Connection conn = null;
		List<LibroDTO> libri = new ArrayList<>();
		try {
			conn = dbSource.getConnection();
			String query = "select * from libro";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				
				String isb = rs.getString("isbn");
				String titolo = rs.getString("titolo");
				String autore = rs.getString("autore");
				Date data = rs.getDate("data");
				String contenuto = rs.getString("contenuto");
				String genere = rs.getString("genere");
				String sottoGenere = rs.getString("sottogenere");
				
				LibroDTO libro = new LibroDTO();
				libro.setIsbn(isb);
				libro.setTitolo(titolo);
				libro.setAutore(autore);
				libro.setData(data);
				libro.setContenuto(contenuto);
				libro.setGenere(genere);
				libro.setSottogenere(sottoGenere);
				
				libri.add(libro);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {/**/}
			}
		}
		
		return libri;
	}

	@Override
	public void update(LibroDTO libro) {
		Connection conn = null;
		try {
			conn = dbSource.getConnection();
			
			String query = "update libro set titolo=?, autore=?, data=?, contenuto=?, genere=?, sottogenere=? where isbn=?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, libro.getTitolo());
			statement.setString(2, libro.getAutore());
			statement.setDate(3, (Date) libro.getData());
			statement.setString(4, libro.getContenuto());
			statement.setString(5, libro.getGenere());
			statement.setString(6, libro.getSottogenere());
			
			ResultSet result = statement.executeQuery();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {/**/}
			}
		}
	}

	@Override
	public void delete(LibroDTO libro) {
		Connection conn = null;
		try {
			conn = dbSource.getConnection();
			
			String query = "delete from libro where isbn=?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, libro.getIsbn());
			
			ResultSet result = statement.executeQuery();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {/**/}
			}
		}
	}

}
