package com.aluguelcarro.service;

import com.aluguelcarro.exception.AluguelInvalidoException;
import com.aluguelcarro.exception.VeiculoNaoDisponivelException;
import com.aluguelcarro.model.Aluguel;
import com.aluguelcarro.model.Cliente;
import com.aluguelcarro.model.Veiculo;



public class ServicoAluguel {
    public Aluguel alugarVeiculo(Cliente cliente, Veiculo veiculo, int dias)
            throws VeiculoNaoDisponivelException, AluguelInvalidoException {

        if (!veiculo.isDisponivel()) {
            throw new VeiculoNaoDisponivelException("O veículo não está disponível.");
        }

        if (dias <= 0) {
            throw new AluguelInvalidoException("O número de dias de aluguel deve ser maior que zero.");
        }

        Aluguel novoAluguel = new Aluguel(cliente, veiculo, dias);

        veiculo.setDisponivel(false);
        cliente.adicionarAluguel(novoAluguel);

        System.out.println("Aluguel realizado com sucesso para " + cliente.getNome());
        return novoAluguel;
    }

    public void devolverVeiculo(Aluguel aluguel) {
        aluguel.getVeiculo().setDisponivel(true);
        System.out.println("Veículo " + aluguel.getVeiculo().getModelo() + " devolvido com sucesso.");
    }
}