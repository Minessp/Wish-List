package br.com.wishlist.api.infrastructure.dto.product;

public record CreateProductRequest(String link, String name, java.math.BigDecimal price, Long wishListId) {
}
