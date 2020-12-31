package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import model.LibroDTO;
import persistence.DBManager;
import persistence.dao.LibroDAO;


public class TestDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* try {
			Connection conn = DBManager.getInstance().getDataSource().getConnection();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} */
		
		LibroDAO sDao = DBManager.getInstance().libroDAO();
		List<LibroDTO> libri = sDao.findAll();
		for(LibroDTO l : libri) {
			
			System.out.println(l.getIsbn());
			System.out.println(l.getTitolo());
			System.out.println(l.getAutore());
			
		}
	}

}
