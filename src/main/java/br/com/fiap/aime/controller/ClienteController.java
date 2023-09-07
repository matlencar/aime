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
import br.com.fiap.aime.repository.ClienteRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    ClienteRepository repository; 

    @GetMapping
    public List<Cliente> index() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody @Valid Cliente cliente) {
        log.info("cadastrando novo cliente: " + cliente);
        repository.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @GetMapping("{id}")
    public ResponseEntity<Cliente> show(@PathVariable Integer id) {
        log.info("buscando cliente com o id " + id);
        return ResponseEntity.ok(getCliente(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Cliente> destroy(@PathVariable Integer id) {
        log.info("apagando conta com id " + id);
        repository.delete(getCliente(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Cliente> update(@PathVariable Integer id, @RequestBody @Valid Cliente cliente) {
        log.info("atualizando conta com id " + id);
        getCliente(id);
        cliente.setId(id);
        repository.save(cliente);
        return ResponseEntity.ok(cliente);
    }

    private Cliente getCliente(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("cliente não foi encontrado encontrado"));
    }
}