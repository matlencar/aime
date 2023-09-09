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
import br.com.fiap.aime.model.EnderecoEmpresa;
import br.com.fiap.aime.repository.EnderecoEmpresaRepository;
import jakarta.validation.Valid;

import java.util.List;

@RestController
//@RequestMapping("/api/enderecoEmpresas")
public class EnderecoEmpresaController {
        
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    EnderecoEmpresaRepository repository; // IoD

    @GetMapping("/api/enderecoEmpresas")
    public List<EnderecoEmpresa> index() {
        return repository.findAll();
    }

    @PostMapping("/api/enderecoEmpresas")
    public ResponseEntity<EnderecoEmpresa> create(@RequestBody @Valid EnderecoEmpresa enderecoEmpresa) {
        log.info("cadastrando EnderecoEmpresa: " + enderecoEmpresa);
        repository.save(enderecoEmpresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoEmpresa);
    }

    @GetMapping("/api/enderecoEmpresas/{id}")
    public ResponseEntity<EnderecoEmpresa> show(@PathVariable Integer id) {
        log.info("buscando EnderecoEmpresa com id " + id);
        return ResponseEntity.ok(getEnderecoEmpresa(id));
    }

    @DeleteMapping("/api/enderecoEmpresas/{id}")
    public ResponseEntity<EnderecoEmpresa> destroy(@PathVariable Integer id) {
        log.info("apagando EnderecoEmpresa com id " + id);
        var endereco = getEnderecoEmpresa(id);
        repository.delete(endereco);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/api/enderecoEmpresas/{id}")
    public ResponseEntity<EnderecoEmpresa> update(@PathVariable Integer id, @RequestBody @Valid EnderecoEmpresa enderecoEmpresa) {
        log.info("atualizando enderecoEmpresa com id " + id);
        getEnderecoEmpresa(id);
        enderecoEmpresa.setId(id);
        repository.save(enderecoEmpresa);
        return ResponseEntity.ok(enderecoEmpresa);
    }

    private EnderecoEmpresa getEnderecoEmpresa(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("conta não encontrada"));
    }
}
