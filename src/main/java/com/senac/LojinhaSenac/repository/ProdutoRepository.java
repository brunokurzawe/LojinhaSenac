package com.senac.LojinhaSenac.repository;

import com.senac.LojinhaSenac.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    public Produto findByDescricao(String descricao);

}
