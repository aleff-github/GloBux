package main.controller;


import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Contatti {

	@GetMapping("/contatti")
	public String getContatti() {
		return "contatti";
	}
	
	@PostMapping("/invioEmail")
	public String doPost(@RequestParam String nome, 
			@RequestParam String email,
			@RequestParam String oggetto,
			@RequestParam String messaggio ) {
		String paramEmail= email;
	 	String paramNome = nome;
	 	String paramOggetto = oggetto;
	 	String paramMessaggio = messaggio;
	 	invioEmail(paramEmail,paramNome,paramOggetto,paramMessaggio);
	 	return "contatti";
		
	}
	public void invioEmail(String email, String nome, String subject1,String messaggio) {
		try {
			String host ="smtp.gmail.com" ;
            String user = "progetto.ingsw.siw@gmail.com";
            String pass = "Progetto123";
            String to = "progetto.ingsw.siw@gmail.com";
            String from = email;
            String subject = subject1;
            String messageText = messaggio + "\n" +"\nInviato Da: "+nome+" con email: "+email;
            boolean sessionDebug = false;
            
            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");
            
//          java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(user, pass);
                }
            });
           // Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject); msg.setSentDate(new Date());
            msg.setText(messageText);
            

           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("Messaggio inviato correttamente");
        }catch(Exception ex)
        {
            System.out.println(ex+"problema nell'invio la mail");
        }
		
}
	
	
	
}
