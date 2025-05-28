package br.com.wishlist.api.core.gateway;

import br.com.wishlist.api.core.domain.Product;

public interface ProductGateway {
    Product createProduct(Product product);
}
