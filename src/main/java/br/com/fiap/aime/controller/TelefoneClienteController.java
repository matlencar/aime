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
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.aime.exception.RestNotFoundException;
import br.com.fiap.aime.model.Cliente;
import br.com.fiap.aime.model.TelefoneCliente;
import br.com.fiap.aime.repository.TelefoneClienteRepository;
import jakarta.validation.Valid;

@RestController
// @RequestMapping("/api/telefoneCliente")
public class TelefoneClienteController {
    
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    TelefoneClienteRepository repository; 

    @GetMapping("/api/telefoneCliente")
    public List<TelefoneCliente> index() {
        return repository.findAll();
    }

    @PostMapping("/api/telefoneCliente")
    public ResponseEntity<TelefoneCliente> create(@RequestBody @Valid TelefoneCliente telefoneCliente) {
        log.info("cadastrando novo telefone de cliente: " + telefoneCliente);
        repository.save(telefoneCliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(telefoneCliente);
    }

    @GetMapping("/api/telefoneCliente/{id}")
    public ResponseEntity<TelefoneCliente> show(@PathVariable Integer id) {
        log.info("buscando o telefone do cliente com o id " + id);
        return ResponseEntity.ok(getTelefoneCliente(id));
    }

    @DeleteMapping("/api/telefoneCliente/{id}")
    public ResponseEntity<Cliente> destroy(@PathVariable Integer id) {
        log.info("apagando conta com id " + id);
        var telefone = getTelefoneCliente(id);
        repository.delete(telefone);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/api/telefoneCliente/{id}")
    public ResponseEntity<TelefoneCliente> update(@PathVariable Integer id, @RequestBody @Valid TelefoneCliente telefoneCliente) {
        log.info("atualizando o telefone do cliente com id " + id);
        getTelefoneCliente(id);
        telefoneCliente.setId(id);
        repository.save(telefoneCliente);
        return ResponseEntity.ok(telefoneCliente);
    }

    private TelefoneCliente getTelefoneCliente(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("Telefone do cliente não foi encontrado encontrado"));
    }
}
