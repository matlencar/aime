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
import br.com.fiap.aime.model.Compra;
import br.com.fiap.aime.repository.CompraRepository;
import jakarta.validation.Valid;

import java.util.List;

@RestController
// @RequestMapping("/api/compras")
public class CompraController {
        
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    CompraRepository repository; // IoD

    @GetMapping("/api/compras")
    public List<Compra> index() {
        return repository.findAll();
    }

    @PostMapping("/api/compras")
    public ResponseEntity<Compra> create(@RequestBody @Valid Compra compra) {
        log.info("cadastrando Compra: " + compra);
        repository.save(compra);
        return ResponseEntity.status(HttpStatus.CREATED).body(compra);
    }

    @GetMapping("/api/compras/{id}")
    public ResponseEntity<Compra> show(@PathVariable Integer id) {
        log.info("buscando Compra com id " + id);
        return ResponseEntity.ok(getCompra(id));
    }
    
    @PutMapping("/api/compras/{id}")
    public ResponseEntity<Compra> update(@PathVariable Integer id, @RequestBody @Valid Compra compra) {
        log.info("atualizando Compra com id " + id);
        getCompra(id);
        compra.setId(id);
        repository.save(compra);
        return ResponseEntity.ok(compra);
    }

    @DeleteMapping("/api/compras/{id}")
      public ResponseEntity<Compra> destroy(@PathVariable Integer id) {
        log.info("apagando categoria com id " + id);
        var compra = getCompra(id);
        repository.delete(compra);
        return ResponseEntity.noContent().build();
    }

    private Compra getCompra(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("conta não encontrada"));
    }
}
