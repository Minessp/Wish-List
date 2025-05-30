package br.com.wishlist.api.infrastructure.mapper.product;

import br.com.wishlist.api.core.domain.Product;
import br.com.wishlist.api.infrastructure.dto.product.CreateProductRequest;
import br.com.wishlist.api.infrastructure.dto.product.CreateProductResponse;
import br.com.wishlist.api.infrastructure.mapper.wishlist.WishListDTOMapper;
import br.com.wishlist.api.infrastructure.persistence.repositories.WishListRepository;

public class ProductDTOMapper {
    private final WishListDTOMapper wishListDTOMapper;
    private final WishListRepository wishListRepository;

    public ProductDTOMapper(WishListDTOMapper wishListDTOMapper, WishListRepository wishListRepository) {
        this.wishListDTOMapper = wishListDTOMapper;
        this.wishListRepository = wishListRepository;
    }

    public CreateProductResponse toResponse(Product product) {
        return CreateProductResponse
                .builder()
                .link(product.link())
                .name(product.name())
                .price(product.price())
                .wishListId(product.wishList().id())
                .build();
    }

    public Product toProduct(CreateProductRequest request) {
        return new Product(request.link(),
                   request.name(),
                   request.price(),
                   wishListDTOMapper.fromWishListResponseToWishList(
                           wishListRepository.findWishListById(request.wishListId())));
    }
}
