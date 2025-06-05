package br.com.wishlist.api.core.usecases.user;

import br.com.wishlist.api.core.domain.User;
import br.com.wishlist.api.core.gateway.UserGateway;

import java.util.List;

public class GetAllUsersInteractor implements GetAllUsersCase {
    private final UserGateway userGateway;

    public GetAllUsersInteractor(final UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public List<User> execute() {
        return userGateway.getUsers();
    }
}
