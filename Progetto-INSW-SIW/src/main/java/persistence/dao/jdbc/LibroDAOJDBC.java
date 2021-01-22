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
	
	public List<LibroDTO> effettuaSelezione(ResultSet rs, boolean approvato){
		List<LibroDTO> libri = new ArrayList<>();
		try {
			while(rs.next()) {
				LibroDTO libro = new LibroDTO();
				libro.setIsbn(rs.getString("isbn"));
				libro.setTitolo(rs.getString("titolo"));
				libro.setAutore(rs.getString("autore"));
				libro.setEditore(rs.getString("editore"));
				libro.setAnno(rs.getInt("anno"));
				libro.setFile(rs.getString("file"));
				libro.setGenere(rs.getString("genere"));
				libro.setSottogenere(rs.getString("sottogenere"));
				libro.setSinossi(rs.getString("sinossi"));
				libro.setImage(rs.getString("image"));
				libro.setVoto(rs.getInt("voto"));
				libro.setNumeroVoti(rs.getInt("numerovoti"));
				libro.setApprovato(rs.getBoolean("approvato"));
				libro.setUtente(rs.getString("utente"));
				
				if(libro.getApprovato() == approvato)
					libri.add(libro);
			}
		}catch(Exception e) {e.printStackTrace();}
		return libri;
	}
	
	@Override
	public void save(LibroDTO libro) {
		Connection conn = null;
		try {
			conn = dbSource.getConnection();
			
			String query = "INSERT INTO libro (isbn, titolo, autore, editore, anno, file, genere, sottogenere, sinossi, image, approvato, utente) "
							+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, libro.getIsbn());
			statement.setString(2, libro.getTitolo());
			statement.setString(3, libro.getAutore());
			statement.setString(4, libro.getEditore());
			statement.setInt(5, libro.getAnno());
			statement.setString(6, libro.getFile());
			statement.setString(7, libro.getGenere());
			statement.setString(8, libro.getSottogenere());
			statement.setString(9, libro.getSinossi());
			statement.setString(10, libro.getImage());
			statement.setBoolean(11, false);
			statement.setString(12, libro.getUtente());
			
			statement.executeUpdate();
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
	public LibroDTO findByPrimaryKey(String isbn) { // OK
		Connection conn = null;
		LibroDTO libro = null;
		try {
			conn = dbSource.getConnection();
			String query = "select * from libro where isbn = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, isbn);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				libro = new LibroDTO();
				libro.setIsbn(rs.getString("isbn"));
				libro.setTitolo(rs.getString("titolo"));
				libro.setAutore(rs.getString("autore"));
				libro.setEditore(rs.getString("editore"));
				libro.setAnno(rs.getInt("anno"));
				libro.setFile(rs.getString("file"));
				libro.setGenere(rs.getString("genere"));
				libro.setSottogenere(rs.getString("sottogenere"));
				libro.setSinossi(rs.getString("sinossi"));
				libro.setImage(rs.getString("image"));
				libro.setVoto(rs.getInt("voto"));
				libro.setNumeroVoti(rs.getInt("numerovoti"));
				libro.setApprovato(rs.getBoolean("approvato"));
				libro.setUtente(rs.getString("utente"));
				
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
	public List<LibroDTO> findAll() { // OK
		Connection conn = null;
		List<LibroDTO> libri = new ArrayList<>();
		try {
			conn = dbSource.getConnection();
			String query = "select * from libro";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			libri = effettuaSelezione(rs, true);
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
			

			String query = "update libro set approvato=? where isbn=?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setBoolean(1, libro.getApprovato());
			statement.setString(2, libro.getIsbn());
			
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


	@Override
	public List<LibroDTO> findAllAutore(String autore) {
		Connection conn = null;
		List<LibroDTO> libri = new ArrayList<>();
		try {
			conn = dbSource.getConnection();
			String query = "select * from libro where autore = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, autore);
			ResultSet rs = statement.executeQuery();
			libri = effettuaSelezione(rs, true);
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
	public List<LibroDTO> findAllGenere(String genere) { // OK
		Connection conn = null;
		List<LibroDTO> libri = new ArrayList<>();
		try {
			conn = dbSource.getConnection();
			String query = "SELECT * FROM libro where genere=?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, genere);
			ResultSet rs = statement.executeQuery();
			libri = effettuaSelezione(rs, true);
		} catch (SQLException e) {
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
	public List<LibroDTO> findAllNonApprovati() { // Ok
		Connection conn = null;
		List<LibroDTO> libri = new ArrayList<>();
		try {
			conn = dbSource.getConnection();
			String query = "select * from libro";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			libri = effettuaSelezione(rs, false);
		} catch (SQLException e) {
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
	public List<LibroDTO> findAllByUtente(String utente) {
		Connection conn = null;
		List<LibroDTO> libri = new ArrayList<>();
		try {
			conn = dbSource.getConnection();
			String query = "select * from libro where utente = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, utente);
			ResultSet rs = statement.executeQuery(query);
			libri = effettuaSelezione(rs, true);
		} catch (SQLException e) {
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
	public void updateVoto(String isbn, Integer voto, Integer numeroVoti, Integer votazioni) {
		Connection conn = null;
		try {
			conn = dbSource.getConnection();
			numeroVoti += 1;
			votazioni += voto;
			String query = "update libro set voto=?, numerovoti=? where isbn=?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, votazioni);
			statement.setInt(2, numeroVoti);
			statement.setString(3, isbn);
			
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
