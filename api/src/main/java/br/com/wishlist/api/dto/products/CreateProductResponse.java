package br.com.wishlist.api.dto.products;

import lombok.Builder;

@Builder
public record CreateProductResponse(String link, String name, java.math.BigDecimal price, Long wishListId) {
}
