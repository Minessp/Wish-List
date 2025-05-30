package br.com.wishlist.api.config.security;

import br.com.wishlist.api.core.gateway.AuthGateway;
import br.com.wishlist.api.core.gateway.TokenGateway;
import br.com.wishlist.api.infrastructure.gateway.JwtAuthenticateGateway;
import br.com.wishlist.api.infrastructure.gateway.JwtTokenGateway;
import br.com.wishlist.api.infrastructure.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class JwtConfig {
    @Value("${jwt.secret}")
    private String secret;

    @Bean
    TokenGateway tokenGateway() {
        return new JwtTokenGateway(secret);
    }

    @Bean
    AuthGateway authGateway(UserRepository userRepository,
                            AuthenticationManager authenticationManager,
                            TokenGateway tokenGateway,
                            PasswordEncoder passwordEncoder) {
        return new JwtAuthenticateGateway(userRepository, authenticationManager, tokenGateway, passwordEncoder);
    }
}
