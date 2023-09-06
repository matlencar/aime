package br.com.fiap.aime.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.aime.model.Compra;

public interface CompraRepository extends JpaRepository<Compra,Integer>{
    
}
