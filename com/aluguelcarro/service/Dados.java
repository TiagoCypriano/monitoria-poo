package com.aluguelcarro.service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Dados {

    public static void salvarDados(List<?> lista, String nomeArquivo) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            out.writeObject(lista);
            System.out.println("Dados salvos com sucesso em " + nomeArquivo);
        } catch (IOException i) {
            System.out.println("Erro ao salvar os dados: ");
            i.printStackTrace();
        }
    }

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