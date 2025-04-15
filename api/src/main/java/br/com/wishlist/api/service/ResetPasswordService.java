package br.com.wishlist.api.service;

import br.com.wishlist.api.model.ResetPassword;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ResetPasswordService {
    private final JavaMailSender emailSender;
    private final ResetPassword resetPassword;

    public ResetPasswordService(JavaMailSender emailSender, ResetPassword resetPassword) {
        this.emailSender = emailSender;
        this.resetPassword = resetPassword;
    }

    @Value("${spring.mail.host}")
    private String host;

    public boolean sendCode(ResetPassword resetPassword) {
        resetPassword.generateCode();

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(host);
            message.setTo(resetPassword.getEmail());
            message.setSubject("Código de recuperação");
            message.setText("Seu código de recuperação é: " + resetPassword.getCode());
            emailSender.send(message);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}