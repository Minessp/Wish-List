package br.com.wishlist.api.infrastructure.gateway;

import br.com.wishlist.api.core.domain.User;
import br.com.wishlist.api.core.gateway.UserGateway;
import br.com.wishlist.api.infrastructure.dto.user.UpdateUserRequest;
import br.com.wishlist.api.infrastructure.mapper.user.UpdateUserMapper;
import br.com.wishlist.api.infrastructure.mapper.user.UserEntityMapper;
import br.com.wishlist.api.infrastructure.persistence.repositories.UserRepository;
import br.com.wishlist.api.infrastructure.persistence.entities.UserEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class UserRepositoryGateway implements UserGateway {
    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;
    private final UpdateUserMapper updateUserMapper;
    private final PasswordEncoder passwordEncoder;

    public UserRepositoryGateway(UserRepository userRepository,
                                 UserEntityMapper userEntityMapper,
                                 UpdateUserMapper updateUserMapper) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
        this.updateUserMapper = updateUserMapper;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public List<User> getUsers() {
        List<UserEntity> usersEntities = userRepository.findAll();
        return usersEntities.stream().map(userEntityMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public User getUsersById(UUID id) {
        if(!userRepository.existsUserEntityById(id)) {
            throw new IllegalArgumentException("User with id " + id + " not exists");
        }

        return userRepository.getUserById(id);
    }

    @Override
    public User createUser(User user) {
        if(!user.email().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("Invalid email address");
        }

        UserEntity userEntity = userEntityMapper.toEntity(user);
        userEntity.setPassword(passwordEncoder.encode(user.password()));
        UserEntity savedUser = userRepository.save(userEntity);
        return userEntityMapper.toDomain(savedUser);
    }

    @Override
    public User updateUser(UpdateUserRequest request) {
        if(!userRepository.existsUserEntityById(request.id()))
            throw new IllegalArgumentException("User with id " + request.id() + " not exists");

        UserEntity user = userRepository.getUserEntityById(request.id());

        if(!passwordEncoder.matches(request.confirmPassword(), user.getPassword()))
            throw new IllegalArgumentException("Your password does not match the current password");

        if(request.username().trim().isEmpty() && !request.email().trim().isEmpty()) {
            updateUserMapper.updateUserEmail(new UpdateUserRequest(
                    request.id(),
                    null,
                    request.email(),
                    null,
                    request.confirmPassword()), user);
        }

        if(!request.username().trim().isEmpty() && request.email().trim().isEmpty()) {
            updateUserMapper.updateUserUsername(new UpdateUserRequest(
                    request.id(),
                    request.username(),
                    null,
                    null,
                    request.confirmPassword()), user);
        }

        if(!request.newPassword().trim().isEmpty()) {
            user.setPassword(passwordEncoder.encode(request.newPassword()));
        }

        userRepository.save(user);
        return userEntityMapper.toDomain(user);
    }

    @Override
    public String deleteUser(User user) {
        if(userRepository.existsUserEntityById(user.id())) {
            userRepository.delete(userEntityMapper.toEntity(user));
        } else throw new IllegalArgumentException("User with id " + user.id() + " not exists");

        if(!userRepository.existsUserEntityById(user.id()))
            return "Delete operation has been successful";

        return "Delete operation has been failed";
    }
}
