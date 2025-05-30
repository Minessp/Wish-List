package br.com.wishlist.api.core.usecases.user;

import br.com.wishlist.api.core.domain.User;

import java.util.List;

public interface getAllUsersCase {
    List<User> execute();
}
