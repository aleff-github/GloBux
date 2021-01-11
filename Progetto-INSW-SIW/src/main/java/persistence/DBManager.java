package persistence;

import persistence.dao.LibreriaDAO;
import persistence.dao.LibroDAO;
import persistence.dao.NewsDAO;
import persistence.dao.UtenteDAO;
import persistence.dao.jdbc.LibreriaDAOJDBC;
import persistence.dao.jdbc.LibroDAOJDBC;
import persistence.dao.jdbc.NewsDAOJDBC;
import persistence.dao.jdbc.UtenteDAOJDBC;


// usiamo il singleton perché vogliamo una e una sola istanza che gestisca il database
public class DBManager {

	private static DBManager instance = null;
	static DBSource dataSource;
	
	// all'avvio viene eseguito questo pezzo di codice
	// stabiliamo la connessione al DB tramite JDBC
	static {
		try {
			Class.forName("org.postgresql.Driver");
              
			dataSource = new DBSource("jdbc:postgresql://suleiman.db.elephantsql.com:5432/jsgsdndb", "jsgsdndb", "q1ZFef73zpabwtEUmmajmNFvHcbLc8nS");
		} catch (Exception e) {
			System.err.println("PostgresDAOFactory.class: failed to load MySQL JDBC driver\n" + e);
			e.printStackTrace();
		}
	}
	
	
	public static DBManager getInstance() {
		if(instance == null)
			instance = new DBManager();
		
		return instance;
	}
	
	private DBManager() {}
	
	public static DBSource getDataSource() {
		return dataSource;
	}

	public LibroDAO libroDAO() {
		return new LibroDAOJDBC(dataSource);
	}
	
	public UtenteDAO utenteDAO() {
		return new UtenteDAOJDBC(dataSource);
	}
	
	public NewsDAO newsDAO() {
		return new NewsDAOJDBC(dataSource);
	}
	
	public LibreriaDAO libreriaDAO() {
		return new LibreriaDAOJDBC(dataSource);
	}
	
}
















