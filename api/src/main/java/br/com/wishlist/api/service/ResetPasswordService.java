package br.com.wishlist.api.service;

import br.com.wishlist.api.model.ResetPassword;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Random;

@Service
public class ResetPasswordService {
    private final JavaMailSender emailSender;
    private final ResetPassword resetPassword;
    private final RedisTemplate<String, Object> redisTemplate;

    public ResetPasswordService(JavaMailSender emailSender, ResetPassword resetPassword,
                                RedisTemplate<String, Object> redisTemplate) {
        this.emailSender = emailSender;
        this.resetPassword = resetPassword;
        this.redisTemplate = redisTemplate;
    }

    @Value("${spring.mail.host}")
    private String host;

    public boolean sendCode(ResetPassword resetPassword) {
        String code = String.valueOf(new Random().nextInt(999999));

        redisTemplate.opsForValue().set("Reset code:" + resetPassword.getEmail(), code, Duration.ofMinutes(15));

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(host);
            message.setTo(resetPassword.getEmail());
            message.setSubject("Código de recuperação");
            message.setText("Seu código de recuperação é: " + code);
            emailSender.send(message);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean validateCode(ResetPassword resetPassword) {
        String key = "Reset code:" + resetPassword.getEmail();
        String cachedCode = (String) redisTemplate.opsForValue().get(key);

        if (cachedCode == null) {
            return false;
        }
        return resetPassword.getCode().equals(cachedCode);
    }
}