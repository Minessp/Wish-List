package br.com.wishlist.api.core.usecases.user;

import br.com.wishlist.api.core.domain.User;
import br.com.wishlist.api.core.gateway.UserGateway;
import br.com.wishlist.api.infrastructure.dto.user.UpdateUserRequest;

public class UpdateUserInteractor implements UpdateUserCase {
    private final UserGateway userGateway;

    public UpdateUserInteractor(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User execute(UpdateUserRequest request) {
        return userGateway.updateUser(request);
    }
}
