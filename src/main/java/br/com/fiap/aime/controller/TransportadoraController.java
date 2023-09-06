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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.aime.exception.RestNotFoundException;
import br.com.fiap.aime.model.Transportadora;
import br.com.fiap.aime.repository.TransportadoraRepository;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/Transportadoras")
public class TransportadoraController {
        
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    TransportadoraRepository repository; // IoD

    @GetMapping
    public List<Transportadora> index() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Transportadora> create(@RequestBody @Valid Transportadora transportadora) {
        log.info("cadastrando Transportadora: " + transportadora);
        repository.save(transportadora);
        return ResponseEntity.status(HttpStatus.CREATED).body(transportadora);
    }

    @GetMapping("{id}")
    public ResponseEntity<Transportadora> show(@PathVariable Integer id) {
        log.info("buscando Transportadora com id " + id);
        return ResponseEntity.ok(getTransportadora(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Transportadora> destroy(@PathVariable Integer id) {
        log.info("apagando Transportadora com id " + id);
        repository.delete(getTransportadora(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Transportadora> update(@PathVariable Integer id, @RequestBody @Valid Transportadora transportadora) {
        log.info("atualizando Transportadora com id " + id);
        getTransportadora(id);
        transportadora.setId(id);
        repository.save(transportadora);
        return ResponseEntity.ok(transportadora);
    }

    private Transportadora getTransportadora(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("conta não encontrada"));
    }
}
