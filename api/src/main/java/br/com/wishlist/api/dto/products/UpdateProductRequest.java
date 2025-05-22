package br.com.wishlist.api.dto.products;

public record UpdateProductRequest(Long id, String link, String name, java.math.BigDecimal price) {
}
