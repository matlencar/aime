package br.com.fiap.aime.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.aime.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria,Integer>{
    
}
