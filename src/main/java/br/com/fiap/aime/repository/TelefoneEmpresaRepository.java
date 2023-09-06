package br.com.fiap.aime.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.aime.model.TelefoneEmpresa;

public interface TelefoneEmpresaRepository extends JpaRepository< TelefoneEmpresa, Integer> {
    
}
