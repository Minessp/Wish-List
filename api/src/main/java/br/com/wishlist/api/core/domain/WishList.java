package br.com.wishlist.api.core.domain;

import java.util.List;

public record WishList(Long id,
                      String name,
                      User user,
                      List<Product> products) {}
