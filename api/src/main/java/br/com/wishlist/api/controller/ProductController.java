package br.com.wishlist.api.controller;

import br.com.wishlist.api.model.Product;
import br.com.wishlist.api.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    private final ProductService productService;

    // Injeção de dependência via construtor
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return ResponseEntity.status(201).body(productService.addProduct(product));
    }
}
