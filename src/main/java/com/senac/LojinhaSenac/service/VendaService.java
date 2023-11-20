package com.senac.LojinhaSenac.service;

import com.senac.LojinhaSenac.model.Venda;
import com.senac.LojinhaSenac.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    private VendaRepository repository;

    public Venda salvar(Venda entity) {
        return repository.save(entity);
    }

    public List<Venda> buscaTodos() {
        return repository.findAll();
    }

    public Venda buscaPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Venda alterar(Long id, Venda alterado) {
        Optional<Venda> encontrado = repository.findById(id);
        if (encontrado.isPresent()) {
            Venda venda = encontrado.get();
            venda.setDataVenda(alterado.getDataVenda());
            venda.setCliente(alterado.getCliente());
            venda.setObservacao(alterado.getObservacao());

            return repository.save(venda);
        }
        return null;
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }

}
