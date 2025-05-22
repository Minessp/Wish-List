package br.com.wishlist.api.security;

import br.com.wishlist.api.dto.AuthRequest;
import br.com.wishlist.api.dto.AuthResponse;
import br.com.wishlist.api.exceptions.InvalidCredentialsException;
import br.com.wishlist.api.model.User;
import br.com.wishlist.api.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthService(AuthenticationManager authenticationManager, UserRepository userRepository, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public AuthResponse authValidate(AuthRequest request) {
        if(!userRepository.existsByEmail(request.email())) {
            throw new IllegalArgumentException("An user with email " + request.email() + " doesn't exist.");
        }

        User user = userRepository.getUserByEmail(request.email());

        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new InvalidCredentialsException();
        }

        var usernamePassword = new UsernamePasswordAuthenticationToken(user.getUsername(), request.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = jwtService.generateToken((User)auth.getPrincipal());

        return AuthResponse
                .builder()
                .token(token)
                .build();
    }
}
