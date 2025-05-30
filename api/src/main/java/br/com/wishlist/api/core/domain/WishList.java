package br.com.wishlist.api.core.domain;

public record WishList(Long id,
                       String name,
                       User user) {

    public WishList(String name, User user){
        this(null, name, user);
    }

    public WishList(String name){
        this(null, name, null);
    }
}
