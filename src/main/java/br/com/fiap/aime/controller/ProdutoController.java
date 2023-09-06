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
import br.com.fiap.aime.model.Produto;
import br.com.fiap.aime.repository.ProdutoRepository;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/Produtos")
public class ProdutoController {
        
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    ProdutoRepository repository; // IoD

    @GetMapping
    public List<Produto> index() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Produto> create(@RequestBody @Valid Produto produto) {
        log.info("cadastrando Produto: " + produto);
        repository.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @GetMapping("{id}")
    public ResponseEntity<Produto> show(@PathVariable Integer id) {
        log.info("buscando Produto com id " + id);
        return ResponseEntity.ok(getProduto(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Produto> destroy(@PathVariable Integer id) {
        log.info("apagando Produto com id " + id);
        repository.delete(getProduto(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Produto> update(@PathVariable Integer id, @RequestBody @Valid Produto produto) {
        log.info("atualizando Produto com id " + id);
        getProduto(id);
        produto.setId(id);
        repository.save(produto);
        return ResponseEntity.ok(produto);
    }

    private Produto getProduto(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("conta não encontrada"));
    }
}
