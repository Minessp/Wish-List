package br.com.wishlist.api.core.usecases.wishlist;

import br.com.wishlist.api.core.domain.WishList;
import br.com.wishlist.api.core.gateway.WishListGateway;

public class CreateWishListInteractor implements CreateWishListCase {
    private final WishListGateway wishListGateway;

    public CreateWishListInteractor(WishListGateway wishListGateway) {
        this.wishListGateway = wishListGateway;
    }

    @Override
    public WishList execute(WishList wishList) {
        return wishListGateway.createWishList(wishList);
    }
}
