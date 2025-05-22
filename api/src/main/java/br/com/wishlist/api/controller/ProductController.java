package br.com.wishlist.api.controller;

import br.com.wishlist.api.dto.products.CreateProductRequest;
import br.com.wishlist.api.dto.products.CreateProductResponse;
import br.com.wishlist.api.dto.products.ProductResponse;
import br.com.wishlist.api.dto.products.UpdateProductRequest;
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
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        return ResponseEntity.status(200).body(productService.getAllProducts());
    }

    @GetMapping("/{wishListId}")
    public ResponseEntity<List<ProductResponse>> getAllProductsByWishListId(@PathVariable Long wishListId) {
        return ResponseEntity.status(200).body(productService.getProductsByWishListId(wishListId));
    }

    @PostMapping
    public ResponseEntity<CreateProductResponse> addProduct(@RequestBody CreateProductRequest request) {
        return ResponseEntity.status(201).body(productService.addProduct(request));
    }

    @PutMapping
    public ResponseEntity<ProductResponse> updateProduct(@RequestBody UpdateProductRequest request) {
        return ResponseEntity.status(200).body(productService.updateProduct(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.status(200).body("Deleção bem sucedida");
    }
}
