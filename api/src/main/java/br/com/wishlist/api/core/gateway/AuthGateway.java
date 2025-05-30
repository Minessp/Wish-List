package br.com.wishlist.api.core.gateway;

import br.com.wishlist.api.infrastructure.dto.auth.AuthRequest;
import br.com.wishlist.api.infrastructure.dto.auth.AuthResponse;

public interface AuthGateway {
    AuthResponse authenticate(AuthRequest request);
}
