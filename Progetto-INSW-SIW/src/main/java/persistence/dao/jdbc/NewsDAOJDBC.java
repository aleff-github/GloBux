package persistence.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import model.NewsDTO;
import persistence.DBSource;
import persistence.dao.NewsDAO;

public class NewsDAOJDBC implements NewsDAO {

	DBSource dbSource;
	
	public NewsDAOJDBC(DBSource dbSource) {
		// TODO Auto-generated constructor stub
		this.dbSource = dbSource;
	}
	@Override
	public void save(NewsDTO news) {
		try {
			Connection conn = dbSource.getConnection();
			String query = "INSERT INTO news (titolo,data,username,immagine,contenuto) VALUES (?,?,?,?,?)";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, news.getTitolo());
			statement.setDate(2, news.getData());
			statement.setString(3, news.getUsername());
			statement.setString(4, news.getImmagine());
			statement.setString(5, news.getContenuto());
			
			statement.executeQuery();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public NewsDTO findByPrimaryKey(String titolo) {
		NewsDTO news = null;
		try {
			Connection conn = dbSource.getConnection();
			PreparedStatement statement;
			String query = "select * from news where titolo = ?";
			statement = conn.prepareStatement(query);
			statement.setString(1, titolo);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				news = new NewsDTO();
				news.setContenuto(result.getString("contenuto"));				
				news.setData(result.getDate("data"));
				news.setImmagine(result.getString("immagine"));
				news.setTitolo(result.getString("titolo"));
				news.setUsername(result.getString("username"));
				return news;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return news;
	}

	@Override
	public List<NewsDTO> findAll() { 
		List<NewsDTO> newsList = new LinkedList<>();
		try {
			System.out.println("1");
			Connection connection = dbSource.getConnection();
			System.out.println("2");
			NewsDTO news;
			Statement statement = connection.createStatement();
			String query = "select * from news";
			ResultSet result = statement.executeQuery(query);
			while (result.next()) {
				news = new NewsDTO();
				news.setContenuto(result.getString("contenuto"));				
				news.setData(result.getDate("data"));
				news.setImmagine(result.getString("immagine"));
				news.setTitolo(result.getString("titolo"));
				news.setUsername(result.getString("username"));
				newsList.add(news);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newsList;
	}

	@Override
	public void update(NewsDTO news) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(NewsDTO news) {
		// TODO Auto-generated method stub

	}

}
