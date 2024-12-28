package dev.ernando;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Main {
    public static void main(String[] args) {
        
      String to = "receiver@localhost.com";

      String from = "ernando@localhost.com";

      String host = "localhost";

      Properties properties = System.getProperties();

      properties.setProperty("mail.smtp.host", host);
      properties.setProperty("mail.smtp.port", "1025");

      Session session = Session.getDefaultInstance(properties);

      try {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(from);
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject("Mail test with mailhog");
        message.setText("This is the first message.");
        Transport.send(message);
        System.out.println("Sent message successfully.");
      } catch (Exception e) {
        e.printStackTrace();
      }

    }
}