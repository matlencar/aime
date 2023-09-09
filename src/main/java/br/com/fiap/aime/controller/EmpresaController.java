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
import br.com.fiap.aime.model.Empresa;
import br.com.fiap.aime.repository.EmpresaRepository;
import jakarta.validation.Valid;

import java.util.List;

@RestController
// @RequestMapping("/api/Empresas")
public class EmpresaController {
        
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    EmpresaRepository repository; // IoD

    @GetMapping("/api/empresas")
    public List<Empresa> index() {
        return repository.findAll();
    }

    @PostMapping("/api/empresas")
    public ResponseEntity<Empresa> create(@RequestBody @Valid Empresa empresa) {
        log.info("cadastrando Empresa: " + empresa);
        repository.save(empresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(empresa);
    }

    @GetMapping("/api/empresas/{id}")
    public ResponseEntity<Empresa> show(@PathVariable Integer id) {
        log.info("buscando Empresa com id " + id);
        return ResponseEntity.ok(getEmpresa(id));
    }

    @DeleteMapping("/api/empresas/{id}")
    public ResponseEntity<Empresa> destroy(@PathVariable Integer id) {
        log.info("apagando Empresa com id " + id);
        var empresa = getEmpresa(id);
        repository.delete(empresa);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/api/empresas/{id}")
    public ResponseEntity<Empresa> update(@PathVariable Integer id, @RequestBody @Valid Empresa empresa) {
        log.info("atualizando Empresa com id " + id);
        getEmpresa(id);
        empresa.setId(id);
        repository.save(empresa);
        return ResponseEntity.ok(empresa);
    }

    private Empresa getEmpresa(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RestNotFoundException("conta não encontrada"));
    }
}
