package com.aluguelcarro.model;

/**
 * Interface que define um contrato para classes que podem gerar relatorios.
 *
 * Paradigmas de POO aplicados:
 * - Polimorfismo: Classes diferentes (Cliente, Veiculo, Aluguel)
 * podem implementar esta interface. Quando o metodo 'gerarRelatorio()' e
 * chamado, o sistema sabe qual versao especifica executar.
 * - Coesao: Agrupa comportamentos semelhantes em um unico lugar, tornando
 * o codigo mais organizado e facil de entender.
 */
public interface Imprimivel {
    void gerarRelatorio();
}