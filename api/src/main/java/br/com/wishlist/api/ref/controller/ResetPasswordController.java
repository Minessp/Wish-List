package br.com.wishlist.api.controller;

import br.com.wishlist.api.dto.ResetPasswordDto;
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
    public ResponseEntity<ResetPasswordDto> sendCode(@RequestBody ResetPasswordDto resetPasswordDto){
        boolean sendSuccessfully = resetPasswordService.sendCode(resetPasswordDto);

        if(sendSuccessfully){
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(500).build();
    }

    @PostMapping(value = "/validate-code")
    public ResponseEntity<ResetPasswordDto> validateCode(@RequestBody ResetPasswordDto resetPasswordDto){
        boolean validateSuccessfully = resetPasswordService.validateCode(resetPasswordDto);

        if(validateSuccessfully){
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(500).build();
    }

    @PostMapping(value = "/set-password")
    public ResponseEntity<ResetPasswordDto> setPassword(@RequestBody ResetPasswordDto resetPasswordDto){
        boolean resetSuccessfully = resetPasswordService.resetPassword(resetPasswordDto);

        if(resetSuccessfully){
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(500).build();
    }
}
