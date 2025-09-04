package com.aluguelcarro.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa implements Imprimivel {
    private List<Aluguel> historicoAlugueis;

    public Cliente(String nome, String cpf, String telefone) {
        super(nome, cpf, telefone);
        this.historicoAlugueis = new ArrayList<>();
    }

    public List<Aluguel> getHistoricoAlugueis() {
        return historicoAlugueis;
    }

    public void adicionarAluguel(Aluguel aluguel) {
        this.historicoAlugueis.add(aluguel);
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + " | CPF: " + getCpf();
    }

    @Override
    public void gerarRelatorio() {
        System.out.println("--- Relatório de Cliente ---");
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("Telefone: " + getTelefone());
    }
}