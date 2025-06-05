package br.com.wishlist.api.infrastructure.controller;

import br.com.wishlist.api.core.domain.User;
import br.com.wishlist.api.core.usecases.user.*;
import br.com.wishlist.api.infrastructure.dto.user.*;
import br.com.wishlist.api.infrastructure.mapper.user.UserDTOMapper;
import org.hibernate.sql.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    private final CreateUserCase createUserCase;
    private final GetAllUsersCase getAllUsersCase;
    private final GetUserByIdCase getUserByIdCase;
    private final UpdateUserCase updateUserCase;
    private final DeleteUserCase deleteUserCase;
    private final UserDTOMapper userDTOMapper;

    public UserController(
            CreateUserCase createUserCase,
            GetAllUsersCase getAllUsersCase,
            GetUserByIdCase getUserByIdCase,
            UpdateUserCase updateUserCase,
            DeleteUserCase deleteUserCase,
            UserDTOMapper userDTOMapper
            ) {
        this.createUserCase = createUserCase;
        this.getAllUsersCase = getAllUsersCase;
        this.getUserByIdCase = getUserByIdCase;
        this.updateUserCase = updateUserCase;
        this.deleteUserCase = deleteUserCase;
        this.userDTOMapper = userDTOMapper;
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.status(200).body(userDTOMapper.fromUserToUserResponse(getAllUsersCase.execute()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable UUID id) {
        return ResponseEntity.status(200).body(userDTOMapper.fromUserToUserResponse(getUserByIdCase.execute(id)));
    }

    @PostMapping
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserRequest request) {
        User user = userDTOMapper.fromCreateRequestToUser(request);
        return ResponseEntity.status(201).body(userDTOMapper.fromUserToCreateResponse(createUserCase.execute(user)));
    }

    @PutMapping
    public ResponseEntity<UserResponse> updateUser(@RequestBody UpdateUserRequest request) {
        return ResponseEntity.status(200).body(userDTOMapper.fromUserToUserResponse(updateUserCase.execute(request)));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteUser(@RequestBody DeleteUserRequest request) {
        return ResponseEntity.status(200).body(deleteUserCase.execute(userDTOMapper.fromDeleteRequestToUser(request)));
    }
}
