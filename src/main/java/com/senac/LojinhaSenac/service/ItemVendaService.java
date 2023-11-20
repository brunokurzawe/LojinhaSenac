package com.senac.LojinhaSenac.service;

import com.senac.LojinhaSenac.model.ItemVenda;
import com.senac.LojinhaSenac.repository.ItemVendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemVendaService {

    @Autowired
    private ItemVendaRepository repository;

    public ItemVenda salvar(ItemVenda entity) {
        return repository.save(entity);
    }

    public List<ItemVenda> buscaTodosPorVenda(Long id) {
        return repository.findAllByVendaId(id);
    }

    public List<ItemVenda> buscaTodos() {
        return repository.findAll();
    }

    public ItemVenda buscaPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public ItemVenda alterar(Long id, ItemVenda alterado) {
        Optional<ItemVenda> encontrado = repository.findById(id);
        if (encontrado.isPresent()) {
            ItemVenda item = encontrado.get();
            item.setDesconto(alterado.getDesconto());
            item.setProduto(alterado.getProduto());
            item.setQuantidade(alterado.getQuantidade());
            item.setVenda(alterado.getVenda());
            return repository.save(item);
        }
        return null;
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }

}
