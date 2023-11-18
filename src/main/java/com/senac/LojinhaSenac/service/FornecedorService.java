package com.senac.LojinhaSenac.service;

import com.senac.LojinhaSenac.model.Fornecedor;
import com.senac.LojinhaSenac.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    public Fornecedor salvar(Fornecedor entity) {
        return repository.save(entity);
    }

    public List<Fornecedor> buscaTodos() {
        return repository.findAll();
    }

    public Fornecedor buscaPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Fornecedor alterar(Long id, Fornecedor alterado) {
        Optional<Fornecedor> encontrado = repository.findById(id);
        if (encontrado.isPresent()) {
            Fornecedor cliente = encontrado.get();
            cliente.setCnpj(alterado.getCnpj());
            cliente.setRazaoSocial(alterado.getRazaoSocial());
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
