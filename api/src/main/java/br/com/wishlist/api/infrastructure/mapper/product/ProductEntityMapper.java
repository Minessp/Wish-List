package br.com.wishlist.api.infrastructure.mapper.product;

import br.com.wishlist.api.core.domain.Product;
import br.com.wishlist.api.infrastructure.mapper.wishlist.WishListEntityMapper;
import br.com.wishlist.api.infrastructure.persistence.entities.ProductEntity;

public class ProductEntityMapper {
    private final WishListEntityMapper wishListEntityMapper;

    public ProductEntityMapper(WishListEntityMapper wishListEntityMapper) {
        this.wishListEntityMapper = wishListEntityMapper;
    }

    public ProductEntity toEntity(Product product) {
         ProductEntity p = ProductEntity
                .builder()
                .id(product.id())
                .link(product.link())
                .name(product.name())
                .price(product.price())
                .wishList(wishListEntityMapper.toEntity(product.wishList()))
                .build();

         return p;
    }

    public Product toDomain(ProductEntity productEntity) {
        return new Product(
               productEntity.getLink(),
               productEntity.getName(),
               productEntity.getPrice(),
               wishListEntityMapper.toDomain(productEntity.getWishList())
        );
    }
}
