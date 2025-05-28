package br.com.wishlist.api.infrastructure.dto.wishlist;

import lombok.Builder;

@Builder
public record CreateWishListResponse(String name, Long userid) {
}
