package br.com.wishlist.api.core.usecases.user;

import br.com.wishlist.api.core.domain.User;
import br.com.wishlist.api.infrastructure.dto.user.UpdateUserRequest;

public interface UpdateUserCase {
    User execute(UpdateUserRequest request);
}
