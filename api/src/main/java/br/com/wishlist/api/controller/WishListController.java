package br.com.wishlist.api.controller;

import br.com.wishlist.api.dto.WishListDto;
import br.com.wishlist.api.model.WishList;
import br.com.wishlist.api.service.WishListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/wishlist")
public class WishListController {
    private final WishListService wishListService;

    public WishListController(WishListService wishListService) {
        this.wishListService = wishListService;
    }

    @GetMapping()
    public ResponseEntity<List<WishListDto>> getWishList(@RequestBody(required = false) Long userId) {
        if(userId != null){
            return ResponseEntity.status(200).body(wishListService.getWishListById(userId));
        }
        return ResponseEntity.status(200).body(wishListService.getAllWishLists());
    }

    @PostMapping()
    public ResponseEntity<WishListDto> createWishList(@RequestBody WishListDto wishListDto) {
        return ResponseEntity.status(201).body(wishListService.createWishList(wishListDto));
    }
}
