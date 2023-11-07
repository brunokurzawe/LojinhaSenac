package com.senac.LojinhaSenac.service;

import com.senac.LojinhaSenac.model.Cliente;
import com.senac.LojinhaSenac.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente salvar(Cliente entity) {
        return repository.save(entity);
    }

    public List<Cliente> buscaTodos(String filter) {
        return repository.findAll();
    }

    public Cliente buscaPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Cliente alterar(Long id, Cliente entity) {
        return repository.save(entity);
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }
}


