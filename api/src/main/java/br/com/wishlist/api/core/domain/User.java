package br.com.wishlist.api.core.domain;

import br.com.wishlist.api.core.enums.Role;

import java.util.List;

public record User(Long id,
                   String username,
                   String password,
                   Role roleList,
                   List<WishList> wishlists) {}
