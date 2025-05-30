package br.com.wishlist.api.core.gateway;

import br.com.wishlist.api.core.domain.User;

public interface TokenGateway {
    String generateToken(User user);
    String validateToken(String token);
}
