package br.com.wishlist.api.dto.products;

public record ProductDto(Long id, String link, String name, java.math.BigDecimal price, Long wishListId) {
}
