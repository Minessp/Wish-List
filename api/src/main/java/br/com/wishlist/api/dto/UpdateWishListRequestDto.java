package br.com.wishlist.api.dto;

public record UpdateWishListRequestDto(WishListDto oldWishList, WishListDto newWishList) {
}
