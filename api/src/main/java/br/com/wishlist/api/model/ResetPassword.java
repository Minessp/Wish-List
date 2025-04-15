package br.com.wishlist.api.model;

import org.springframework.stereotype.Component;
import java.io.Serializable;
import java.util.Random;

@Component
public class ResetPassword implements Serializable {
    private String email;
    private Integer code;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void generateCode() {
        code = new Random().nextInt(999999);
    }
}
