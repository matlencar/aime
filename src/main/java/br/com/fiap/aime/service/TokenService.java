package br.com.fiap.aime.service;

import java.time.temporal.ChronoUnit;
import java.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;

import br.com.fiap.aime.repository.ClienteRepository;
import jakarta.validation.Valid;
import br.com.fiap.aime.model.Cliente;
import br.com.fiap.aime.model.Credencial;
import br.com.fiap.aime.model.Token;

@Service
public class TokenService {
    
    @Autowired
    ClienteRepository repository;

    @Value("${jwt.secret}")
    String secret;

    public Token generateToken(@Valid Credencial credencial) {
        
        Algorithm alg = Algorithm.HMAC256(secret);
        String token = JWT.create()
        .withSubject(credencial.username())
        .withIssuer("aime")
        .withExpiresAt(Instant.now().plus(1, ChronoUnit.HOURS))
        .sign(alg); 
        
        return new Token(token, "JWT", "Bearer");
    }

    public Cliente getValidateUser (String token) {
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