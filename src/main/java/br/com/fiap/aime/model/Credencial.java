package br.com.fiap.aime.model;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

public record Credencial (String username, String senha) {

    public Authentication toAuthentication(){
        return new UsernamePasswordAuthenticationToken(username, senha);
    }
    
}
