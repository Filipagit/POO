package com.company.testes.recurso19;

public class Abdominais extends Atividade {
    private int numeroRepeticoes;
    private String tipoExercicio;

    public int getNumeroRepeticoes() {
        return numeroRepeticoes;
    }

    public void setNumeroRepeticoes(int numeroRepeticoes) {
        this.numeroRepeticoes = numeroRepeticoes;
    }

    public String getTipoExercicio() {
        return tipoExercicio;
    }

    public void setTipoExercicio(String tipoExercicio) {
        this.tipoExercicio = tipoExercicio;
    }

    public Abdominais(int numeroRepeticoes, String tipoExercicio){
        this.numeroRepeticoes=numeroRepeticoes;
        this.tipoExercicio=tipoExercicio;
    }
    public Abdominais(){
        this.numeroRepeticoes=0;
        this.tipoExercicio="";
    }
    @Override
    public double caloriasGastas() {
        return this.getCaloriasPorUnidadeTreino() * this.numeroRepeticoes;
    }

}