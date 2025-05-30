package br.com.wishlist.api.infrastructure.controller;

import br.com.wishlist.api.core.domain.User;
import br.com.wishlist.api.core.usecases.user.CreateUserCase;
import br.com.wishlist.api.infrastructure.mapper.user.UserDTOMapper;
import br.com.wishlist.api.infrastructure.dto.user.CreateUserResponse;
import br.com.wishlist.api.infrastructure.dto.user.CreateUserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final CreateUserCase createUserCase;
    private final UserDTOMapper userDTOMapper;

    public UserController(CreateUserCase createUserCase, UserDTOMapper userDTOMapper) {
        this.createUserCase = createUserCase;
        this.userDTOMapper = userDTOMapper;
    }

//    @GetMapping
//    public ResponseEntity<List<UserResponse>> getAllUsers() {
//        return ResponseEntity.status(200).body();
//    }

    @PostMapping
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserRequest request) {
        User user = userDTOMapper.fromCreateRequestToUser(request);
        return ResponseEntity.status(201).body(userDTOMapper.fromUserToCreateResponse(createUserCase.execute(user)));
    }
}
