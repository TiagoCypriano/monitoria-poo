package com.aluguelcarro.service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe utilitaria responsavel por gerenciar a persistencia de dados.
 * Utiliza serializacao para salvar e carregar objetos de arquivos.
 *
 * Paradigmas de POO aplicados:
 * - [cite_start]Serializacao: O Java utiliza a serializacao para a leitura e gravacao de objetos[cite: 795].
 * [cite_start]O objeto e transformado em uma sequencia de bytes que pode ser gravada em um stream[cite: 795].
 * - Tratamento de Excecoes: Utiliza blocos try-catch para lidar de forma
 * segura com possiveis erros de entrada e saida de dados (IOException) ou
 * erros de classe ao carregar os objetos (ClassNotFoundException).
 */
public class Dados {

    /**
     * Metodo estatico para salvar uma lista de objetos em um arquivo.
     *
     * @param lista A lista de objetos a ser salva.
     * @param nomeArquivo O nome do arquivo onde os dados serao gravados.
     */
    public static void salvarDados(List<?> lista, String nomeArquivo) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            out.writeObject(lista);
            System.out.println("Dados salvos com sucesso em " + nomeArquivo);
        } catch (IOException i) {
            System.out.println("Erro ao salvar os dados: ");
            i.printStackTrace();
        }
    }

    /**
     * Metodo estatico para carregar uma lista de objetos de um arquivo.
     *
     * @param nomeArquivo O nome do arquivo a partir do qual os dados serao lidos.
     * @return A lista de objetos carregada ou uma nova lista vazia em caso de erro.
     */
    public static List<?> carregarDados(String nomeArquivo) {
        List<?> lista = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            lista = (List<?>) in.readObject();
            System.out.println("Dados carregados com sucesso de " + nomeArquivo);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Arquivo de dados não encontrado ou corrompido. Criando nova lista.");
        }
        return lista;
    }
}