package br.com.wishlist.api.infrastructure.gateway;

import br.com.wishlist.api.core.domain.Product;
import br.com.wishlist.api.core.gateway.ProductGateway;
import br.com.wishlist.api.infrastructure.mapper.product.ProductEntityMapper;
import br.com.wishlist.api.infrastructure.persistence.repositories.ProductRepository;
import br.com.wishlist.api.infrastructure.persistence.entities.ProductEntity;

public class ProductRepositoryGateway implements ProductGateway {
    private final ProductRepository productRepository;
    private final ProductEntityMapper productEntityMapper;

    public ProductRepositoryGateway(ProductRepository productRepository, ProductEntityMapper productEntityMapper) {
        this.productRepository = productRepository;
        this.productEntityMapper = productEntityMapper;
    }

    @Override
    public Product createProduct(Product product) {
        ProductEntity productEntity = productEntityMapper.toEntity(product);
        ProductEntity savedProduct = productRepository.save(productEntity);
        return productEntityMapper.toDomain(savedProduct);
    }
}
