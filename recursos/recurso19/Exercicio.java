package com.company.testes.recurso19;

import java.io.Serializable;

public class Exercicio implements Serializable {
    private Atividade actividade;
    private String professor;
    private String codExercicio;

    public Atividade getActividade() {
        return actividade;
    }

    public String getProfessor() {
        return professor;
    }
}
