package br.com.wishlist.api.infrastructure.gateway;

import br.com.wishlist.api.core.domain.User;
import br.com.wishlist.api.core.gateway.TokenGateway;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import java.time.Instant;

public class JwtTokenGateway implements TokenGateway {
    private final String secret;

    public JwtTokenGateway(String secret) {
        this.secret = secret;
    }

    @Override
    public String generateToken(User user) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        try {
            return JWT.create()
                    .withIssuer("Jwt-Generator")
                    .withSubject((user.id().toString()))
                    .withExpiresAt(Instant.now().plusSeconds(3600))
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            throw new RuntimeException("Error when was tried to generate a token", e);
        }
    }

    @Override
    public String validateToken(String token) {
        try {
            return JWT.require(Algorithm.HMAC256(secret))
                    .withIssuer("Jwt-Generator")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException e) {
            return "";
        }
    }
}
