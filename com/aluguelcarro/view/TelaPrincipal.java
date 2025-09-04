package com.aluguelcarro.view;

import com.aluguelcarro.exception.AluguelInvalidoException;
import com.aluguelcarro.exception.VeiculoNaoDisponivelException;
import com.aluguelcarro.model.*;
import com.aluguelcarro.service.ServicoAluguel;
import com.aluguelcarro.service.Dados;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.io.PrintStream;

public class TelaPrincipal extends JFrame {
    private ServicoAluguel servicoAluguel;
    private List<Veiculo> frota;
    private List<Cliente> clientes;
    private List<Aluguel> alugueisAtivos;
    private static final String ARQUIVO_CLIENTES = "clientes.ser";
    private static final String ARQUIVO_VEICULOS = "frota.ser";
    private static final String ARQUIVO_ALUGUEIS = "alugueis.ser";

    private JButton btnCadastrarVeiculo, btnCadastrarCliente, btnAlugarVeiculo, 
                    btnListarDisponiveis, btnListarAlugados, btnDevolverVeiculo, btnSair;
    private JTextArea logArea;

    public TelaPrincipal() {
        this.servicoAluguel = new ServicoAluguel();
        this.clientes = (List<Cliente>) Dados.carregarDados(ARQUIVO_CLIENTES);
        this.frota = (List<Veiculo>) Dados.carregarDados(ARQUIVO_VEICULOS);
        this.alugueisAtivos = (List<Aluguel>) Dados.carregarDados(ARQUIVO_ALUGUEIS);
        
        if (clientes == null) clientes = new ArrayList<>();
        if (frota == null) frota = new ArrayList<>();
        if (alugueisAtivos == null) alugueisAtivos = new ArrayList<>();

        initComponents();
    }

