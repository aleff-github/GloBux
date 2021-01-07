package persistence.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.LibreriaDTO;
import persistence.DBSource;
import persistence.dao.LibreriaDAO;

public class LibreriaDAOJDBC implements LibreriaDAO {

	DBSource dbSource;
	
	public LibreriaDAOJDBC(DBSource dbSource) {
		// TODO Auto-generated constructor stub
		this.dbSource = dbSource;
	}
	
	@Override
	public void save(LibreriaDTO libreria) {
		Connection conn = null;
		try {
			conn = dbSource.getConnection();
			String query = "INSERT INTO libreria (idutente) VALUES (?)";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, libreria.getIdUtente());
			
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
	public LibreriaDTO findByPrimaryKey(String idUtente) {
		Connection conn = null;
		LibreriaDTO libreria = null;
		try {
			conn = dbSource.getConnection();
			String query = "select * from libreria where idutente = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, idUtente);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				libreria = new LibreriaDTO();
				libreria.setIdUtente(result.getString("idutente"));
				return libreria;
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
		return libreria;
	}

	@Override
	public List<LibreriaDTO> findAll() {
		Connection conn = null;
		List<LibreriaDTO> librerie = new ArrayList<>();
		try {
			conn = dbSource.getConnection();
			String query = "select * from libreria";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				String idUtente = rs.getString("idutente");
				
				LibreriaDTO libreria = new LibreriaDTO();
				libreria.setIdUtente(idUtente);
				
				librerie.add(libreria);
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
		return librerie;
	}

	@Override
	public void update(LibreriaDTO libreria) {
		Connection conn = null;
		try {
			conn = dbSource.getConnection();
			
			String query = "update libreria set idutente=?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, libreria.getIdUtente());
			
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
	public void delete(LibreriaDTO libreria) {
		Connection conn = null;
		try {
			conn = dbSource.getConnection();
			
			String query = "delete from libreria where idutente=?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, libreria.getIdUtente());
			
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
