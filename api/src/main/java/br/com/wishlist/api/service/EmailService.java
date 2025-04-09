package br.com.wishlist.api.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final JavaMailSender emailSender;

    public EmailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendCode(String email, Integer code) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Código de recuperação");
        message.setText("Seu código de recuperação é: " + code);
        message.setFrom("89fe26001@smtp-brevo.com");
        emailSender.send(message);
    }
}
