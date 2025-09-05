package com.aluguelcarro.service;

import com.aluguelcarro.exception.AluguelInvalidoException;
import com.aluguelcarro.exception.VeiculoNaoDisponivelException;
import com.aluguelcarro.model.Aluguel;
import com.aluguelcarro.model.Cliente;
import com.aluguelcarro.model.Veiculo;

/**
 * Classe de servico que contem a logica de negocio do sistema de aluguel.
 *
 * Paradigmas de POO aplicados:
 * - Acoplamento Fraco: Esta classe interage com as classes 'Cliente', 'Veiculo'
 * e 'Aluguel', mas e independente de suas implementacoes internas.
 * - Encapsulamento: Nao expoe os detalhes da logica de negocio, que e executada
 * por meio de metodos publicos como 'alugarVeiculo()' e 'devolverVeiculo()'.
 * - Tratamento de Excecoes: Lanca excecoes personalizadas para erros de negocio,
 * garantindo que o programa lide com situacoes inesperadas de forma controlada.
 */
public class ServicoAluguel {
    
    /**
     * Realiza o processo de aluguel de um veiculo.
     *
     * @param cliente O cliente que esta alugando.
     * @param veiculo O veiculo a ser alugado.
     * @param dias A duracao do aluguel.
     * @return O objeto Aluguel recem-criado.
     * @throws VeiculoNaoDisponivelException Se o veiculo ja estiver alugado.
     * @throws AluguelInvalidoException Se a duracao do aluguel for invalida.
     */
    public Aluguel alugarVeiculo(Cliente cliente, Veiculo veiculo, int dias)
            throws VeiculoNaoDisponivelException, AluguelInvalidoException {

        // Logica para verificar a disponibilidade do veiculo.
        if (!veiculo.isDisponivel()) {
            // Lanca uma excecao customizada, que deve ser tratada pelo metodo que a chamou.
            throw new VeiculoNaoDisponivelException("O veiculo nao esta disponivel.");
        }

        // Logica para validar os dados do aluguel.
        if (dias <= 0) {
            throw new AluguelInvalidoException("O numero de dias de aluguel deve ser maior que zero.");
        }

        // Composicao: Cria um novo objeto Aluguel, que e composto por Cliente e Veiculo.
        Aluguel novoAluguel = new Aluguel(cliente, veiculo, dias);

        // Atualiza o estado dos objetos envolvidos.
        veiculo.setDisponivel(false);
        cliente.adicionarAluguel(novoAluguel);

        System.out.println("Aluguel realizado com sucesso para " + cliente.getNome());
        return novoAluguel;
    }

    /**
     * Realiza o processo de devolucao de um veiculo.
     *
     * @param aluguel O objeto Aluguel que sera finalizado.
     */
    public void devolverVeiculo(Aluguel aluguel) {
        // Atualiza o estado do veiculo para disponivel.
        aluguel.getVeiculo().setDisponivel(true);
        System.out.println("Veiculo " + aluguel.getVeiculo().getModelo() + " devolvido com sucesso.");
    }
}