package br.com.wishlist.api.dto.wishlists;

public record UpdateWishListRequestDto(WishListDto oldWishList, WishListDto newWishList) {
}
