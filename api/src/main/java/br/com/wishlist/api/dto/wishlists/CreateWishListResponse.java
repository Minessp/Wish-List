package br.com.wishlist.api.dto.wishlists;

import lombok.Builder;

@Builder
public record CreateWishListResponse(String name, Long userid) {
}
