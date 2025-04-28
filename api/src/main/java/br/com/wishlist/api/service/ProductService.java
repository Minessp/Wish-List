package br.com.wishlist.api.service;

import br.com.wishlist.api.dto.products.ProductDto;
import br.com.wishlist.api.dto.products.UpdateProductRequestDto;
import br.com.wishlist.api.model.Product;
import br.com.wishlist.api.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream().map(
                product -> new ProductDto(product.getLink(), product.getName(), product.getPrice(),
                        product.getWishList())).collect(Collectors.toList());
    }

    public List<ProductDto> getAllProductsByWishListId(Long wishListId) {
        return productRepository.findAllByWishListId(wishListId).stream().map(
                product -> new ProductDto(product.getLink(), product.getName(), product.getPrice(),
                        product.getWishList())).collect(Collectors.toList());
    }

    public ProductDto addProduct(ProductDto productDto) {
        productRepository.save(new Product(productDto.link(), productDto.name(),
                productDto.price(), productDto.wishList()));

        return productDto;
    }

    public ProductDto updateProduct(UpdateProductRequestDto request) {
        Product product = productRepository.getProductByNameAndWishListId(request.oldProduct().name(),
                request.oldProduct().wishList().getId());

        if(request.oldProduct().link() != null) {
            product.setLink(request.newProduct().link());
        }
        product.setName(request.newProduct().name());

        if(request.oldProduct().price() != null) {
            product.setPrice(request.newProduct().price());
        }

        productRepository.save(product);

        return new ProductDto(product.getLink(), product.getName(), product.getPrice(), product.getWishList());
    }

    public ProductDto deleteProduct(ProductDto productDto) {
        Product product = productRepository.getProductByNameAndWishListId(productDto.name(),
                productDto.wishList().getId());

        productRepository.delete(product);

        return new ProductDto(product.getLink(), product.getName(), product.getPrice(), product.getWishList());
    }
}
