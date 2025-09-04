package com.aluguelcarro.model;

public class Caminhonete extends Veiculo {
    private static final double TAXA_CAMINHONETE = 0.10;

    public Caminhonete(String marca, String modelo, String placa, double precoBaseDiaria) {
        super(marca, modelo, placa, precoBaseDiaria);
    }

    @Override
    public double calcularValorAluguel(int dias) {
        return (getPrecoBaseDiaria() * dias) + (getPrecoBaseDiaria() * dias * TAXA_CAMINHONETE);
    }

    @Override
    public void gerarRelatorio() {
        System.out.println("--- Relatório de Caminhonete ---");
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Placa: " + getPlaca());
        System.out.println("Preço Base Diária: R$" + getPrecoBaseDiaria());
        System.out.println("Taxa Adicional: " + (TAXA_CAMINHONETE * 100) + "%");
        System.out.println("Disponível: " + (isDisponivel() ? "Sim" : "Não"));
    }
}