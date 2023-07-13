package com.mycompany.application;

import com.mycompany.controller.ControladorSentencas;
import com.mycompany.model.Sentenca;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Sentenca> sentencas = new ArrayList<Sentenca>();
        ControladorSentencas contole = new ControladorSentencas(sentencas);
    }
}
