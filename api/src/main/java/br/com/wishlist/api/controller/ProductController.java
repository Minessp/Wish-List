package br.com.wishlist.api.controller;

import br.com.wishlist.api.dto.ProductDto;
import br.com.wishlist.api.dto.UpdateProductRequestDto;
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
    public ResponseEntity<List<ProductDto>> getAllProducts(@RequestBody(required = false) Long wishListId) {
        if(wishListId != null){
            return ResponseEntity.status(200).body(productService.getAllProductsByWishListId(wishListId));
        }
        return ResponseEntity.status(200).body(productService.getAllProducts());
    }

    @PostMapping
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.status(201).body(productService.addProduct(productDto));
    }

    @PutMapping
    public ResponseEntity<ProductDto> updateProduct(@RequestBody UpdateProductRequestDto request) {
        return ResponseEntity.status(200).body(productService.updateProduct(request));
    }

    @DeleteMapping
    public ResponseEntity<ProductDto> deleteProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.status(200).body(productService.deleteProduct(productDto));
    }
}
