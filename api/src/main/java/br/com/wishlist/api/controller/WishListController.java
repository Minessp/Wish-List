package br.com.wishlist.api.controller;

import br.com.wishlist.api.dto.wishlists.UpdateWishListRequestDto;
import br.com.wishlist.api.dto.wishlists.WishListDto;
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
    public ResponseEntity<List<WishListDto>> getWishList() {
        return ResponseEntity.status(200).body(wishListService.getAllWishLists());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<WishListDto>> getWishListById(@PathVariable Long userId) {
        return ResponseEntity.status(200).body(wishListService.getWishListById(userId));
    }

    @PostMapping
    public ResponseEntity<WishListDto> createWishList(@RequestBody WishListDto wishListDto) {
        return ResponseEntity.status(201).body(wishListService.createWishList(wishListDto));
    }

    @PutMapping
    public ResponseEntity<WishListDto> updateWishList(@RequestBody UpdateWishListRequestDto request) {
        return ResponseEntity.status(200).body(wishListService.updateWishList(request));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteWishList(@RequestBody WishListDto wishListDto) {
        wishListService.deleteWishList(wishListDto);
        return ResponseEntity.status(200).build();
    }
}
