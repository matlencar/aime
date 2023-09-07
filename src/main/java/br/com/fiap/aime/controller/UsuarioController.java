package br.com.fiap.aime.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.aime.exception.RestNotFoundException;
import br.com.fiap.aime.model.Credencial;
import br.com.fiap.aime.model.Usuario;
import br.com.fiap.aime.repository.UsuarioRepository;
import jakarta.validation.Valid;

@RestController
// @RequestMapping("/api/usuarios")
public class UsuarioController {
    

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    UsuarioRepository repository; 

    @Autowired
    AuthenticationManager manager;

    @Autowired
    PasswordEncoder encoder;

    @GetMapping
    public List<Usuario> index() {
        return repository.findAll();
    }

    @PostMapping("/api/registrar")
    public ResponseEntity<Usuario> registrar(@RequestBody @Valid Usuario usuario) {
        usuario.setSenha(encoder.encode(usuario.getSenha()));
        repository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

     @PostMapping("/api/login")
    public ResponseEntity<Object> login(@RequestBody @Valid Credencial credencial) {
        
        manager.authenticate(credencial.toAuthentication());
        return ResponseEntity.ok().build();
    }
}

