package br.com.wishlist.api.core.domain;

import java.math.BigDecimal;

public record Product (Long id,
                       String link,
                       String name,
                       BigDecimal price,
                       WishList wishList) {

    public Product(String link, String name, BigDecimal price, WishList wishList){
        this(null, link, name, price, wishList);
    }
}
