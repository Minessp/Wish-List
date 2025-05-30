package br.com.wishlist.api.infrastructure.controller;

import br.com.wishlist.api.core.gateway.AuthGateway;
import br.com.wishlist.api.infrastructure.dto.auth.AuthRequest;
import br.com.wishlist.api.infrastructure.dto.auth.AuthResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthGateway authGateway;

    public AuthController(AuthGateway authGateway) {
        this.authGateway = authGateway;
    }

    @PostMapping
    public ResponseEntity<AuthResponse> auth(@RequestBody AuthRequest request) {
        return ResponseEntity.status(200).body(authGateway.authenticate(request));
    }
}
