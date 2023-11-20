package com.senac.LojinhaSenac.resource;

import com.senac.LojinhaSenac.model.Cliente;
import com.senac.LojinhaSenac.model.Produto;
import com.senac.LojinhaSenac.service.ClienteService;
import com.senac.LojinhaSenac.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController extends AbstractController {

    @Autowired
    private ProdutoService service;

    @PostMapping
    public ResponseEntity create(@RequestBody Produto entity) {
        Produto save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/produtos/" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<Produto> produtos = service.buscaTodos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        Produto produto = service.buscaPorId(id);
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Produto entity) {
        Produto alterado = service.alterar(id, entity);
        return ResponseEntity.ok().body(alterado);
    }

}
