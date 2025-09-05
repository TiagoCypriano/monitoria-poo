package com.aluguelcarro.model;

/**
 * Classe que representa um carro de passeio, uma especializacao de veiculo.
 *
 * Paradigmas de POO aplicados:
 * - Heranca: 'CarroPasseio' herda de 'Veiculo', o que permite reutilizar
 * atributos como marca, modelo e placa.
 * - Polimorfismo: Sobrescreve o metodo 'calcularValorAluguel()' para aplicar
 * uma logica de calculo de preco especifica para este tipo de veiculo.
 * - Encapsulamento: Utiliza os metodos de acesso (getters) da classe pai
 * para manipular seus atributos.
 */
public class CarroPasseio extends Veiculo {
    // Atributo estatico e final que representa a taxa de aluguel fixa para carros de passeio.
    private static final double TAXA_PASSEIO = 0.05;

    public CarroPasseio(String marca, String modelo, String placa, double precoBaseDiaria) {
        // Chama o construtor da superclasse 'Veiculo' para inicializar os atributos comuns.
        super(marca, modelo, placa, precoBaseDiaria);
    }

    /**
     * Implementacao polimorfica do metodo da classe pai.
     * Calcula o valor do aluguel com base no preco base, adicionando a taxa de carro de passeio.
     */
    @Override
    public double calcularValorAluguel(int dias) {
        return (getPrecoBaseDiaria() * dias) + (getPrecoBaseDiaria() * dias * TAXA_PASSEIO);
    }

    /**
     * Implementacao polimorfica do metodo 'gerarRelatorio()' da interface 'Imprimivel'.
     * Fornece uma saida de dados especifica para carros de passeio.
     */
    @Override
    public void gerarRelatorio() {
        System.out.println("--- Relatorio de Carro de Passeio ---");
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Placa: " + getPlaca());
        System.out.println("Preco Base Diaria: R$" + getPrecoBaseDiaria());
        System.out.println("Taxa Adicional: " + (TAXA_PASSEIO * 100) + "%");
        System.out.println("Disponivel: " + (isDisponivel() ? "Sim" : "Nao"));
    }
}