package persistence;

import persistence.dao.LibroDAO;
import persistence.dao.jdbc.LibroDAOJDBC;


// usiamo il singleton perché vogliamo una e una sola istanza che gestisca il database
public class DBManager {

	private static DBManager instance = null;
	static DBSource dataSource;
	
	// all'avvio viene eseguito questo pezzo di codice
	// stabiliamo la connessione al CB tramite JDBC
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
		return new LibroDAOJDBC(this.dataSource);
	}
	
	
}















