package com.aluguelcarro.model;

public class CarroPasseio extends Veiculo {
    private static final double TAXA_PASSEIO = 0.05;

    public CarroPasseio(String marca, String modelo, String placa, double precoBaseDiaria) {
        super(marca, modelo, placa, precoBaseDiaria);
    }

    @Override
    public double calcularValorAluguel(int dias) {
        return (getPrecoBaseDiaria() * dias) + (getPrecoBaseDiaria() * dias * TAXA_PASSEIO);
    }

    @Override
    public void gerarRelatorio() {
        System.out.println("--- Relatório de Carro de Passeio ---");
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Placa: " + getPlaca());
        System.out.println("Preço Base Diária: R$" + getPrecoBaseDiaria());
        System.out.println("Taxa Adicional: " + (TAXA_PASSEIO * 100) + "%");
        System.out.println("Disponível: " + (isDisponivel() ? "Sim" : "Não"));
    }
}