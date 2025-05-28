package br.com.wishlist.api.infrastructure.mapper.product;

import br.com.wishlist.api.core.domain.Product;
import br.com.wishlist.api.infrastructure.dto.product.CreateProductRequest;
import br.com.wishlist.api.infrastructure.dto.product.CreateProductResponse;

public class ProductDTOMapper {
    public CreateProductResponse toResponse(Product product) {
        return CreateProductResponse
                .builder()
                .link(product.link())
                .name(product.name())
                .price(product.price())
                .wishListId(product.wishList())
                .build();
    }

    public Product toProduct(CreateProductRequest request) {
        return new Product(request.link(), request.name(), request.price(), null);
    }
}
