package br.com.wishlist.api.service;

import br.com.wishlist.api.dto.products.ProductDto;
import br.com.wishlist.api.dto.products.UpdateProductRequestDto;
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

    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream().map(product -> new ProductDto(
                product.getId(), product.getLink(), product.getName(), product.getPrice(), product.getWishList().getId()
        )).collect(Collectors.toList());
    }

    public List<ProductDto> getProductsByWishListId(Long wishListId) {
        return productRepository.findAllByWishListId(wishListId).stream().map(product -> new ProductDto(
                product.getId(), product.getLink(), product.getName(), product.getPrice(), product.getWishList().getId()
        )).collect(Collectors.toList());
    }

    public ProductDto addProduct(ProductDto productDto) {
        productRepository.save(new Product(productDto.link(), productDto.name(),
                productDto.price(), wishListRepository.getById(productDto.wishListId())));

        return productDto;
    }

    public ProductDto updateProduct(UpdateProductRequestDto request) {
        Product product = productRepository.getProductById(request.productId());

        if(request.newProduct().link() != null) {
            product.setLink(request.newProduct().link());
        }
        if(request.newProduct().name() != null) {
            product.setName(request.newProduct().name());
        }
        if(request.newProduct().price() != null) {
            product.setPrice(request.newProduct().price());
        }

        productRepository.save(product);

        return new ProductDto(product.getId(), product.getLink(), product.getName(), product.getPrice(),
                product.getWishList().getId());
    }

    public void deleteProduct(Long id) {
        Product product = productRepository.getProductById(id);
        productRepository.delete(product);
    }
}
