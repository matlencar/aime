package br.com.fiap.aime.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import br.com.fiap.aime.repository.ClienteRepository;

@Service
public class TokenService {
    
    @Autowired
    ClienteRepository repository;

    @Value("${jwt.secret}")
    String secret;
}
