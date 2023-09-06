package br.com.fiap.aime.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.aime.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Integer>{
    
}
