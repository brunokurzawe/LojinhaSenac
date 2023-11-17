package com.senac.LojinhaSenac.service;

import com.senac.LojinhaSenac.model.Cliente;
import com.senac.LojinhaSenac.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente salvar(Cliente entity) {
        return repository.save(entity);
    }

    public List<Cliente> buscaTodos() {
        return repository.findAll();
    }

    public Cliente buscaPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Cliente alterar(Long id, Cliente alterado) {
        Optional<Cliente> encontrado = repository.findById(id);
        if(encontrado.isPresent()){
            Cliente cliente = encontrado.get();
            cliente.setCpf(alterado.getCpf());
            cliente.setLimiteCredito(alterado.getLimiteCredito());
            cliente.setNome(alterado.getNome());
            cliente.setEmail(alterado.getEmail());
            cliente.setTelefone(alterado.getTelefone());
            return repository.save(cliente);
        }
        return null;
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }
}


