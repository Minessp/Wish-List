package br.com.wishlist.api.core.gateway;

import br.com.wishlist.api.core.domain.User;

public interface UserGateway {
    User createUser(User user);
}
