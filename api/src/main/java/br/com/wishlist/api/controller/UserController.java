package br.com.wishlist.api.controller;

import br.com.wishlist.api.dto.UserDto;
import br.com.wishlist.api.exceptions.UserAlreadyExistException;
import br.com.wishlist.api.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.wishlist.api.service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestBody UserDto userDto) throws UserAlreadyExistException {
        return ResponseEntity.status(201).body(userService.signUp(userDto));
    }
}
