package persistence.dao.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.LibroDTO;
import persistence.DBSource;
import persistence.dao.LibroDAO;

public class LibroDAOJDBC implements LibroDAO {

	DBSource dbSource;
	
	public LibroDAOJDBC(DBSource dbSource) {
		// TODO Auto-generated constructor stub
		this.dbSource = dbSource;
	}
	
	
	@Override
	public void save(LibroDTO libro) {
		Connection conn = null;
		try {
			conn = dbSource.getConnection();
			
			String query = "INSERT INTO libro (isbn, titolo, autore, editore, data, file, genere, sottogenere, sinossi, image, approvato) "
							+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, libro.getIsbn());
			statement.setString(2, libro.getTitolo());
			statement.setString(3, libro.getAutore());
			statement.setString(4, libro.getEditore());
			statement.setDate(5, libro.getData());
			statement.setString(6, libro.getFile());
			statement.setString(7, libro.getGenere());
			statement.setString(8, libro.getSottogenere());
			statement.setString(9, libro.getSinossi());
			statement.setString(10, libro.getImage());
			statement.setBoolean(11, false);
			
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

	@Override
	public LibroDTO findByPrimaryKey(String isbn) {
		Connection conn = null;
		LibroDTO libro = null;
		try {
			conn = dbSource.getConnection();
			String query = "select * from libro where isbn = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, isbn);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				libro = new LibroDTO();
				libro.setAutore(result.getString("autore"));
				libro.setEditore(result.getString("editore"));
				libro.setFile(result.getString("file"));
				libro.setData(result.getDate("data"));
				libro.setIsbn(result.getString("isbn"));
				libro.setTitolo(result.getString("titolo"));
				libro.setGenere(result.getString("genere"));
				libro.setSottogenere(result.getString("sottogenere"));
				libro.setSinossi(result.getString("sinossi"));
				libro.setImage(result.getString("image"));
				libro.setVoto(result.getInt("voto"));
				libro.setNumeroVoti(result.getInt("numerovoti"));
				libro.setApprovato(result.getBoolean("approvato"));
				
				return libro;
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
		
		return libro;
	}

	@Override
	public List<LibroDTO> findAll() {
		Connection conn = null;
		List<LibroDTO> libri = new ArrayList<>();
		try {
			conn = dbSource.getConnection();
			String query = "select * from libro";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				
				String isb = rs.getString("isbn");
				String titolo = rs.getString("titolo");
				String autore = rs.getString("autore");
				String editore = rs.getString("editore");
				Date data = rs.getDate("data");
				String file = rs.getString("file");
				String genere = rs.getString("genere");
				String sottogenere = rs.getString("sottogenere");
				String sinossi = rs.getString("sinossi");
				String image = rs.getString("image");
				int voto = rs.getInt("voto");
				int numeroVoti = rs.getInt("numerovoti");
				boolean approvato = rs.getBoolean("approvato");
				
				LibroDTO libro = new LibroDTO();
				libro.setIsbn(isb);
				libro.setTitolo(titolo);
				libro.setAutore(autore);
				libro.setAutore(editore);
				libro.setData(data);
				libro.setFile(file);
				libro.setGenere(genere);
				libro.setSottogenere(sottogenere);
				libro.setSinossi(sinossi);
				libro.setImage(image);
				libro.setVoto(voto);
				libro.setNumeroVoti(numeroVoti);
				libro.setApprovato(approvato);
				
				libri.add(libro);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {/**/}
			}
		}
		
		return libri;
	}

	@Override
	public void update(LibroDTO libro) {
		Connection conn = null;
		try {
			conn = dbSource.getConnection();
			

			String query = "update libro set titolo=?, editore=?, autore=?, data=?, "
							+ "file=?, genere=?, sottogenere=?, sinossi=?, image=? where isbn=?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, libro.getTitolo());
			statement.setString(2, libro.getAutore());
			statement.setString(3, libro.getEditore());
			statement.setDate(4, (Date) libro.getData());
			statement.setString(5, libro.getFile());
			statement.setString(6, libro.getGenere());
			statement.setString(7, libro.getSottogenere());
			statement.setString(8, libro.getSinossi());
			statement.setString(10, libro.getImage());
			
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
	public void delete(LibroDTO libro) {
		Connection conn = null;
		try {
			conn = dbSource.getConnection();
			
			String query = "delete from libro where isbn=?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, libro.getIsbn());
			
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
	public List<LibroDTO> findAllAutore(String autore) {
		Connection conn = null;
		List<LibroDTO> libri = new ArrayList<>();
		try {
			conn = dbSource.getConnection();
			String query = "select * from libro where autore = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, autore);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				
				String isbn = rs.getString("isbn");
				String titolo = rs.getString("titolo");
				String autor = rs.getString("autore");
				String editore = rs.getString("editore");
				Date data = rs.getDate("data");
				String file = rs.getString("file");
				String genere = rs.getString("genere");
				String sottogenere = rs.getString("sottogenere");
				String sinossi = rs.getString("sinossi");
				String image = rs.getString("image");
				int voto = rs.getInt("voto");
				int numeroVoti = rs.getInt("numerovoti");
				
				LibroDTO libro = new LibroDTO();
				libro.setIsbn(isbn);
				libro.setTitolo(titolo);
				libro.setAutore(autor);
				libro.setAutore(editore);
				libro.setData(data);
				libro.setFile(file);
				libro.setGenere(genere);
				libro.setSottogenere(sottogenere);
				libro.setSinossi(sinossi);
				libro.setImage(image);
				libro.setVoto(voto);
				libro.setNumeroVoti(numeroVoti);
				
				libri.add(libro);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {/**/}
			}
		}
		
		return libri;
	}


	@Override
	public List<LibroDTO> findAllGenere(String genere) {
		Connection conn = null;
		List<LibroDTO> libri = new ArrayList<>();
		try {
			conn = dbSource.getConnection();
			String query = "SELECT * FROM libro where genere=?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, genere);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				
				String isbn = rs.getString("isbn");
				String titolo = rs.getString("titolo");
				String autore = rs.getString("autore");
				String editore = rs.getString("editore");
				Date data = rs.getDate("data");
				String file = rs.getString("file");
				String gener = rs.getString("genere");
				String sottogenere = rs.getString("sottogenere");
				String sinossi = rs.getString("sinossi");
				String image = rs.getString("image");
				int voto = rs.getInt("voto");
				int numeroVoti = rs.getInt("numerovoti");
				
				LibroDTO libro = new LibroDTO();
				libro.setIsbn(isbn);
				libro.setTitolo(titolo);
				libro.setAutore(autore);
				libro.setAutore(editore);
				libro.setData(data);
				libro.setFile(file);
				libro.setGenere(gener);
				libro.setSottogenere(sottogenere);
				libro.setImage(image);
				libro.setSinossi(sinossi);
				libro.setVoto(voto);
				libro.setNumeroVoti(numeroVoti);
				
				libri.add(libro);
				
			}
		} catch (SQLException e) {
			e.printStackTrace(); 
		}finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {/**/}
			}
		}
		
		return libri;
	}
	
	
	@Override
	public void updateVoto(LibroDTO libro) {
		Connection conn = null;
		try {
			conn = dbSource.getConnection();
			
			String query = "update libro set voto=?, numerovoti=? where isbn=?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1,  + libro.getVoto());
			statement.setInt(2,  + libro.getNumeroVoti());
			
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
