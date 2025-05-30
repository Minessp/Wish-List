package br.com.wishlist.api.core.domain;

import br.com.wishlist.api.core.enums.Role;

public record User(Long id,
                   String username,
                   String email,
                   String password,
                   Role role) {

    public User(String username, String email, String password, Role role){
        this(null, username, email, password, role);
    }
}
