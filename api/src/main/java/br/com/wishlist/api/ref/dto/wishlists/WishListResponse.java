package br.com.wishlist.api.dto.wishlists;

import lombok.Builder;

@Builder
public record WishListResponse(Long id, String name, Long userid) {
}
