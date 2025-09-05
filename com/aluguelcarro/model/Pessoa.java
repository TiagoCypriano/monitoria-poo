package com.aluguelcarro.model;

import java.io.Serializable;

/**
 * Classe abstrata que serve como base para entidades que representam pessoas no sistema.
 *
 * Paradigmas de POO aplicados:
 * - Heranca: Esta e a superclasse para outras classes, como 'Cliente', que herdam seus atributos.
 * - Abstracao: Nao pode ser instanciada diretamente, mas define uma estrutura comum.
 * - Encapsulamento: Atributos privados e protegidos por metodos de acesso publicos.
 * - Serializacao: Implementa 'Serializable' para que objetos possam ser salvos em arquivos.
 */
public abstract class Pessoa implements Serializable {
    private String nome;
    private String cpf;
    private String telefone;

    public Pessoa(String nome, String cpf, String telefone) {
        // Construtor que inicializa os atributos de forma segura.
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }
}