package br.com.wishlist.api.controller;

import br.com.wishlist.api.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/mail")
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping(value = "/sendcode")
    public ResponseEntity<EmailService> sendCode(@RequestParam String email){
        Integer generatedCode = new Random().nextInt(999999);
        emailService.sendCode(email, generatedCode);

        return ResponseEntity.status(200).build();
    }
}
