package com.aluguelcarro.model;

/**
 * Classe que representa uma caminhonete, um tipo especifico de veiculo.
 * * Paradigmas de POO aplicados:
 * - Heranca: 'Caminhonete' herda de 'Veiculo', o que promove o reuso de codigo.
 * - Polimorfismo: Sobrescreve o metodo 'calcularValorAluguel()' para aplicar
 * uma logica de negocio especifica para caminhonetes.
 * - Encapsulamento: Usa atributos e metodos da classe pai que sao protegidos.
 */
public class Caminhonete extends Veiculo {
    // Atributo estatico e final que representa um valor constante para a classe.
    private static final double TAXA_CAMINHONETE = 0.10;

    public Caminhonete(String marca, String modelo, String placa, double precoBaseDiaria) {
        // Chama o construtor da superclasse 'Veiculo' para inicializar os atributos comuns.
        super(marca, modelo, placa, precoBaseDiaria);
    }

    /**
     * Implementacao polimorfica do metodo da classe pai.
     * Calcula o valor do aluguel com base no preco base e na taxa especifica da caminhonete.
     */
    @Override
    public double calcularValorAluguel(int dias) {
        return (getPrecoBaseDiaria() * dias) + (getPrecoBaseDiaria() * dias * TAXA_CAMINHONETE);
    }

    /**
     * Implementacao polimorfica do metodo 'gerarRelatorio()' da interface 'Imprimivel'.
     * Fornece uma saida de dados especifica para a caminhonete.
     */
    @Override
    public void gerarRelatorio() {
        System.out.println("--- Relatorio de Caminhonete ---");
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Placa: " + getPlaca());
        System.out.println("Preco Base Diaria: R$" + getPrecoBaseDiaria());
        System.out.println("Taxa Adicional: " + (TAXA_CAMINHONETE * 100) + "%");
        System.out.println("Disponivel: " + (isDisponivel() ? "Sim" : "Nao"));
    }
}