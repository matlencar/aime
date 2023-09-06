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
import br.com.fiap.aime.model.EnderecoTransportadora;
import br.com.fiap.aime.repository.EnderecoTransportadoraRepository;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/EnderecoTransportadoras")
public class EnderecoTransportadoraController {
        
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    EnderecoTransportadoraRepository repository; // IoD

    @PostMapping
    public ResponseEntity<EnderecoTransportadora> create(@RequestBody @Valid EnderecoTransportadora enderecoTransportadora) {
        log.info("cadastrando EnderecoTransportadora: " + enderecoTransportadora);
        repository.save(enderecoTransportadora);
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoTransportadora);
    }

    @GetMapping("{id}")
    public ResponseEntity<EnderecoTransportadora> show(@PathVariable Integer id) {
        log.info("buscando EnderecoTransportadora com id " + id);
        return ResponseEntity.ok(getEnderecoTransportadora(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<EnderecoTransportadora> destroy(@PathVariable Integer id) {
        log.info("apagando EnderecoTransportadora com id " + id);
        repository.delete(getEnderecoTransportadora(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<EnderecoTransportadora> update(@PathVariable Integer id, @RequestBody @Valid EnderecoTransportadora enderecoTransportadora) {
        log.info("atualizando EnderecoTransportadora com id " + id);
        getEnderecoTransportadora(id);
        enderecoTransportadora.setId(id);
        repository.save(enderecoTransportadora);
        return ResponseEntity.ok(enderecoTransportadora);
    }

    private EnderecoTransportadora getEnderecoTransportadora(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("conta não encontrada"));
    }
}
