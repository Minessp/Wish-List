package br.com.wishlist.api.service;

import br.com.wishlist.api.dto.users.UpdateUserRequestDto;
import br.com.wishlist.api.dto.users.UserDto;
import br.com.wishlist.api.exceptions.UserAlreadyExistException;
import br.com.wishlist.api.model.User;
import br.com.wishlist.api.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder(); // Impossibilita reversão via hash
    }

    public List<UserDto> listAllUsers() {
        return userRepository.findAll().stream().map(user -> new UserDto(user.getId(), user.getUsername(),
                        user.getEmail(), user.getAuthorities().stream().findFirst().map(
                                GrantedAuthority::getAuthority).orElse("")))
                .collect(Collectors.toList());
    }

    public UserDto getUserById(Long id) {
        User user = userRepository.getUserById(id);
        return new UserDto(user.getId(), user.getUsername(), user.getEmail(), user.getAuthorities().stream().findFirst().map(
                GrantedAuthority::getAuthority).orElse(""));
    }

    public UserDto signUp(UserDto userDto) throws UserAlreadyExistException {
        if (userRepository.findUserByEmail(userDto.email()) != null
                || userRepository.findUserByUsername(userDto.username()) != null) {
            throw new UserAlreadyExistException("User already exist");
        }

        String encodedPassword = passwordEncoder.encode(userDto.password());
        userRepository.save(new User(userDto.username(), userDto.email(), encodedPassword, userDto.role()));
        return new UserDto(userDto.username(), userDto.email(), userDto.role());
    }

    public UserDto updateUser(UpdateUserRequestDto request) {
        User user = userRepository.getUserById(request.id());

        if(request.user().username() != null) {
            user.setUsername(request.user().username());
        }
        if(request.user().email() != null) {
            user.setEmail(request.user().email());
        }

        userRepository.save(user);
        return new UserDto(user.getUsername(), user.getEmail(), user.getRole().name());
    }

    public void deleteUser(Long id) {
        User user = userRepository.getUserById(id);
        userRepository.delete(user);
    }
}
