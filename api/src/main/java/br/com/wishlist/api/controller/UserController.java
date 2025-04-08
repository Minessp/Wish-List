package br.com.wishlist.api.controller;

import br.com.wishlist.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.wishlist.api.service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;

    // Injeção de dependência via construtor
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestBody User user) {
        return ResponseEntity.status(201).body(userService.signUp(user));
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        boolean validateLogin = userService.validateUser(user);
        if (validateLogin) {
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(401).build();
        }
    }
}
