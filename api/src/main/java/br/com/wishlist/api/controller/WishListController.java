package br.com.wishlist.api.controller;

import br.com.wishlist.api.model.WishList;
import br.com.wishlist.api.service.WishListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/wishlist")
public class WishListController {
    private final WishListService wishListService;

    // Injeção de dependência via construtor
    public WishListController(WishListService wishListService) {
        this.wishListService = wishListService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<WishList> createWishList(@RequestBody WishList wishList) {
        return ResponseEntity.status(201).body(wishListService.createWishList(wishList));
    }
}
