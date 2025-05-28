package br.com.wishlist.api.core.gateway;

import br.com.wishlist.api.core.domain.WishList;

public interface WishListGateway {
    WishList createWishList(WishList wishList);
}
