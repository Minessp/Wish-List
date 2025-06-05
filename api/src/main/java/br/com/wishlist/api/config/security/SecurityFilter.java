package br.com.wishlist.api.config.security;

import br.com.wishlist.api.core.domain.User;
import br.com.wishlist.api.core.gateway.TokenGateway;
import br.com.wishlist.api.infrastructure.gateway.UserDetailsServiceImpl;
import br.com.wishlist.api.infrastructure.persistence.repositories.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    private final TokenGateway tokenGateway;
    private final UserRepository userRepository;
    private final UserDetailsServiceImpl userDetailsService;

    public SecurityFilter(TokenGateway tokenGateway, UserRepository userRepository,
                          UserDetailsServiceImpl userDetailsService) {
        this.tokenGateway = tokenGateway;
        this.userRepository = userRepository;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String token = this.getToken(request);
        if (token != null) {
            String subject = tokenGateway.validateToken(token);

            UUID subjectUUID = UUID.fromString(subject);
            User userBase = userRepository.findUserById(subjectUUID);

            UserDetails user = userDetailsService.loadUserByUsername(userBase.username());

            var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

    private String getToken(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return null;
        }
        return authHeader.replace("Bearer ", "");
    }
}
