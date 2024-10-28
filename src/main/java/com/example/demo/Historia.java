package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Historia {
    private String introducao;
    private List<String> escolhas = new ArrayList<>();
    private String finalHistoria;

    public Historia(String introducao, String finalHistoria) {
        this.introducao = introducao;
        this.finalHistoria = finalHistoria;
    }

    public String getIntroducao() {
        return introducao;
    }

    public List<String> getEscolhas() {
        return escolhas;
    }

    public String getFinalHistoria() {
        return finalHistoria;
    }

    public void adicionarEscolha(String escolha) {
        escolhas.add(escolha);
    }
}


   




