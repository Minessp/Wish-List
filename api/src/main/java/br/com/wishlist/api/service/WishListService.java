package br.com.wishlist.api.service;

import br.com.wishlist.api.model.WishList;
import br.com.wishlist.api.repository.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishListService {
    @Autowired
    private WishListRepository wishListRepository;

    public WishList createWishList(WishList wishList) {
        return wishListRepository.save(wishList);
    }
}
