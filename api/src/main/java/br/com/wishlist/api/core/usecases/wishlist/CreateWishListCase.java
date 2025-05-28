package br.com.wishlist.api.core.usecases.wishlist;

import br.com.wishlist.api.core.domain.WishList;

public interface CreateWishListCase {
    WishList execute(WishList wishList);
}
