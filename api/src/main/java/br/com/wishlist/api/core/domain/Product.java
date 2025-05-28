package br.com.wishlist.api.core.domain;

import java.math.BigDecimal;

public record Product (String link,
                       String name,
                       BigDecimal price,
                       WishList wishList) {}
