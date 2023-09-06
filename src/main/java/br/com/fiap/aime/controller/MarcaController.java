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
import br.com.fiap.aime.model.Marca;
import br.com.fiap.aime.repository.MarcaRepository;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/Marcas")
public class MarcaController {
        
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    MarcaRepository repository; // IoD

    @GetMapping
    public List<Marca> index() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Marca> create(@RequestBody @Valid Marca marca) {
        log.info("cadastrando Marca: " + marca);
        repository.save(marca);
        return ResponseEntity.status(HttpStatus.CREATED).body(marca);
    }

    @GetMapping("{id}")
    public ResponseEntity<Marca> show(@PathVariable Integer id) {
        log.info("buscando Marca com id " + id);
        return ResponseEntity.ok(getMarca(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Marca> destroy(@PathVariable Integer id) {
        log.info("apagando Marca com id " + id);
        repository.delete(getMarca(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Marca> update(@PathVariable Integer id, @RequestBody @Valid Marca marca) {
        log.info("atualizando Marca com id " + id);
        getMarca(id);
        marca.setId(id);
        repository.save(marca);
        return ResponseEntity.ok(marca);
    }

    private Marca getMarca(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("conta não encontrada"));
    }
}
