/**
 * Classe de exceção personalizada para erros de disponibilidade de veículo.
 *
 * Paradigma: Tratamento de Exceções.
 *
 * Esta classe estende a classe base 'Exception' e é utilizada para sinalizar
 * que um veículo não pode ser alugado porque não está disponível no momento.
 *
 * O uso dessa exceção permite que a lógica do programa, como o método 'alugarVeiculo()',
 * possa interromper a operação de forma segura e controlada, informando o erro
 * de forma clara ao usuário, em vez de deixar que o programa trave. Isso é
 * fundamental para criar sistemas robustos e de fácil manutenção.
 */
package com.aluguelcarro.exception;

public class VeiculoNaoDisponivelException extends Exception {
    public VeiculoNaoDisponivelException(String mensagem) {
        super(mensagem);
    }
}