package br.com.wishlist.api.service;

import br.com.wishlist.api.dto.UserDto;
import br.com.wishlist.api.exceptions.UserAlreadyExistException;
import br.com.wishlist.api.model.User;
import br.com.wishlist.api.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder(); // Impossibilita reversão via hash
    }

    public User signUp(UserDto userDto) throws UserAlreadyExistException {
        if (userRepository.findUserByEmail(userDto.email()) != null
                || userRepository.findUserByUsername(userDto.username()) != null) {
            throw new UserAlreadyExistException("User already exist");
        }

        String encodedPassword = passwordEncoder.encode(userDto.password());
        User user = new User(userDto.username(), userDto.email(), encodedPassword);
        return userRepository.save(user);
    }

    public UserDto deleteUser(Long id) {
        User user = userRepository.getUserById(id);
        userRepository.delete(user);
        return new UserDto(user.getUsername(), user.getEmail(), user.getPassword());
    }

    public List<User> listAllUsers() {
        return userRepository.findAll();
    }
}
