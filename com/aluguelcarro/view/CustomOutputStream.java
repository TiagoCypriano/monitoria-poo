package com.aluguelcarro.view;

import java.io.OutputStream;
import javax.swing.JTextArea;

/**
 * Classe utilitaria que redireciona a saida padrao do sistema (System.out)
 * para um componente grafico JTextArea.
 *
 * Paradigmas de POO aplicados:
 * - Heranca: 'CustomOutputStream' estende a classe 'OutputStream' do Java,
 * herdando seus comportamentos basicos de saida de dados.
 * - Encapsulamento: O atributo 'textArea' e privado, e seu acesso e gerenciado
 * pela propria classe.
 * - Coesao: Esta classe tem uma unica responsabilidade: gerenciar a saida
 * de dados para um componente grafico, o que a torna coesa e de facil manutencao.
 */
public class CustomOutputStream extends OutputStream {
    private JTextArea textArea;

    public CustomOutputStream(JTextArea textArea) {
        this.textArea = textArea;
    }

    /**
     * Sobrescreve o metodo 'write' da classe pai.
     * Este metodo e chamado toda vez que um byte e escrito no stream,
     * e o redireciona para a area de texto da interface.
     */
    @Override
    public void write(int b) {
        textArea.append(String.valueOf((char) b));
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}