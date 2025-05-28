package br.com.wishlist.api.infrastructure.mapper.user;

import br.com.wishlist.api.core.domain.User;
import br.com.wishlist.api.infrastructure.persistence.entities.UserEntity;

public class UserEntityMapper {

    public UserEntity toEntity(User user) {
        return UserEntity
                .builder()
                .username(user.username())
                .email(user.email())
                .password(user.password())
                .role(user.role())
                .build();
    }

    public User toDomain(UserEntity userEntity) {
        return new User(
                userEntity.getUsername(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.getRole()
        );
    }
}
