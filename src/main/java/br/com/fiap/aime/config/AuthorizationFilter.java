package br.com.fiap.aime.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.fiap.aime.service.TokenService;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;

@Component
public class AuthorizationFilter extends OncePerRequestFilter {

    @Autowired
    TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // pegar o token header
        var token = getToken(request);

        // se for valido, autenticar
        if(token != null) {
            // implementar logica para validação do token
            var cliente = tokenService.getValidateUser(token);
            Authentication auth = new  UsernamePasswordAuthenticationToken(cliente.getUsername(), null, cliente.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(auth);
        }

        // chamar o proximo
        filterChain.doFilter(request, response);
    }

    private String getToken(HttpServletRequest request) {
        var header = request.getHeader("Authorization");
        
        if(header == null || header.isEmpty() || !header.startsWith("Bearer ")){ 
            return null;
        }
        
        return header.replace("Bearer ", "");
    }
}