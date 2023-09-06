package br.com.fiap.aime.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.aime.model.TelefoneCliente;

public interface TelefoneClienteRepository extends JpaRepository<TelefoneCliente,Integer>{
    
}
