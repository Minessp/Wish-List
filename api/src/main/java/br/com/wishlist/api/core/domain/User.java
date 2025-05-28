package br.com.wishlist.api.core.domain;

import br.com.wishlist.api.core.enums.Role;

public record User(String username,
                   String email,
                   String password,
                   Role role) {}
