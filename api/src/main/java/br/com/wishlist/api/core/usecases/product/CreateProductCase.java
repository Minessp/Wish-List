package br.com.wishlist.api.core.usecases.product;

import br.com.wishlist.api.core.domain.Product;

public interface CreateProductCase {
    Product execute(Product product);
}
