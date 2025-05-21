package br.com.wishlist.api.security;

import br.com.wishlist.api.dto.AuthDto;
import br.com.wishlist.api.dto.LoginResponseDto;
import br.com.wishlist.api.exceptions.InvalidCredentialsException;
import br.com.wishlist.api.model.User;
import br.com.wishlist.api.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthController(AuthenticationManager authenticationManager,
                          UserRepository userRepository, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    @PostMapping
    public ResponseEntity<Object> login(@RequestBody AuthDto authDto) {
        User user = userRepository.getUserByEmail(authDto.email());

        if (Objects.isNull(user)) {
            throw new InvalidCredentialsException();
        }

        var usernamePassword = new UsernamePasswordAuthenticationToken(user.getUsername(), authDto.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = jwtService.generateToken((User)auth.getPrincipal());

        return ResponseEntity.status(200).body(new LoginResponseDto(token));
    }
}
