package persistence.dao.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.LibroDTO;
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
		Connection connection = null;
		try {
			connection = dbSource.getConnection();
			String query = "INSERT INTO librolibreria (idlibreria, libro) VALUES (?,?)"; 
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, libreria.getIdLibreria());
			statement.setString(2, libreria.getLibro());
			statement.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {/**/}
			}
		}

	}

	@Override
	public LibreriaDTO findByPrimaryKey(String idlibreria) {
		Connection connection = null;
		LibreriaDTO libreria = null;
		try {
			connection = dbSource.getConnection();
			PreparedStatement statement;
			String query = "select * from librolibreria where idlibreria = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, idlibreria);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				libreria = new LibreriaDTO();
				libreria.setIdLibreria(result.getString("idlibreria"));				
				return libreria;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {/**/}
			}
		}
		return libreria;
	}
	
	@Override
	public List<String> findAllByUser(String idlibreria){
		Connection connection = null;
		List<String> libreriaList = new LinkedList<>();
		try {
			connection = dbSource.getConnection();
			String query = "select libro from librolibreria where idlibreria =?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, idlibreria);
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				
				libreriaList.add(result.getString("libro"));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {/**/}
			}
		}
		return libreriaList;
	}


	public void delete(LibreriaDTO libreria) {
		Connection conn = null;
		try {
			conn = dbSource.getConnection();
			String query = "delete from librolibreria where libro=? AND idlibreria=?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, libreria.getLibro());
			statement.setString(2, libreria.getIdLibreria());
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
	
	public void add(String libro, String utente) {
		Connection conn = null;
		try {
			conn = dbSource.getConnection();
			String query = "INSERT INTO librolibreria (idlibreria, libro)"
					+ "VALUES (?, ?)";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, utente);
			statement.setString(2, libro);
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
}
