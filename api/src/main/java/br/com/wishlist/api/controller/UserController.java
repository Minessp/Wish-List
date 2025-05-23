package br.com.wishlist.api.controller;

import br.com.wishlist.api.dto.users.UpdateUserRequestDto;
import br.com.wishlist.api.dto.users.UserDto;
import br.com.wishlist.api.exceptions.UserAlreadyExistException;
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
    public ResponseEntity<List<UserDto>> getUser() {
        return ResponseEntity.status(200).body(userService.listAllUsers());
    }

    @PostMapping
    public ResponseEntity<UserDto> signUp(@RequestBody UserDto userDto) throws UserAlreadyExistException {
        return ResponseEntity.status(201).body(userService.signUp(userDto));
    }

    @PutMapping
    public ResponseEntity<UserDto> updateUser(@RequestBody UpdateUserRequestDto request) {
        return ResponseEntity.status(200).body(userService.updateUser(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable Long id) {
        return ResponseEntity.status(200).body(userService.deleteUser(id));
    }
}
