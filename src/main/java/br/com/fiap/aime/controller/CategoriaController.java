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
import br.com.fiap.aime.model.Categoria;
import br.com.fiap.aime.repository.CategoriaRepository;
import jakarta.validation.Valid;

import java.util.List;

@RestController
// @RequestMapping("/api/categorias")
public class CategoriaController {
    
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    CategoriaRepository repository; 

    @GetMapping("/api/categorias")
    public List<Categoria> index() {
        return repository.findAll();
    }

    @PostMapping("/api/categorias")
    public ResponseEntity<Categoria> create(@RequestBody @Valid Categoria categoria) {
        log.info("cadastrando categoria: " + categoria);
        repository.save(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
    }

    @GetMapping("/api/categorias/{id}")
    public ResponseEntity<Categoria> show(@PathVariable Integer id) {
        log.info("buscando categoria com id " + id);
        return ResponseEntity.ok(getCategoria(id));
    }

    @DeleteMapping("/api/categorias/{id}")
    public ResponseEntity<Categoria> destroy(@PathVariable Integer id) {
        log.info("apagando categoria com id " + id);
        var categoria = getCategoria(id);
        repository.delete(categoria);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/api/categorias/{id}")
    public ResponseEntity<Categoria> update(@PathVariable Integer id, @RequestBody @Valid Categoria categoria) {
        log.info("atualizando categoria com id " + id);
        getCategoria(id);
        categoria.setId(id);
        repository.save(categoria);
        return ResponseEntity.ok(categoria);
    }

    private Categoria getCategoria(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("conta não encontrada"));
    }

}
