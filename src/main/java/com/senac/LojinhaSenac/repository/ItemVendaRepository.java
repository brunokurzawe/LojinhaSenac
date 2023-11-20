package com.senac.LojinhaSenac.repository;

import com.senac.LojinhaSenac.model.ItemVenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemVendaRepository extends JpaRepository<ItemVenda, Long> {

    public List<ItemVenda> findAllByVendaId(Long id);

}
