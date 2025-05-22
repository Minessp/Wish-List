package br.com.wishlist.api.service;

import br.com.wishlist.api.dto.products.CreateProductRequest;
import br.com.wishlist.api.dto.products.CreateProductResponse;
import br.com.wishlist.api.dto.products.ProductResponse;
import br.com.wishlist.api.dto.products.UpdateProductRequest;
import br.com.wishlist.api.model.Product;
import br.com.wishlist.api.repository.ProductRepository;
import br.com.wishlist.api.repository.WishListRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final WishListRepository wishListRepository;

    public ProductService(ProductRepository productRepository, WishListRepository wishListRepository) {
        this.productRepository = productRepository;
        this.wishListRepository = wishListRepository;
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream().map(product ->
                ProductResponse
                        .builder()
                        .id(product.getId())
                        .link(product.getLink())
                        .name(product.getName())
                        .price(product.getPrice())
                        .wishListId(product.getWishList().getId())
                        .build())
                .collect(Collectors.toList());
    }

    public List<ProductResponse> getProductsByWishListId(Long wishListId) {
        return productRepository.findAllByWishListId(wishListId).stream().map(product ->
                ProductResponse
                        .builder()
                        .id(product.getId())
                        .link(product.getLink())
                        .name(product.getName())
                        .price(product.getPrice())
                        .wishListId(product.getWishList().getId())
                        .build())
                .collect(Collectors.toList());
    }

    public CreateProductResponse addProduct(CreateProductRequest request) {
        if(!wishListRepository.existsById(request.wishListId())) {
            throw new IllegalArgumentException("Wishlist not found using wishlistId: " + request.wishListId());
        }

        productRepository.save(new Product(request.link(), request.name(),
                request.price(), wishListRepository.getById(request.wishListId())));

        return CreateProductResponse
                .builder()
                .link(request.link())
                .name(request.name())
                .price(request.price())
                .wishListId(request.wishListId())
                .build();
    }

    public ProductResponse updateProduct(UpdateProductRequest request) {
        if(!productRepository.existsById(request.id())) {
            throw new IllegalArgumentException("Product not found using id: " + request.id());
        }

        Product product = productRepository.getProductById(request.id());

        if(request.link() != null && !request.link().trim().isEmpty()) {
            product.setLink(request.link());
        }

        if(request.name() != null && !request.name().trim().isEmpty()) {
            product.setName(request.name());
        }

        if(request.price() != null) {
            product.setPrice(request.price());
        }

        productRepository.save(product);

        return ProductResponse
                .builder()
                .id(product.getId())
                .link(product.getLink())
                .name(product.getName())
                .price(product.getPrice())
                .wishListId(product.getWishList().getId())
                .build();
    }

    public void deleteProduct(Long id) {
        if(!productRepository.existsById(id)) {
            throw new IllegalArgumentException("Product not found using id: " + id);
        }

        productRepository.delete(productRepository.getProductById(id));
    }
}
