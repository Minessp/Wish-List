package br.com.wishlist.api.service;

import br.com.wishlist.api.model.User;
import br.com.wishlist.api.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder; // Criptografia de senha

    // Injeção de dependência via construtor
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder(); // Impossibilita reversão via hash
    }

    public User signUp(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public boolean validateEmail(User user) {
        return userRepository.findByEmail(user.getEmail()).isPresent();
    }

    public boolean validatePassword(User user) {
        User userDb = userRepository.getUserByEmail(user.getEmail());
        return passwordEncoder.matches(user.getPassword(), userDb.getPassword());
    }

    public boolean validateUser(User user) {
        return validateEmail(user) && validatePassword(user);
    }
}
