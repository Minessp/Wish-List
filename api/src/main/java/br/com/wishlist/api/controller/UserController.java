package br.com.wishlist.api.controller;

import br.com.wishlist.api.dto.UserDto;
import br.com.wishlist.api.exceptions.UserAlreadyExistException;
import br.com.wishlist.api.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.wishlist.api.service.UserService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUser() {
        return ResponseEntity.status(200).body(userService.listAllUsers());
    }

    @PostMapping()
    public ResponseEntity<User> signUp(@RequestBody UserDto userDto) throws UserAlreadyExistException {
        return ResponseEntity.status(201).body(userService.signUp(userDto));
    }

//    @PutMapping()
//    public ResponseEntity<UserDto> updateUser() {
//
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable Long id) {
        return ResponseEntity.status(200).body(userService.deleteUser(id));
    }
}
