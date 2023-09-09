package br.com.fiap.aime.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.aime.exception.RestNotFoundException;
import br.com.fiap.aime.model.EnderecoCliente;
import br.com.fiap.aime.repository.EnderecoClienteRepository;
import jakarta.validation.Valid;

import java.util.List;

@RestController
// @RequestMapping("/api/enderecoClientes")
public class EnderecoClienteController {
        
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    EnderecoClienteRepository repository; // IoD

     @GetMapping("/api/enderecoClientes")
    public List<EnderecoCliente> index() {
        return repository.findAll();
    }

    @PostMapping("/api/enderecoClientes")
    public ResponseEntity<EnderecoCliente> create(@RequestBody @Valid EnderecoCliente enderecoCliente) {
        log.info("cadastrando EnderecoCliente: " + enderecoCliente);
        repository.save(enderecoCliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoCliente);
    }

    @GetMapping("/api/enderecoClientes/{id}")
    public ResponseEntity<EnderecoCliente> show(@PathVariable Integer id) {
        log.info("buscando EnderecoCliente com id " + id);
        return ResponseEntity.ok(getEnderecoCliente(id));
    }

    @DeleteMapping("/api/enderecoClientes/{id}")
    public ResponseEntity<EnderecoCliente> destroy(@PathVariable Integer id) {
        log.info("apagando EnderecoCliente com id " + id);
        var endereco =  getEnderecoCliente(id);
        repository.delete(endereco);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/api/enderecoClientes/{id}")
    public ResponseEntity<EnderecoCliente> update(@PathVariable Integer id, @RequestBody @Valid EnderecoCliente enderecoCliente) {
        log.info("atualizando EnderecoCliente com id " + id);
        getEnderecoCliente(id);
        enderecoCliente.setId(id);
        repository.save(enderecoCliente);
        return ResponseEntity.ok(enderecoCliente);
    }

    private EnderecoCliente getEnderecoCliente(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("conta não encontrada"));
    }
}
