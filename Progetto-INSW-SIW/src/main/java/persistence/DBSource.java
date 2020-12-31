package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBSource {

	private String uri;
	private String username;
	private String password;
	
	public DBSource(String uri, String us, String ps) {
		super();
		this.uri = uri;
		this.username = us;
		this.password = ps;
	}
	
	
	public Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(uri, username, password);
		return connection;
	}
}
