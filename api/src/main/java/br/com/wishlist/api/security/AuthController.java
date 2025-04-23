package br.com.wishlist.api.security;

import br.com.wishlist.api.dto.AuthDto;
import br.com.wishlist.api.model.User;
import br.com.wishlist.api.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody AuthDto authDto) {
        User user = userRepository.getUserByEmail(authDto.email());
        var usernamePassword = new UsernamePasswordAuthenticationToken(user.getUsername(), authDto.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        return ResponseEntity.status(200).build();
    }
}
