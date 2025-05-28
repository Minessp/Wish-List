package br.com.wishlist.api.application.gateway;

import br.com.wishlist.api.core.domain.User;

public interface UserGateway {
    User create(User user);
}
