package br.com.wishlist.api.infrastructure.gateway;

import br.com.wishlist.api.core.domain.User;
import br.com.wishlist.api.core.gateway.UserGateway;
import br.com.wishlist.api.infrastructure.mapper.user.UserEntityMapper;
import br.com.wishlist.api.infrastructure.persistence.repositories.UserRepository;
import br.com.wishlist.api.infrastructure.persistence.entities.UserEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserRepositoryGateway implements UserGateway {
    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;
    private final PasswordEncoder passwordEncoder;

    public UserRepositoryGateway(UserRepository userRepository, UserEntityMapper userEntityMapper) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public User createUser(User user) {
        UserEntity userEntity = userEntityMapper.toEntity(user);
        userEntity.setPassword(passwordEncoder.encode(user.password()));
        UserEntity savedUser = userRepository.save(userEntity);
        return userEntityMapper.toDomain(savedUser);
    }
}
