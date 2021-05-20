package com.company.testes.recurso19;

import java.io.Serializable;

public abstract class Atividade implements Serializable, Comparable<Atividade> {
    private String designacao ;
    private double caloriasPorUnidadeTreino ; // calorias
    // por unidade de treino
    public abstract double caloriasGastas (); //o consumo de
// calorias depende de cada actividade espec´ıfica


    public double getCaloriasPorUnidadeTreino() {
        return caloriasPorUnidadeTreino;
    }
    public  abstract Atividade clone();
    public  int compareTo(Atividade a){
        return  Double.compare(this.caloriasGastas(),a.caloriasGastas());
    }
}


