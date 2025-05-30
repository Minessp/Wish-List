package br.com.wishlist.api.infrastructure.gateway;

import br.com.wishlist.api.core.domain.User;
import br.com.wishlist.api.core.gateway.AuthGateway;
import br.com.wishlist.api.core.gateway.TokenGateway;
import br.com.wishlist.api.infrastructure.dto.auth.AuthRequest;
import br.com.wishlist.api.infrastructure.dto.auth.AuthResponse;
import br.com.wishlist.api.infrastructure.persistence.repositories.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

public class JwtAuthenticateGateway implements AuthGateway {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final TokenGateway tokenGateway;
    private final PasswordEncoder passwordEncoder;

    public JwtAuthenticateGateway(UserRepository userRepository,
                                  AuthenticationManager authenticationManager,
                                  TokenGateway tokenGateway,
                                  PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.tokenGateway = tokenGateway;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AuthResponse authenticate(AuthRequest request) {
        if(!userRepository.existsByEmail(request.email())) {
            throw new IllegalArgumentException("An user with email " + request.email() + " doesn't exist.");
        }

        User user = userRepository.getUserByEmail(request.email());

        if (!passwordEncoder.matches(request.password(), user.password())) {
            throw new RuntimeException("Incorrect Password");
        }

        String token = tokenGateway.generateToken(user);

        return AuthResponse
                .builder()
                .token(token)
                .build();
    }
}
