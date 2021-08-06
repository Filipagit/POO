package com.company.testes.teste17;

public abstract class Hotel implements Comparable<Hotel> {
    private String codigo;
    private String nome;
    private String localidade;
    private double precoBaseQuarto;
    private int numeroQuartos;
    private int estrelas;

    public String getCodigo(){
        return this.codigo;
    }
}