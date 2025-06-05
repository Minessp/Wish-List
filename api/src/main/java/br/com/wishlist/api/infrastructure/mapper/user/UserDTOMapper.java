package br.com.wishlist.api.infrastructure.mapper.user;

import br.com.wishlist.api.core.domain.User;
import br.com.wishlist.api.core.enums.Role;
import br.com.wishlist.api.infrastructure.dto.user.CreateUserRequest;
import br.com.wishlist.api.infrastructure.dto.user.CreateUserResponse;
import br.com.wishlist.api.infrastructure.dto.user.DeleteUserRequest;
import br.com.wishlist.api.infrastructure.dto.user.UserResponse;

import java.util.List;
import java.util.stream.Collectors;

public class UserDTOMapper {
    public User fromCreateRequestToUser(CreateUserRequest request){
        return new User(
                request.username(),
                request.email(),
                request.password(),
                Role.valueOf(request.role())
        );
    }

    public CreateUserResponse fromUserToCreateResponse(User user) {
        return CreateUserResponse
                .builder()
                .username(user.username())
                .email(user.email())
                .role(user.role().name())
                .build();
    }

    public List<UserResponse> fromUserToUserResponse(List<User> users) {
        return users.stream().map(user -> UserResponse
                .builder()
                        .id(user.id())
                        .username(user.username())
                        .email(user.email())
                        .role(user.role().name())
                        .build())
                        .collect(Collectors.toList());
    }

    public UserResponse fromUserToUserResponse(User user) {
        return UserResponse
                .builder()
                .id(user.id())
                .username(user.username())
                .email(user.email())
                .role(user.role().name())
                .build();
    }

    public User fromDeleteRequestToUser(DeleteUserRequest request) {
        return new User(
                request.id(),
                null,
                null,
                request.password(),
                null
        );
    }
}
