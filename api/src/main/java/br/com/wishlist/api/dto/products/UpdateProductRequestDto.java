package br.com.wishlist.api.dto.products;

public record UpdateProductRequestDto(ProductDto oldProduct, ProductDto newProduct) {
}
