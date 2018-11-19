// File Name SendEmail.java

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmail {
   
	public static void sendEmail(String recipient, String emailBody) {    
      String to = recipient;
      String from = "hacksbogdan@gmail.com";

      
      // Get system properties
      Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
      

      // Get the default Session object.
         
      //Session session = Session.getDefaultInstance(props);
        Session session = Session.getInstance(props,
             new javax.mail.Authenticator() {
               protected PasswordAuthentication getPasswordAuthentication() {
                   return new PasswordAuthentication("hacksbogdan@gmail.com","hackathon21");
               }
             });
         
      try{
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);
          
         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

         // Set Subject: header field
         message.setSubject("See the Impact of Your Donation!");

         // Now set the actual message
         message.setText(emailBody);
         
         Transport.send(message);
         System.out.println("Sent message successfully....");
      }catch (MessagingException mex) {
         mex.printStackTrace();
      }
   }
}