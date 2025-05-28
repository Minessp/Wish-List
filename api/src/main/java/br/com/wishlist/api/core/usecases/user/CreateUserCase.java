package br.com.wishlist.api.core.usecases.user;

import br.com.wishlist.api.core.domain.User;

public interface CreateUserCase {
    User execute(User user);
}
