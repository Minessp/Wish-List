package br.com.wishlist.api.core.usecases.user;

import br.com.wishlist.api.core.domain.User;

public interface DeleteUserCase {
    String execute(User user);
}
