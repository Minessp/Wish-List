package br.com.wishlist.api.service;

import br.com.wishlist.api.model.Email;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class EmailService {
    private final JavaMailSender emailSender;
    private Email email;

    public EmailService(JavaMailSender emailSender, Email email) {
        this.emailSender = emailSender;
        this.email = email;
    }

    @Value("${spring.mail.host}")
    private String host;

    public void sendCode(Email email) {
        int generatedCode = new Random().nextInt(999999);

       try {
           SimpleMailMessage message = new SimpleMailMessage();
           message.setFrom(host);
           message.setTo(email.getEmail());
           message.setSubject("Código de recuperação");
           message.setText("Seu código de recuperação é: " + generatedCode);
           emailSender.send(message);

           System.out.println("Email enviado com sucesso!");
       } catch (Exception e) {
           e.printStackTrace();
       }
    }
}
