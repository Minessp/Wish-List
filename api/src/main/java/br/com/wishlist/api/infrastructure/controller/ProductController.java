package br.com.wishlist.api.infrastructure.controller;

import br.com.wishlist.api.core.domain.Product;
import br.com.wishlist.api.core.usecases.product.CreateProductCase;
import br.com.wishlist.api.infrastructure.dto.product.CreateProductRequest;
import br.com.wishlist.api.infrastructure.dto.product.CreateProductResponse;
import br.com.wishlist.api.infrastructure.mapper.product.ProductDTOMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final CreateProductCase createProductCase;
    private final ProductDTOMapper productDTOMapper;

    public ProductController(CreateProductCase createProductCase, ProductDTOMapper productDTOMapper){
        this.createProductCase = createProductCase;
        this.productDTOMapper = productDTOMapper;
    }

    @PostMapping
    public ResponseEntity<CreateProductResponse> createProduct(@RequestBody CreateProductRequest request){
        Product product = productDTOMapper.toProduct(request);
        return ResponseEntity.status(201).body(productDTOMapper.toResponse(createProductCase.execute(product)));
    }
}
