package br.com.wishlist.api.infrastructure.mapper.wishlist;

import br.com.wishlist.api.core.domain.WishList;
import br.com.wishlist.api.infrastructure.dto.wishlist.CreateWishListRequest;
import br.com.wishlist.api.infrastructure.dto.wishlist.CreateWishListResponse;

public class WishListDTOMapper {
    public CreateWishListResponse toResponse(WishList wishList) {
        return CreateWishListResponse
                .builder()
                .name(wishList.name())
                .userid(wishList.user())
                .build();
    }

    public WishList toWishList(CreateWishListRequest request) {
        return new WishList(request.name(), null);
    }
}
