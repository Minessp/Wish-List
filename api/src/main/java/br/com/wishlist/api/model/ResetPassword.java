package br.com.wishlist.api.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter

@Component
public class ResetPassword {
    private String email;
    private String code;
    private String password;
}
