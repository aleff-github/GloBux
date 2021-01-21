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
		Connection connection = null;
		try {
			connection = dbSource.getConnection();
			String query = "INSERT INTO news (titolo,data,immagine,contenuto) VALUES (?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, news.getTitolo());
			statement.setDate(2, news.getData());
			statement.setString(3, news.getImmagine());
			statement.setString(4, news.getContenuto());
			
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
	public NewsDTO findByPrimaryKey(String titolo) {
		Connection connection = null;
		NewsDTO news = null;
		try {
			connection = dbSource.getConnection();
			PreparedStatement statement;
			String query = "select * from news where titolo = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, titolo);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				news = new NewsDTO();
				news.setContenuto(result.getString("contenuto"));				
				news.setData(result.getDate("data"));
				news.setImmagine(result.getString("immagine"));
				news.setTitolo(result.getString("titolo"));
				return news;
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
		return news;
	}

	@Override
	public List<NewsDTO> findAll() { 
		Connection connection = null;
		List<NewsDTO> newsList = new LinkedList<>();
		try {
			connection = dbSource.getConnection();
			NewsDTO news;
			Statement statement = connection.createStatement();
			String query = "select * from news";
			ResultSet result = statement.executeQuery(query);
			while (result.next()) {
				news = new NewsDTO();
				news.setContenuto(result.getString("contenuto"));				
				news.setData(result.getDate("data"));
				news.setImmagine(result.getString("immagine"));
				newsList.add(news);
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
		return newsList;
	}

	@Override
	public void update(NewsDTO news) {
		Connection connection = null;
		try {
			connection = dbSource.getConnection();
			String update = "update news SET titolo = ?, data = ?, immagine = ?, WHERE contenuto = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, news.getTitolo());				
			statement.setDate(2, news.getData());
			statement.setString(3, news.getImmagine());
			statement.setString(4, news.getContenuto());
			statement.executeUpdate();
		} catch (SQLException e) {
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
	public void delete(NewsDTO news) {
		Connection conn = null;
		try {
			conn = dbSource.getConnection();
			String query = "delete from news where titolo=?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, news.getTitolo());
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
