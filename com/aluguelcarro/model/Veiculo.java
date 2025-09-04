package com.aluguelcarro.model;

import java.io.Serializable;

public abstract class Veiculo implements Serializable, Imprimivel {
    private String marca;
    private String modelo;
    private String placa;
    private double precoBaseDiaria;
    private boolean disponivel;

    public Veiculo(String marca, String modelo, String placa, double precoBaseDiaria) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.precoBaseDiaria = precoBaseDiaria;
        this.disponivel = true;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public double getPrecoBaseDiaria() {
        return precoBaseDiaria;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public abstract double calcularValorAluguel(int dias);

    @Override
    public String toString() {
        return getMarca() + " " + getModelo() + " (" + getPlaca() + ")";
    }

    @Override
    public void gerarRelatorio() {
        System.out.println("--- Relatório de Veículo ---");
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Placa: " + getPlaca());
        System.out.println("Preço Base Diária: R$" + getPrecoBaseDiaria());
        System.out.println("Disponível: " + (isDisponivel() ? "Sim" : "Não"));
    }
}