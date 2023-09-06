package br.com.fiap.aime.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.aime.exception.RestNotFoundException;
import br.com.fiap.aime.model.Cliente;
import br.com.fiap.aime.model.TelefoneEmpresa;
import br.com.fiap.aime.repository.TelefoneEmpresaRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/telefoneEmpresa")
public class TelefoneEmpresaController {
    
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    TelefoneEmpresaRepository repository; 

    @GetMapping
    public List<TelefoneEmpresa> index() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<TelefoneEmpresa> create(@RequestBody @Valid TelefoneEmpresa TelefoneEmpresa) {
        log.info("cadastrando novo telefone de cliente: " + TelefoneEmpresa);
        repository.save(TelefoneEmpresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(TelefoneEmpresa);
    }

    @GetMapping("{id}")
    public ResponseEntity<TelefoneEmpresa> show(@PathVariable Integer id) {
        log.info("buscando o telefone do cliente com o id " + id);
        return ResponseEntity.ok(getTelefoneEmpresa(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Cliente> destroy(@PathVariable Integer id) {
        log.info("apagando conta com id " + id);
        repository.delete(getTelefoneEmpresa(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<TelefoneEmpresa> update(@PathVariable Integer id, @RequestBody @Valid TelefoneEmpresa TelefoneEmpresa) {
        log.info("atualizando o telefone do cliente com id " + id);
        getTelefoneEmpresa(id);
        TelefoneEmpresa.setId(id);
        repository.save(TelefoneEmpresa);
        return ResponseEntity.ok(TelefoneEmpresa);
    }

    private TelefoneEmpresa getTelefoneEmpresa(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("Telefone do cliente não foi encontrado encontrado"));
    }
}
