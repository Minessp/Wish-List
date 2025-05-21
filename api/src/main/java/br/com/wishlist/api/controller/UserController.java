package br.com.wishlist.api.controller;

import br.com.wishlist.api.dto.users.*;
import br.com.wishlist.api.exceptions.UserAlreadyExistException;
import br.com.wishlist.api.repository.UserRepository;
import org.hibernate.sql.Update;
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
    public ResponseEntity<List<UserResponse>> getUsers() {
        return ResponseEntity.status(200).body(userService.listAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        return ResponseEntity.status(200).body(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<CreateUserResponse> signUp(@RequestBody CreateUserRequest user) throws UserAlreadyExistException {
        return ResponseEntity.status(201).body(userService.signUp(user));
    }

    @PutMapping
    public ResponseEntity<UserResponse> updateUser(@RequestBody UpdateUserRequest user) throws UserAlreadyExistException {;
        return ResponseEntity.status(200).body(userService.updateUser(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.status(200).body("Deleção bem sucedida");
    }
}
