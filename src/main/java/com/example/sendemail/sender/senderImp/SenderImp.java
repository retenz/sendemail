package com.example.sendemail.sender.senderImp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import com.example.sendemail.sender.Sender;

public class SenderImp implements Sender{
    private String username;
    private String password;
    private Properties props;
    FileInputStream fis;


    public SenderImp(String username, String password){
        try {
            this.fis = new FileInputStream("src/main/resources/mail.properties");
            this.username = username;
            this.password = password;
            props = new Properties();
            try {
                props.load(fis);
            } catch (IOException ex) {
                ex.getMessage();
            }
        } catch (FileNotFoundException ex) {
                ex.getMessage();
        }

    }

    @Override
    public void send(String subject, String text, String toEmail) {
        
        try {
            Session session = Session.getDefaultInstance(props);
            MimeMessage emailMessage= new MimeMessage(session);
            
            
            emailMessage.setFrom(new InternetAddress(username));
            emailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            emailMessage.setSubject(subject);
            emailMessage.setText(text);
            Transport tr= session.getTransport();
            tr.connect(null, password);
            tr.sendMessage(emailMessage, emailMessage.getAllRecipients());
            tr.close();
        } catch (MessagingException ex) {
            ex.getMessage();
        }
    }
}
     
        
        
        
        
        
        
        
       