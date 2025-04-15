package br.com.wishlist.api.controller;

import br.com.wishlist.api.model.ResetPassword;
import br.com.wishlist.api.service.ResetPasswordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/reset-password")
public class ResetPasswordController {
    private final ResetPasswordService resetPasswordService;

    public ResetPasswordController(ResetPasswordService resetPasswordService) {
        this.resetPasswordService = resetPasswordService;
    }

    @PostMapping(value = "/send-code")
    public ResponseEntity<ResetPassword> sendCode(@RequestBody ResetPassword resetPassword){
        boolean sendSuccessfully = resetPasswordService.sendCode(resetPassword);

        if(sendSuccessfully){
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping(value = "/validate-code")
    public ResponseEntity<ResetPassword> validateCode(@RequestBody ResetPassword resetPassword){
        boolean validateSuccessfully = resetPasswordService.validateCode(resetPassword);

        if(validateSuccessfully){
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(500).build();
        }
    }
}
