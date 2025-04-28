package br.com.wishlist.api.dto;

public record UpdateProductRequestDto(ProductDto oldProduct, ProductDto newProduct) {
}
