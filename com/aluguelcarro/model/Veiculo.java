package com.aluguelcarro.model;

import java.io.Serializable;

/**
 * Classe abstrata que define a estrutura e o comportamento comum dos veiculos.
 *
 * Paradigmas de POO aplicados:
 * - Abstracao: Nao pode ser instanciada diretamente, mas serve como um molde
 * para classes mais especificas (CarroPasseio, Caminhonete).
 * - Heranca: Suas subclasses herdam todos os atributos e metodos definidos aqui.
 * - Encapsulamento: Atributos privados garantem que o estado do objeto e
 * controlado por metodos publicos (getters e setters).
 * - Polimorfismo: O metodo 'calcularValorAluguel()' e abstrato, forçando
 * cada subclasse a ter sua propria implementacao unica.
 * - Serializacao: Implementa a interface 'Serializable' para que objetos
 * 'Veiculo' e suas subclasses possam ser salvos em arquivos.
 */
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

    /**
     * Metodo abstrato que define um comportamento polimorfico.
     * As subclasses devem obrigatoriamente implementar sua propria versao
     * para calcular o valor do aluguel.
     */
    public abstract double calcularValorAluguel(int dias);

    /**
     * Sobrescreve o metodo toString() para fornecer uma representacao
     * legivel do objeto, util para a interface do usuario.
     */
    @Override
    public String toString() {
        return getMarca() + " " + getModelo() + " (" + getPlaca() + ")";
    }

    /**
     * Implementacao polimorfica do metodo 'gerarRelatorio()' da interface
     * 'Imprimivel'. Fornece um relatorio base que pode ser estendido
     * pelas subclasses.
     */
    @Override
    public void gerarRelatorio() {
        System.out.println("--- Relatorio de Veiculo ---");
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Placa: " + getPlaca());
        System.out.println("Preco Base Diaria: R$" + getPrecoBaseDiaria());
        System.out.println("Disponivel: " + (isDisponivel() ? "Sim" : "Nao"));
    }
}