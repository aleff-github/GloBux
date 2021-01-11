package main.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;

import javax.servlet.http.HttpSession;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.LibroDTO;
import persistence.DBManager;
import persistence.dao.LibroDAO;

@Controller
public class Libro {
	
	@GetMapping("/carica-libro")
	public String getCaricaLibro() {
		return "carica_libro";
	}
	
	@PostMapping("/do-carica-libro")
	public String getDoCaricaLibro(HttpSession session, 
									@RequestParam String isbn,
									@RequestParam String titolo,
									@RequestParam String autore,
									@RequestParam Date data,
									@RequestParam File file) {
	    
		LibroDAO lDao = DBManager.getInstance().libroDAO();
		if(lDao.findByPrimaryKey(isbn) != null) {
			System.out.println("Libro già caricato");
			return "index";
		}
		
		LibroDTO libro = new LibroDTO();
		libro.setIsbn(isbn);
		libro.setTitolo(titolo);
		libro.setAutore(autore);
		libro.setData(data);
		
		caricaLibro(file);
		String url = "https://globux.altervista.org/" + file.getName();
		libro.setContenuto(url);
		
		lDao.save(libro);
		
		System.out.println("Libro caricato!");
		return "index";
	}
	
	private static String SERVER = "ftp.globux.altervista.org";
	private static Integer PORT = 21;
    private static String USER = "globux";
    private static String PASS = "mAvZkKMRBW4p";
	
	public boolean caricaLibro(File file) {
		FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(SERVER, PORT);
            ftpClient.login(USER, PASS);
            ftpClient.enterLocalPassiveMode();
 
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            
            InputStream inputStream = new FileInputStream(file); //Deve essere dentro la cartella del progetto

            ftpClient.storeFile(file.getName(), inputStream);
            inputStream.close();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                    return true;
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
		return false;
	}
	
}
