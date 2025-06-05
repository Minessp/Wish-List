package br.com.wishlist.api.core.domain;

import br.com.wishlist.api.core.enums.Role;

import java.util.UUID;

public record User(UUID id,
                   String username,
                   String email,
                   String password,
                   Role role) {

    public User(String username, String email, String password, Role role){
        this(null, username, email, password, role);
    }
}
