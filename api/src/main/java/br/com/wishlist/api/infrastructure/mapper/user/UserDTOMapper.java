package br.com.wishlist.api.infrastructure.mapper.user;

import br.com.wishlist.api.core.domain.User;
import br.com.wishlist.api.core.enums.Role;
import br.com.wishlist.api.infrastructure.dto.user.CreateUserRequest;
import br.com.wishlist.api.infrastructure.dto.user.CreateUserResponse;

public class UserDTOMapper {
    public CreateUserResponse toResponse(User user) {
        return CreateUserResponse
                .builder()
                .username(user.username())
                .email(user.email())
                .role(user.role().name())
                .build();
    }

    public User toUser(CreateUserRequest request){
        return new User(
                request.username(),
                request.email(),
                request.password(),
                Role.valueOf(request.role())
        );
    }
}
