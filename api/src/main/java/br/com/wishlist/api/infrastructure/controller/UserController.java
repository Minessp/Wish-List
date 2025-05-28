package br.com.wishlist.api.infrastructure.controller;

import br.com.wishlist.api.core.domain.User;
import br.com.wishlist.api.core.usecases.user.CreateUserCase;
import br.com.wishlist.api.infrastructure.mapper.user.UserDTOMapper;
import br.com.wishlist.api.infrastructure.dto.user.CreateUserResponse;
import br.com.wishlist.api.infrastructure.dto.user.CreateUserRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final CreateUserCase createUserCase;
    private final UserDTOMapper userDTOMapper;

    public UserController(CreateUserCase createUserCase, UserDTOMapper userDTOMapper) {
        this.createUserCase = createUserCase;
        this.userDTOMapper = userDTOMapper;
    }

    @PostMapping
    public CreateUserResponse createUser(@RequestBody CreateUserRequest request) {
        User user = userDTOMapper.toUser(request);
        return userDTOMapper.toResponse(createUserCase.execute(user));
    }
}
