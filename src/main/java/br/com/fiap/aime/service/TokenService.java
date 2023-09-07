package br.com.fiap.aime.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

import org.springframework.beans.factory.annotation.Value;

import br.com.fiap.aime.model.Credencial;
import br.com.fiap.aime.model.Token;
import br.com.fiap.aime.model.Usuario;
import br.com.fiap.aime.repository.UsuarioRepository;
import jakarta.validation.Valid;

@Service
public class TokenService {
    
    @Autowired
    UsuarioRepository repository;

    @Value("${jwt.secret}")
    String secret;

    public Token generateToken(@Valid Credencial credencial) {
        Algorithm alg = Algorithm.HMAC256(secret);
        String token = JWT.create()
        .withSubject(credencial.email())
        .withIssuer("aime")
        .withExpiresAt(Instant.now().plus(1, ChronoUnit.HOURS))
        .sign(alg);
        
        return new Token(token, "JWT", "Bearer");
    }

    public Usuario getValidateUser (String token) {
        Algorithm alg = Algorithm.HMAC256(secret);
        var username = JWT.require(alg)
                        .withIssuer("aime")
                        .build()
                        .verify(token)
                        .getSubject();

        return repository.findByEmail(username)
        .orElseThrow(() -> new JWTVerificationException("Usuario invalido"));
    }
}
