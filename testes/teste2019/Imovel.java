package testes.teste2019;

import java.io.Serializable;
import java.util.*;
/**
 * Escreva a descrição da classe Imovel aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public abstract class Imovel implements Serializable {
private String codImovel ;
private String morada ;
private String nifProprietario ;
private double area ;
private double precoBase ;
public   abstract double precoDia();

public double getPrecoBase(){
    return this.precoBase;
}
public String getCodIm(){
    return this.codImovel;
}
}
