package br.com.wishlist.api.controller;

import br.com.wishlist.api.model.Email;
import br.com.wishlist.api.service.EmailService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/mail")
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping(value = "/sendcode")
    public void sendCode(@RequestBody Email email){
        emailService.sendCode(email);
    }
}
