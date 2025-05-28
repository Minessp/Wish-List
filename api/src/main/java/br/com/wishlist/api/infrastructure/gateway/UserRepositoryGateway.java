package br.com.wishlist.api.infrastructure.gateway;

import br.com.wishlist.api.core.domain.User;
import br.com.wishlist.api.core.gateway.UserGateway;
import br.com.wishlist.api.infrastructure.mapper.user.UserEntityMapper;
import br.com.wishlist.api.infrastructure.persistence.UserRepository;
import br.com.wishlist.api.infrastructure.persistence.entities.UserEntity;

public class UserRepositoryGateway implements UserGateway {
    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    public UserRepositoryGateway(UserRepository userRepository, UserEntityMapper userEntityMapper) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public User createUser(User user) {
        UserEntity userEntity = userEntityMapper.toEntity(user);
        UserEntity savedUser = userRepository.save(userEntity);
        return userEntityMapper.toDomain(savedUser);
    }
}
