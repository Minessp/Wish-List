package br.com.wishlist.api.controller;

import br.com.wishlist.api.dto.wishlists.ListWishListResponse;
import br.com.wishlist.api.dto.wishlists.UpdateWishListRequestDto;
import br.com.wishlist.api.dto.wishlists.CreateWishListRequest;
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
    public ResponseEntity<List<ListWishListResponse>> getWishList() {
        return ResponseEntity.status(200).body(wishListService.getAllWishLists());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<ListWishListResponse>> getWishListById(@PathVariable Long userId) {
        return ResponseEntity.status(200).body(wishListService.getWishListByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<CreateWishListRequest> createWishList(@RequestBody CreateWishListRequest createWishListRequest) {
        return ResponseEntity.status(201).body(wishListService.createWishList(createWishListRequest));
    }

    @PutMapping
    public ResponseEntity<ListWishListResponse> updateWishList(@RequestBody UpdateWishListRequestDto request) {
        return ResponseEntity.status(200).body(wishListService.updateWishList(request));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteWishList(@RequestBody CreateWishListRequest createWishListRequest) {
        wishListService.deleteWishList(createWishListRequest);
        return ResponseEntity.status(200).build();
    }
}
