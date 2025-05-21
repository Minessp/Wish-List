package br.com.wishlist.api.controller;

import br.com.wishlist.api.dto.users.UpdateUserRequestDto;
import br.com.wishlist.api.dto.users.UserDto;
import br.com.wishlist.api.exceptions.UserAlreadyExistException;
import br.com.wishlist.api.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
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

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        return ResponseEntity.status(200).body(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<UserDto> signUp(@RequestBody UserDto userDto) throws UserAlreadyExistException {
        return ResponseEntity.status(201).body(userService.signUp(userDto));
    }

    @PutMapping
    public ResponseEntity<UserDto> updateUser(@RequestBody UpdateUserRequestDto request) throws UserAlreadyExistException {
        UserDto response = userService.updateUser(request);

        if(response == null) {
            return ResponseEntity.status(400).build();
        }

        return ResponseEntity.status(200).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.status(200).build();
    }
}