    private void initComponents() {
        setTitle("Sistema de Alocacao de Veiculos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new BoxLayout(painelBotoes, BoxLayout.Y_AXIS));
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        btnCadastrarVeiculo = new JButton("Cadastrar Veiculo");
        btnCadastrarCliente = new JButton("Cadastrar Cliente");
        btnAlugarVeiculo = new JButton("Alugar Veiculo");
        btnListarDisponiveis = new JButton("Listar Disponiveis");
        btnListarAlugados = new JButton("Listar Alugados");
        btnDevolverVeiculo = new JButton("Devolver Veiculo");
        btnSair = new JButton("Sair");

        painelBotoes.add(btnCadastrarVeiculo);
        painelBotoes.add(Box.createRigidArea(new Dimension(0, 10)));
        painelBotoes.add(btnCadastrarCliente);
        painelBotoes.add(Box.createRigidArea(new Dimension(0, 10)));
        painelBotoes.add(btnAlugarVeiculo);
        painelBotoes.add(Box.createRigidArea(new Dimension(0, 10)));
        painelBotoes.add(btnListarDisponiveis);
        painelBotoes.add(Box.createRigidArea(new Dimension(0, 10)));
        painelBotoes.add(btnListarAlugados);
        painelBotoes.add(Box.createRigidArea(new Dimension(0, 10)));
        painelBotoes.add(btnDevolverVeiculo);
        painelBotoes.add(Box.createRigidArea(new Dimension(0, 10)));
        painelBotoes.add(btnSair);

        logArea = new JTextArea();
        logArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(logArea);

        Container container = getContentPane();
        container.setLayout(new BorderLayout(10, 10));
        container.add(painelBotoes, BorderLayout.WEST);
        container.add(scrollPane, BorderLayout.CENTER);

        PrintStream printStream = new PrintStream(new CustomOutputStream(logArea));
        System.setOut(printStream);
        System.setErr(printStream);

        btnCadastrarVeiculo.addActionListener(e -> cadastrarVeiculo());
        btnCadastrarCliente.addActionListener(e -> cadastrarCliente());
        btnAlugarVeiculo.addActionListener(e -> alugarVeiculo());
        btnListarDisponiveis.addActionListener(e -> listarVeiculosDisponiveis());
        btnListarAlugados.addActionListener(e -> listarVeiculosAlugados());
        btnDevolverVeiculo.addActionListener(e -> devolverVeiculo());
        btnSair.addActionListener(e -> salvarESair());
    }

    private void cadastrarVeiculo() {
        String tipo = JOptionPane.showInputDialog(this, "Tipo de veiculo (1-Carro de Passeio, 2-Caminhonete):");
        if (tipo == null) return;
        String marca = JOptionPane.showInputDialog(this, "Marca:");
        String modelo = JOptionPane.showInputDialog(this, "Modelo:");
        String placa = JOptionPane.showInputDialog(this, "Placa:");
        String precoStr = JOptionPane.showInputDialog(this, "Preco Diaria:");

        try {
            double preco = Double.parseDouble(precoStr);
            Veiculo novoVeiculo;
            if ("1".equals(tipo)) {
                novoVeiculo = new CarroPasseio(marca, modelo, placa, preco);
            } else if ("2".equals(tipo)) {
                novoVeiculo = new Caminhonete(marca, modelo, placa, preco);
            } else {
                System.out.println("Tipo de veiculo invalido.");
                return;
            }
            frota.add(novoVeiculo);
            System.out.println("Veiculo " + modelo + " cadastrado com sucesso");
        } catch (NumberFormatException e) {
            System.out.println("Entrada de preco invalida.");
        }
    }

    private void cadastrarCliente() {
        String nome = JOptionPane.showInputDialog(this, "Nome do Cliente:");
        String cpf = JOptionPane.showInputDialog(this, "CPF:");
        String telefone = JOptionPane.showInputDialog(this, "Telefone:");

        if (nome != null && !nome.trim().isEmpty()) {
            clientes.add(new Cliente(nome, cpf, telefone));
            System.out.println("Cliente " + nome + " cadastrado com sucesso!");
        } else {
            System.out.println("Nome do cliente nao pode ser vazio.");
        }
    }

    private void alugarVeiculo() {
        if (clientes.isEmpty() || frota.isEmpty()) {
            System.out.println("Nao ha clientes ou veiculos para alugar.");
            return;
        }

        Cliente cliente = (Cliente) JOptionPane.showInputDialog(this, "Selecione o cliente:", "Alugar Veiculo", JOptionPane.QUESTION_MESSAGE, null, clientes.toArray(), clientes.get(0));
        if (cliente == null) return;

        List<Veiculo> disponiveis = new ArrayList<>();
        for (Veiculo v : frota) {
            if (v.isDisponivel()) disponiveis.add(v);
        }
        if (disponiveis.isEmpty()) {
            System.out.println("Nenhum veiculo disponivel no momento.");
            return;
        }

        Veiculo veiculo = (Veiculo) JOptionPane.showInputDialog(this, "Selecione o veiculo:", "Alugar Veiculo", JOptionPane.QUESTION_MESSAGE, null, disponiveis.toArray(), disponiveis.get(0));
        if (veiculo == null) return;

        String diasStr = JOptionPane.showInputDialog(this, "Número de dias para o aluguel:");
        try {
            int dias = Integer.parseInt(diasStr);
            Aluguel novoAluguel = servicoAluguel.alugarVeiculo(cliente, veiculo, dias);
            alugueisAtivos.add(novoAluguel);
            System.out.println("Aluguel de " + veiculo.getModelo() + " realizado com sucesso por " + dias + " dias.");
        } catch (NumberFormatException e) {
            System.out.println("Número de dias invalido.");
        } catch (VeiculoNaoDisponivelException | AluguelInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void devolverVeiculo() {
        if (alugueisAtivos.isEmpty()) {
            System.out.println("Nao ha veiculos alugados para devolver.");
            return;
        }

        Aluguel aluguel = (Aluguel) JOptionPane.showInputDialog(this, "Selecione o aluguel para devolver:", "Devolver Veiculo", JOptionPane.QUESTION_MESSAGE, null, alugueisAtivos.toArray(), alugueisAtivos.get(0));
        if (aluguel == null) return;

        servicoAluguel.devolverVeiculo(aluguel);
        alugueisAtivos.remove(aluguel);
    }
    
    private void listarVeiculosDisponiveis() {
        System.out.println("--- Relatorio de Veiculos Disponiveis ---");
        boolean encontrado = false;
        for (Veiculo v : frota) {
            if (v.isDisponivel()) {
                v.gerarRelatorio();
                System.out.println("--------------------");
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum veiculo disponivel.");
        }
    }
    
    private void listarVeiculosAlugados() {
        System.out.println("--- Relatorio de Veiculos Alugados ---");
        boolean encontrado = false; if (alugueisAtivos.isEmpty()) {
            System.out.println("Nenhum veiculo alugado no momento.");
            return;
        }
        for (Aluguel aluguel : alugueisAtivos) {
            aluguel.gerarRelatorio();
            System.out.println("--------------------");
            encontrado = true;
        }
    }

    private void salvarESair() {
        Dados.salvarDados(clientes, ARQUIVO_CLIENTES);
        Dados.salvarDados(frota, ARQUIVO_VEICULOS);
        Dados.salvarDados(alugueisAtivos, ARQUIVO_ALUGUEIS);
        
        JOptionPane.showMessageDialog(this, "Dados salvos e sistema encerrado.");
        System.exit(0);
    }
}