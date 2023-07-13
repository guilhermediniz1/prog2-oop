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
        TelaSentencas tela = new TelaSentencas();
        tela.setVisible(true);

        JButton botaoSalvar = tela.getBotaoSalvar();
        JButton botaoBuscar = tela.getBotaoBuscar();
        JButton botaoListar = tela.getBotaoListar();

        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = tela.getTextAreaSentencas().getText();
                salvarSentenca(new Sentenca(text));
            }
        });

        botaoListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tela.getTextPaneResultado().setText(getSentencas());
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
}
