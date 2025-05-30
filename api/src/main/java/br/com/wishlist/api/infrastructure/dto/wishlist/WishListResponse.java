package br.com.wishlist.api.infrastructure.dto.wishlist;

import lombok.Builder;

@Builder
public record WishListResponse(Long id, String name, Long userId) {
}