package br.com.wishlist.api.core.usecases.user;

import br.com.wishlist.api.core.domain.User;

import java.util.UUID;

public interface GetUserByIdCase {
    User execute(UUID id);
}
