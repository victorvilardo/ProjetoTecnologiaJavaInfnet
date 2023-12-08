package br.edu.infnet.domain;

import lombok.Data;

@Data
public class Arquivo {

    private String conteudo;

    @Override
    public String toString() {
        return "{" +
            " conteudo='" + getConteudo() + "'" +
            "}";
    }

    
}
