package br.com.wishlist.api.service;

import br.com.wishlist.api.model.User;
import br.com.wishlist.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User signUp(User user) {
        return userRepository.save(user);
    }
}
