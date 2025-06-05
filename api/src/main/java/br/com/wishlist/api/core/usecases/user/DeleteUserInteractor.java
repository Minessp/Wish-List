package br.com.wishlist.api.core.usecases.user;

import br.com.wishlist.api.core.domain.User;
import br.com.wishlist.api.core.gateway.UserGateway;

public class DeleteUserInteractor implements DeleteUserCase {
    private final UserGateway userGateway;

    public DeleteUserInteractor(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public String execute(User user) {
        return userGateway.deleteUser(user);
    }
}
