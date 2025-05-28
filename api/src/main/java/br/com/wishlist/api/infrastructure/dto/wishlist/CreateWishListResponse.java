package br.com.wishlist.api.ref.dto.wishlists;

import lombok.Builder;

@Builder
public record CreateWishListResponse(String name, Long userid) {
}
