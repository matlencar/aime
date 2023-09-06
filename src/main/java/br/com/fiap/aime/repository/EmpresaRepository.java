package br.com.fiap.aime.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.aime.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa,Integer>{
    
}
