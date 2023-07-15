package com.mycompany.controller;

import com.mycompany.model.Sentenca;
import com.mycompany.view.TelaSentencas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControladorSentencas {
    private ArrayList<Sentenca> sentencas = new ArrayList<Sentenca>();
    public ControladorSentencas(ArrayList<Sentenca> sentencas) {
        this.sentencas = sentencas;
        TelaSentencas tela = new TelaSentencas();
        tela.setVisible(true);

        JButton botaoSalvar = tela.getBotaoSalvar();
        JButton botaoBuscar = tela.getBotaoBuscar();
        JButton botaoListar = tela.getBotaoListar();
        JTextArea textAreaSentencas = tela.getTextAreaSentencas();
        JTextArea textAreaResultado = tela.getTextAreaResultado();

        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textAreaSentencas.getText().trim();

                if(text.length() > 0) {
                    salvarSentenca(new Sentenca(sentencas.size() + 1 , text));
                    JOptionPane.showMessageDialog(tela, "Sentença adicionada com sucesso!");
                }
            }
        });

        botaoBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textoBuscado = tela.getTextFieldBusca().getText();

                if(textoBuscado.length() == 0) {
                    JOptionPane.showMessageDialog(tela, "O campo de busca não pode estar vazio!\nFavor informar uma expressão.");
                    return;
                }

                ArrayList<Sentenca> resultado = buscarPorTexto(textoBuscado);

                if(resultado.isEmpty()) {
                    JOptionPane.showMessageDialog(tela, "As sentenças registradas não contém a seguinte expressão: '" + textoBuscado + "'");
                    return;
                }

                String temp = "";

                for (Sentenca sentenca: resultado) {
                    temp += String.format("%s\n", sentenca);
                }
                textAreaResultado.setText(temp);
            }
        });

        botaoListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(getSentencas().length() == 0) {
                    JOptionPane.showMessageDialog(tela, "Não existem sentenças registradas!");
                    return;
                }

                textAreaResultado.setText(getSentencas());
            }
        });
    }

    public void salvarSentenca(Sentenca sentenca) {
        this.sentencas.add(sentenca);
    }

    public String getSentencas() {
        String todasSentencas = "";
        for(Sentenca sentenca : this.sentencas) {
            todasSentencas += (sentenca + "\n");
        }
        return todasSentencas;
    }

    public ArrayList<Sentenca> buscarPorTexto(String textoBuscado) {
        ArrayList<Sentenca> sentencasEncontradas = new ArrayList<Sentenca>();

        for (Sentenca sentenca : sentencas) {
            if(sentenca.getTexto().contains(textoBuscado)) {
                sentencasEncontradas.add(sentenca);
            }
        }

        return sentencasEncontradas;
    }
}
