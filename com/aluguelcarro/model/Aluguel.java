package com.aluguelcarro.model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Classe que representa uma transação de aluguel de veiculo.
 *
 * Paradigmas de POO aplicados:
 * - Composicao: 'Aluguel' e composto por um 'Cliente' e um 'Veiculo'.
 * - Encapsulamento: Atributos privados com metodos de acesso publicos (getters).
 * - Serializacao: Implementa 'Serializable' para persistir o objeto.
 * - Polimorfismo: Implementa a interface 'Imprimivel' para gerar relatorios.
 */
public class Aluguel implements Serializable, Imprimivel {
    private Cliente cliente;
    private Veiculo veiculo;
    private LocalDate dataInicio;
    private int dias;
    private double valorTotal;

    public Aluguel(Cliente cliente, Veiculo veiculo, int dias) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataInicio = LocalDate.now();
        this.dias = dias;
        this.valorTotal = veiculo.calcularValorAluguel(dias);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public int getDias() {
        return dias;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    /**
     * Sobrescreve o metodo padrao para fornecer uma representacao de string legivel.
     */
    @Override
    public String toString() {
        return "Cliente: " + cliente.getNome() + " | Veiculo: " + veiculo.getModelo() + " | Inicio: " + dataInicio;
    }

    /**
     * Implementa o metodo da interface 'Imprimivel' para gerar um relatorio detalhado.
     * Paradigma: Polimorfismo.
     */
    @Override
    public void gerarRelatorio() {
        System.out.println("--- Relatório de Aluguel ---");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Veiculo: " + veiculo.getModelo());
        System.out.println("Data de Inicio: " + dataInicio);
        System.out.println("Dias Alugados: " + dias);
        System.out.println("Valor Total: RS" + String.format("%.2f", valorTotal));
    }
}