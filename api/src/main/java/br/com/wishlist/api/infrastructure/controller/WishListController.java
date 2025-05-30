package br.com.wishlist.api.infrastructure.controller;

import br.com.wishlist.api.core.domain.WishList;
import br.com.wishlist.api.core.usecases.wishlist.CreateWishListCase;
import br.com.wishlist.api.infrastructure.dto.wishlist.CreateWishListRequest;
import br.com.wishlist.api.infrastructure.dto.wishlist.CreateWishListResponse;
import br.com.wishlist.api.infrastructure.mapper.wishlist.WishListDTOMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wishlists")
public class WishListController {
    private final CreateWishListCase createWishListCase;
    private final WishListDTOMapper wishListDTOMapper;

    public WishListController(CreateWishListCase createWishListCase, WishListDTOMapper wishListDTOMapper) {
        this.createWishListCase = createWishListCase;
        this.wishListDTOMapper = wishListDTOMapper;
    }

    @PostMapping
    public ResponseEntity<CreateWishListResponse> createWishList(@RequestBody CreateWishListRequest request) {
        WishList wishList = wishListDTOMapper.fromCreateRequestToWishList(request);
        return ResponseEntity.status(201).body(wishListDTOMapper.fromWishListToCreateResponse(createWishListCase.execute(wishList)));
    }
}
