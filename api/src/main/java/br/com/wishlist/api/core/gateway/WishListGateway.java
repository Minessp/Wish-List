package br.com.wishlist.api.application.gateway;

import br.com.wishlist.api.core.domain.WishList;

public interface WishListGateway {
    WishList create(WishList wishList);
}
