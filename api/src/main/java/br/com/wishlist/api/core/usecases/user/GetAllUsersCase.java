package br.com.wishlist.api.core.usecases.user;

import br.com.wishlist.api.core.domain.User;

import java.util.List;

public interface GetAllUsersCase {
    List<User> execute();
}
