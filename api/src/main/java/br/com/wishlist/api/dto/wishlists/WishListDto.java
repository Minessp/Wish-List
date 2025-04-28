package br.com.wishlist.api.dto.wishlists;

import br.com.wishlist.api.model.User;

public record WishListDto(String name, User user) {
}
