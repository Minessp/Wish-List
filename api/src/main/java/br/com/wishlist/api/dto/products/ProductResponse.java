package br.com.wishlist.api.dto.products;

import lombok.Builder;

@Builder
public record ProductResponse(Long id, String link, String name, java.math.BigDecimal price, Long wishListId) {
}
