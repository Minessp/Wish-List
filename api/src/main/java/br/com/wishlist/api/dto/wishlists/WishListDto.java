package br.com.wishlist.api.dto.wishlists;

public record WishListDto(Long id, String name, String username) {
    public WishListDto(String name, String username) {
        this(null, name, username);
    }
}
