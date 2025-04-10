package br.com.wishlist.api.controller;

import br.com.wishlist.api.model.Email;
import br.com.wishlist.api.service.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Email> sendCode(@RequestBody Email email){
        boolean sendSuccessfully = emailService.sendCode(email);

        if(sendSuccessfully){
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(500).build();
        }
    }
}
