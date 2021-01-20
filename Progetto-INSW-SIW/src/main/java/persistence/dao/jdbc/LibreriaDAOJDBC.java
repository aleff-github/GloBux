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
	public List<LibroDTO> findAllByUser(String idlibreria){
		Connection connection = null;
		List<LibroDTO> libreriaList = new LinkedList<>();
		try {
			connection = dbSource.getConnection();
			LibroDTO libro;
			String query = "select * from librolibreria l2 join libro l3 on l3.isbn = l2.libro and l2.idlibreria =?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, idlibreria);
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				libro = new LibroDTO();
				libro.setIsbn(result.getString("isbn"));
				libro.setTitolo(result.getString("titolo"));
				libro.setAutore(result.getString("autore"));
				
				libreriaList.add(libro);
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
}
