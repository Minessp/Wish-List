package br.com.wishlist.api.config;

import br.com.wishlist.api.core.gateway.ProductGateway;
import br.com.wishlist.api.core.usecases.product.CreateProductCase;
import br.com.wishlist.api.core.usecases.product.CreateProductInteractor;
import br.com.wishlist.api.infrastructure.gateway.ProductRepositoryGateway;
import br.com.wishlist.api.infrastructure.mapper.product.ProductDTOMapper;
import br.com.wishlist.api.infrastructure.mapper.product.ProductEntityMapper;
import br.com.wishlist.api.infrastructure.mapper.wishlist.WishListEntityMapper;
import br.com.wishlist.api.infrastructure.persistence.repositories.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {
    @Bean
    ProductGateway productGateway(ProductRepository productRepository, ProductEntityMapper productEntityMapper) {
        return new ProductRepositoryGateway(productRepository, productEntityMapper);
    }

    @Bean
    CreateProductCase createProductCase(ProductGateway productGateway) {
        return new CreateProductInteractor(productGateway);
    }

    @Bean
    ProductEntityMapper productEntityMapper(WishListEntityMapper wishListEntityMapper) {
        return new ProductEntityMapper(wishListEntityMapper);
    }

    @Bean
    ProductDTOMapper productDTOMapper() {
        return new ProductDTOMapper();
    }
}
