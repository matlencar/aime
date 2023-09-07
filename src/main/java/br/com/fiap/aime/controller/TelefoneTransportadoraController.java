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
import br.com.fiap.aime.model.TelefoneTransportadora;
import br.com.fiap.aime.repository.TelefoneTransportadoraRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/telefoneTransportadora")
public class TelefoneTransportadoraController {
    
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    TelefoneTransportadoraRepository repository; 

    @GetMapping
    public List<TelefoneTransportadora> index() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<TelefoneTransportadora> create(@RequestBody @Valid TelefoneTransportadora TelefoneTransportadora) {
        log.info("cadastrando novo telefone da transportadora: " + TelefoneTransportadora);
        repository.save(TelefoneTransportadora);
        return ResponseEntity.status(HttpStatus.CREATED).body(TelefoneTransportadora);
    }

    @GetMapping("{id}")
    public ResponseEntity<TelefoneTransportadora> show(@PathVariable Integer id) {
        log.info("buscando o telefone da transportadora com o id " + id);
        return ResponseEntity.ok(getTelefoneTransportadora(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Cliente> destroy(@PathVariable Integer id) {
        log.info("apagando o telefone da transportadora com id " + id);
        repository.delete(getTelefoneTransportadora(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<TelefoneTransportadora> update(@PathVariable Integer id, @RequestBody @Valid TelefoneTransportadora TelefoneTransportadora) {
        log.info("atualizando o telefone da transportadora com id " + id);
        getTelefoneTransportadora(id);
        TelefoneTransportadora.setId(id);
        repository.save(TelefoneTransportadora);
        return ResponseEntity.ok(TelefoneTransportadora);
    }

    private TelefoneTransportadora getTelefoneTransportadora(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("Telefone da transportadora não foi encontrado encontrado"));
    }
}