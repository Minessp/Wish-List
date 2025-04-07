package br.com.wishlist.api.controller;

import br.com.wishlist.api.model.Product;
import br.com.wishlist.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping(value = "/add")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }
}
