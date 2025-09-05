/**
 * Classe de exceção personalizada para erros de aluguel.
 *
 * Paradigma: Tratamento de Exceções.
 *
 * Esta classe estende a classe base 'Exception' do Java. Isso a torna uma
 * "exceção verificada" (checked exception)[cite: 604], que deve ser
 * obrigatoriamente tratada por blocos try-catch [cite: 614] ou declarada na assinatura
 * do método com a cláusula 'throws'[cite: 614].
 *
 * O uso de uma exceção personalizada como esta permite que o sistema lide
 * com erros específicos, como um aluguel com duração de zero dias, de forma
 * mais clara e sem interromper abruptamente o fluxo normal do programa.
 */

package com.aluguelcarro.exception;

public class AluguelInvalidoException extends Exception {
    public AluguelInvalidoException(String mensagem) {
        super(mensagem);
    }
}