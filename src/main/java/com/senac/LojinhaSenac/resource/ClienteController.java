package com.senac.LojinhaSenac.resource;

import com.senac.LojinhaSenac.model.Cliente;
import com.senac.LojinhaSenac.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController  {

    @Autowired
    private ClienteService service;

    @PostMapping
    public ResponseEntity create(@RequestBody Cliente entity) {
        Cliente save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/clientes/" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<Cliente> clientes = service.buscaTodos();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        Cliente produto = service.buscaPorId(id);
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Cliente entity) {
            Cliente alterado = service.alterar(id, entity);
            return ResponseEntity.ok().body(alterado);
    }
}

