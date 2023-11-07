package com.senac.LojinhaSenac.model;

import javax.persistence.*;

@Entity
public class Cliente extends Pessoa {

    @Column(name = "cpf", nullable = true)
    private String cpf;
    @Column(name = "limite_credito", nullable = true)
    private Double limiteCredito;

    //getters e setters
}



