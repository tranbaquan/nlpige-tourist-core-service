package edu.hcmuaf.nlpige.model;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class SendingEmailUtils {
    public static void sendEmail(String destinationEmail, String subject, String content)
            throws MessagingException, UnsupportedEncodingException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("demonlpige@gmail.com", "nlpige741");
            }
        });
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("demonlpige@gmail.com", "NLPige Customer Service"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinationEmail));
        message.setSubject(subject);
        message.setContent(content, "text/html; charset=utf-8");
        Transport.send(message);
        System.out.println("Done");
    }
}
