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
		/*
		 * INSERT INTO utente (username, email, password)
		 * VALUES ('user3', 'user3@gmail.com', 1234);
		 * */
		
		try {
			Connection conn = dbSource.getConnection();
			String query = "INSERT INTO utente (username,email,password) VALUES (?,?,?)";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, utente.getUsername());
			statement.setString(2, utente.getEmail());
			statement.setString(3, utente.getPassword());
			
			statement.executeQuery();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public UtenteDTO findByPrimaryKey(String username) {
		
		UtenteDTO utente = null;
		try {
			Connection conn = dbSource.getConnection();
			PreparedStatement statement;
			String query = "select * from utente where username = ?";
			statement = conn.prepareStatement(query);
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
		}
		return utente;
	}

	@Override
	public List<UtenteDTO> findAll() {
		List<UtenteDTO> utenti = new ArrayList<>();
		try {
			Connection conn = dbSource.getConnection();
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
		}
		return utenti;
	}

	@Override
	public void update(UtenteDTO utente) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(UtenteDTO utente) {
		// TODO Auto-generated method stub

	}

}
