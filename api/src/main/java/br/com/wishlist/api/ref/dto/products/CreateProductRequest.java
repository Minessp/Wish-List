package br.com.wishlist.api.dto.products;

public record CreateProductRequest(String link, String name, java.math.BigDecimal price, Long wishListId) {
}
