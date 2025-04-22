package br.com.wishlist.api.security;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthenticateFilter extends OncePerRequestFilter {
    
    @Override
    public void doFilterInternal(HttpServletRequest request,
                         HttpServletResponse response,
                         FilterChain filterChain) throws ServletException, IOException {
        filterChain.doFilter(request, response);
    }
}
