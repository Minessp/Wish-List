package br.com.wishlist.api.model;

import org.springframework.stereotype.Component;

@Component
public class Email {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
