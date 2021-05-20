package com.company.testes.recurso18;

import java.time.LocalDateTime;

public class Eletrodomestico {
    private String ident ;
    private LocalDateTime inicio ;
    private LocalDateTime parcial ;
    private double consumoLigada ;
    private double consumoTotal ;
    private double consumoParcial ;
    private boolean estado ; // false - desligada , true - ligada
    public Eletrodomestico ( String ident , double consumo ) {}
    // liga o eletrodom´estico
    public void EletrodomesticoON () {}
    // desliga o electrodom´estico
    public void EletrodomesticoOFF () {}
    // devolve o consumo desde o in´ıcio
    public double totalConsumo () {return 0.0;}
    // devolve o consumo desde o ´ultimo reset
    public double periodoConsumo () {return 0.0;}
    public void efectuarResetConsumo () {}

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public boolean isEstado() {
        return estado;
    }

    public double getConsumoLigada() {
        return consumoLigada;
    }

    public double getConsumoParcial() {
        return consumoParcial;
    }

    public double getConsumoTotal() {
        return consumoTotal;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public LocalDateTime getParcial() {
        return parcial;
    }

    public void setConsumoLigada(double consumoLigada) {
        this.consumoLigada = consumoLigada;
    }

    public void setConsumoParcial(double consumoParcial) {
        this.consumoParcial = consumoParcial;
    }

    public void setConsumoTotal(double consumoTotal) {
        this.consumoTotal = consumoTotal;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public void setParcial(LocalDateTime parcial) {
        this.parcial = parcial;
    }
}
