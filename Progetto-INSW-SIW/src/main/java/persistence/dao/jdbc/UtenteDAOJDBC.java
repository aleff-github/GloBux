package persistence.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.UtenteDTO;
import persistence.DBSource;
import persistence.dao.UtenteDAO;

public class UtenteDAOJDBC implements UtenteDAO {

	DBSource dbSource;
	
	public UtenteDAOJDBC(DBSource dbSource) {
		// TODO Auto-generated constructor stub
		this.dbSource = dbSource;
	}
	
	@Override
	public void save(UtenteDTO utente) {
		Connection conn = null;
		try {
			conn = dbSource.getConnection();
			String query = "INSERT INTO utente (username,email,password) VALUES (?,?,?)";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, utente.getUsername());
			statement.setString(2, utente.getEmail());
			statement.setString(3, utente.getPassword());
			
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
	public UtenteDTO findByPrimaryKey(String username) {
		Connection conn = null;
		UtenteDTO utente = null;
		try {
			conn = dbSource.getConnection();
			String query = "select * from utente where username = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, username);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				utente = new UtenteDTO();
				utente.setUsername(result.getString("username"));				
				utente.setPassword(result.getString("password"));
				utente.setEmail(result.getString("email"));
				return utente;
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
		return utente;
	}

	@Override
	public List<UtenteDTO> findAll() {
		Connection conn = null;
		List<UtenteDTO> utenti = new ArrayList<>();
		try {
			conn = dbSource.getConnection();
			String query = "select * from utente";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				String username = rs.getString("username");
				String email = rs.getString("email");
				String password = rs.getString("password");
				
				UtenteDTO utente = new UtenteDTO();
				utente.setUsername(username);
				utente.setEmail(email);
				utente.setPassword(password);
				
				utenti.add(utente);
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
		return utenti;
	}

	@Override
	public void update(UtenteDTO utente) {
		Connection conn = null;
		try {
			conn = dbSource.getConnection();
			
			String query = "update utente set email=?, password=? where username=?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, utente.getEmail());
			statement.setString(2, utente.getPassword());
			statement.setString(3, utente.getUsername());
			
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
	public void delete(UtenteDTO utente) {
		Connection conn = null;
		try {
			conn = dbSource.getConnection();
			
			String query = "delete from utente where username=?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, utente.getUsername());
			
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
