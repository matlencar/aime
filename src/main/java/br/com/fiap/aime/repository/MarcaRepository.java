package br.com.fiap.aime.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.aime.model.Marca;

public interface MarcaRepository extends JpaRepository<Marca,Integer>{
    
}
