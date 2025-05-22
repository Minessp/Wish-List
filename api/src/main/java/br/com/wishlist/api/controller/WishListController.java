package br.com.wishlist.api.controller;

import br.com.wishlist.api.dto.wishlists.*;
import br.com.wishlist.api.service.WishListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/wishlists")
public class WishListController {
    private final WishListService wishListService;

    public WishListController(WishListService wishListService) {
        this.wishListService = wishListService;
    }

    @GetMapping
    public ResponseEntity<List<WishListResponse>> getWishList() {
        return ResponseEntity.status(200).body(wishListService.getAllWishLists());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<WishListResponse>> getWishListById(@PathVariable Long userId) {
        return ResponseEntity.status(200).body(wishListService.getWishListByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<CreateWishListResponse> createWishList(@RequestBody CreateWishListRequest createWishListRequest) {
        return ResponseEntity.status(201).body(wishListService.createWishList(createWishListRequest));
    }

    @PutMapping
    public ResponseEntity<WishListResponse> updateWishList(@RequestBody UpdateWishListRequest request) {
        return ResponseEntity.status(200).body(wishListService.updateWishList(request));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteWishList(@RequestBody DeleteWishListRequest request) {
        wishListService.deleteWishList(request);
        return ResponseEntity.status(200).body("Deleção bem sucedida");
    }
}
