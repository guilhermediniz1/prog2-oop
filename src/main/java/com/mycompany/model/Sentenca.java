package com.mycompany.model;

import java.util.ArrayList;

public class Sentenca {
    private int posicao;
    private String texto;
    private static int TAMANHO_SENTENCA = 80;

    public Sentenca(int posicao, String texto) {
        this.posicao = posicao;
        this.setTexto(texto);
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto.substring(0, Math.min(texto.length(), TAMANHO_SENTENCA));
    }

    @Override
    public String toString() {
        return String.format("%d - %s", this.posicao, this.texto);
    }
}
