package br.com.wishlist.api.core.usecases.product;

import br.com.wishlist.api.core.domain.Product;
import br.com.wishlist.api.core.gateway.ProductGateway;

public class CreateProductInteractor implements CreateProductCase {
    private final ProductGateway productGateway;

    public CreateProductInteractor(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    public Product execute(Product product) {
        return productGateway.createProduct(product);
    }
}
