package br.com.wishlist.api.dto.wishlists;

public record CreateWishListRequest(Long id, String name, String username) {
    public CreateWishListRequest(String name, String username) {
        this(null, name, username);
    }
}
