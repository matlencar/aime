package br.com.fiap.aime.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.aime.model.EnderecoCliente;

public interface EnderecoClienteRepository extends JpaRepository<EnderecoCliente,Integer>{
    
}
