package br.com.wishlist.api.core.gateway;

import br.com.wishlist.api.core.domain.User;
import br.com.wishlist.api.infrastructure.dto.user.UpdateUserRequest;

import java.util.List;
import java.util.UUID;

public interface UserGateway {
    User createUser(User user);

    List<User> getUsers();

    User getUsersById(UUID id);

    User updateUser(UpdateUserRequest request);

    String deleteUser(User user);
}
