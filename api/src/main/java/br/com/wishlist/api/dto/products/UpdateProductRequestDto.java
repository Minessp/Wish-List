package br.com.wishlist.api.dto.products;

public record UpdateProductRequestDto(Long productId, ProductDto newProduct) {
}
