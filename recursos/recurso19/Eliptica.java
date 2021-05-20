package com.company.testes.recurso19;

public class Eliptica extends Atividade implements ComDistancia {
    private double kmsPercorridos ;
    private double nivelEsforco ;
    private double minutos ;

    @Override
    public double getKmsPercorridos() {
        return kmsPercorridos;
    }

    public double getMinutos() {
        return minutos;
    }

    public double getNivelEsforco() {
        return nivelEsforco;
    }

    public void setKmsPercorridos(double kmsPercorridos) {
        this.kmsPercorridos = kmsPercorridos;
    }

    public void setMinutos(double minutos) {
        this.minutos = minutos;
    }

    public void setNivelEsforco(double nivelEsforco) {
        this.nivelEsforco = nivelEsforco;
    }

    @Override
    public double caloriasGastas() {
        return this.getCaloriasPorUnidadeTreino() * this.kmsPercorridos *(this.nivelEsforco <= 4 ? this.minutos * 0.2 : this.minutos * 0.05);
    }

    @Override
    public Atividade clone() {
        return null;
    }
}