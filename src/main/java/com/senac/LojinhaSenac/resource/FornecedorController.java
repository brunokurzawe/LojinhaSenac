package com.senac.LojinhaSenac.resource;

import com.senac.LojinhaSenac.model.Cliente;
import com.senac.LojinhaSenac.model.Fornecedor;
import com.senac.LojinhaSenac.service.ClienteService;
import com.senac.LojinhaSenac.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService service;

    @PostMapping
    public ResponseEntity create(@RequestBody Fornecedor entity) {
        Fornecedor save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/clientes/" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<Fornecedor> fornecedores = service.buscaTodos();
        return ResponseEntity.ok(fornecedores);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        Fornecedor fornecedor = service.buscaPorId(id);
        return ResponseEntity.ok(fornecedor);
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Fornecedor entity) {
        Fornecedor alterado = service.alterar(id, entity);
        return ResponseEntity.ok().body(alterado);
    }
}
