package br.com.wishlist.api.application.gateway;

import br.com.wishlist.api.core.domain.Product;

public interface ProductGateway {
    Product create(Product product);
}
