package com.aluguelcarro.exception;

public class VeiculoNaoDisponivelException extends Exception {
    public VeiculoNaoDisponivelException(String mensagem) {
        super(mensagem);
    }
}