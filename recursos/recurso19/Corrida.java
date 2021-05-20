package com.company.testes.recurso19;

public class Corrida extends Atividade implements ComDistancia {
    private double kmsPercorridos;
    private double elevacao;
    private double velocidade;

    public Corrida() {
        this.kmsPercorridos = 0;
        this.elevacao = 0;
        this.velocidade = 0;
    }

    public Corrida(double kmsPercorridos, double elevacao, double velocidade) {
        this.kmsPercorridos = kmsPercorridos;
        this.elevacao = elevacao;
        this.velocidade = velocidade;
    }

    public Corrida clone() {
        return new Corrida();
    }

    public double getElevacao() {
        return elevacao;
    }

    @Override
    public double getKmsPercorridos() {
        return kmsPercorridos;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public void setElevacao(double elevacao) {
        this.elevacao = elevacao;
    }

    public void setKmsPercorridos(double kmsPercorridos) {
        this.kmsPercorridos = kmsPercorridos;
    }

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    @Override
    public double caloriasGastas() {
        return  this.getCaloriasPorUnidadeTreino()* this.kmsPercorridos * (this.elevacao*0.25);
    }

}
