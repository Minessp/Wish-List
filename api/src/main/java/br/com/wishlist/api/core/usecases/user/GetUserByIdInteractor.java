package br.com.wishlist.api.core.usecases.user;

import br.com.wishlist.api.core.domain.User;
import br.com.wishlist.api.core.gateway.UserGateway;

import java.util.UUID;

public class GetUserByIdInteractor implements GetUserByIdCase {
    private final UserGateway userGateway;

    public GetUserByIdInteractor(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User execute(UUID id) {
        return userGateway.getUsersById(id);
    }
}
