package com.aluguelcarro.model;

import java.io.Serializable;
import java.time.LocalDate;

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
    @Override
    public String toString() {
        return "Cliente: " + cliente.getNome() + " | Veículo: " + veiculo.getModelo() + " | Início: " + dataInicio;
    }
    @Override
    public void gerarRelatorio() {
        System.out.println("--- Relatório de Aluguel ---");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Veículo: " + veiculo.getModelo());
        System.out.println("Data de Início: " + dataInicio);
        System.out.println("Dias Alugados: " + dias);
        System.out.println("Valor Total: R$" + String.format("%.2f", valorTotal));
    }
}