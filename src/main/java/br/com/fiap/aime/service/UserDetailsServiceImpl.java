package br.com.fiap.aime.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.fiap.aime.model.Cliente;
import br.com.fiap.aime.repository.ClienteRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    ClienteRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
        Cliente cliente = repository.findByEmail(username)
             .orElseThrow(() -> new UsernameNotFoundException("User not found with username" + username));
             return cliente;
	}
}
