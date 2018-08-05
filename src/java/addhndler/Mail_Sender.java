/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addhndler;

import java.io.Serializable;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Younus
 */
public class Mail_Sender implements Serializable {

    public void sendMail(String fromMail, String username, String password, String toMail, String subject, String message) throws MessagingException {

        Properties props = System.getProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.fallback", "false");

        Session mailSession = Session.getDefaultInstance(props, null);
        mailSession.setDebug(true);
        Message mailMessage = new MimeMessage(mailSession);

        mailMessage.setFrom(new InternetAddress(fromMail));
        mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(toMail));
        mailMessage.setContent(message,"text/html");
        mailMessage.setSubject(subject);
        Transport transport= mailSession.getTransport("smtp");
        transport.connect("smtp.gmail.com", username, password);
        transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
        
    }

}
