package br.com.wishlist.api.dto;

import br.com.wishlist.api.model.User;

public record WishListDto(String name, User user) {
}
