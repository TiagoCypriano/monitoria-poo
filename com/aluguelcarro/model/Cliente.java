package com.aluguelcarro.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um cliente do sistema.
 *
 * Paradigmas de POO aplicados:
 * - Heranca: 'Cliente' herda de 'Pessoa', reutilizando atributos e comportamentos comuns.
 * - Composicao/Agregacao: Um cliente "tem" uma lista de alugueis.
 * - Polimorfismo: Implementa a interface 'Imprimivel', fornecendo sua propria versao do metodo 'gerarRelatorio()'.
 * - Encapsulamento: Atributos privados com metodos de acesso publicos, como getNome() e getCpf().
 */
public class Cliente extends Pessoa implements Imprimivel {
    private List<Aluguel> historicoAlugueis;

    public Cliente(String nome, String cpf, String telefone) {
        super(nome, cpf, telefone); // Chama o construtor da superclasse para inicializar os atributos herdados.
        this.historicoAlugueis = new ArrayList<>();
    }

    public List<Aluguel> getHistoricoAlugueis() {
        return historicoAlugueis;
    }

    public void adicionarAluguel(Aluguel aluguel) {
        this.historicoAlugueis.add(aluguel);
    }

    /**
     * Sobrescreve o metodo padrao para fornecer uma representacao de string legivel.
     */
    @Override
    public String toString() {
        return "Nome: " + getNome() + " | CPF: " + getCpf();
    }

    /**
     * Implementacao polimorfica do metodo 'gerarRelatorio()' da interface 'Imprimivel'.
     * Exibe os detalhes especificos do cliente.
     */
    @Override
    public void gerarRelatorio() {
        System.out.println("--- Relatorio de Cliente ---");
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("Telefone: " + getTelefone());
    }
}