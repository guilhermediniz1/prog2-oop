package com.mycompany.view;

import javax.swing.*;

public class TelaSentencas extends JFrame {
    private JLabel labelSentenca = new JLabel("Sentença");
    private JTextArea textAreaSentencas = new JTextArea(5, 20);
    private JScrollPane scrollPaneSentencas = new JScrollPane(textAreaSentencas);
    private JButton botaoSalvar = new JButton("Salvar");

    private JLabel labelListagemDeSentencas = new JLabel("Listagem de Sentenças");
    private JLabel labelBuscaExpressao = new JLabel("Busca por expressão:");
    private JTextField textFieldBusca = new JTextField(20);
    private JButton botaoBuscar = new JButton("Buscar");

    private JButton botaoListar = new JButton("Listar todas");
    private JTextArea textAreaResultado = new JTextArea(5, 20);
    private JScrollPane scrollPaneResultado = new JScrollPane(textAreaResultado);



    public TelaSentencas() {
        inicializar();
    }

    public void inicializar() {
        setTitle("Contagem de Sentenças");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(labelSentenca)
                        .addComponent(scrollPaneSentencas)
                        .addComponent(botaoSalvar)
                        .addComponent(labelListagemDeSentencas)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(labelBuscaExpressao)
                                .addComponent(textFieldBusca)
                                .addComponent(botaoBuscar))
                        .addComponent(botaoListar)
                        .addComponent(scrollPaneResultado))
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(labelSentenca)
                .addComponent(scrollPaneSentencas)
                .addComponent(botaoSalvar)
                .addComponent(labelListagemDeSentencas)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(labelBuscaExpressao)
                        .addComponent(textFieldBusca)
                        .addComponent(botaoBuscar))
                .addComponent(botaoListar)
                .addComponent(scrollPaneResultado)
        );

        pack();
    }

    public JButton getBotaoSalvar() {
        return botaoSalvar;
    }

    public JButton getBotaoBuscar() {
        return botaoBuscar;
    }

    public JButton getBotaoListar() {
        return botaoListar;
    }

    public JTextArea getTextAreaSentencas() {
        return textAreaSentencas;
    }

    public JTextArea getTextAreaResultado() {
        return textAreaResultado;
    }

    public JTextField getTextFieldBusca() {
        return textFieldBusca;
    }

    public JTextArea getTextPaneResultado() {
        return textAreaResultado;
    }
}
