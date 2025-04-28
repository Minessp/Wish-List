package br.com.wishlist.api.dto.products;

import br.com.wishlist.api.model.WishList;

public record ProductDto(String link, String name, java.math.BigDecimal price, WishList wishList) {
}
