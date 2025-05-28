package br.com.wishlist.api.infrastructure.dto.product;

import lombok.Builder;

@Builder
public record CreateProductResponse(String link, String name, java.math.BigDecimal price, Long wishListId) {
}
