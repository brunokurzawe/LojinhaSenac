package com.senac.LojinhaSenac.service;

import com.senac.LojinhaSenac.enterprise.ValidationException;
import com.senac.LojinhaSenac.model.Cliente;
import com.senac.LojinhaSenac.model.Produto;
import com.senac.LojinhaSenac.repository.ClienteRepository;
import com.senac.LojinhaSenac.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Produto salvar(Produto entity) {

        if(entity.getPrecoCompra() > entity.getPrecoVenda()){
            throw new ValidationException("O preço de compra não pode ser maior que o preço de venda!");
        }

        if(repository.findByDescricao(entity.getDescricao()) != null){
            throw new ValidationException("Já existe um produto com essa descrição cadastrado!");
        }

        return repository.save(entity);
    }

    public List<Produto> buscaTodos() {
        return repository.findAll();
    }

    public Produto buscaPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Produto alterar(Long id, Produto alterado) {
        Optional<Produto> encontrado = repository.findById(id);
        if (encontrado.isPresent()) {
            Produto produto = encontrado.get();
            produto.setDescricao(alterado.getDescricao());
            produto.setPrecoCompra(alterado.getPrecoCompra());
            produto.setPrecoVenda(alterado.getPrecoVenda());
            produto.setNome(alterado.getNome());
            produto.setCor(alterado.getCor());
            produto.setModelo(alterado.getModelo());
            produto.setMarca(alterado.getMarca());
            return repository.save(produto);
        }
        return null;
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }

}
