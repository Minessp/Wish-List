package br.com.wishlist.api.controller;

import br.com.wishlist.api.dto.products.ProductDto;
import br.com.wishlist.api.dto.products.UpdateProductRequestDto;
import br.com.wishlist.api.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return ResponseEntity.status(200).body(productService.getAllProducts());
    }

    @GetMapping("/{wishListId}")
    public ResponseEntity<List<ProductDto>> getAllProductsByWishListId(@PathVariable Long wishListId) {
        return ResponseEntity.status(200).body(productService.getProductsByWishListId(wishListId));
    }

    @PostMapping
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.status(201).body(productService.addProduct(productDto));
    }

    @PutMapping
    public ResponseEntity<ProductDto> updateProduct(@RequestBody UpdateProductRequestDto request) {
        return ResponseEntity.status(200).body(productService.updateProduct(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.status(200).build();
    }
}
