package testes.teste2019;


/**
 * Escreva a descrição da classe Bungalow aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */

public class Bungalow extends Imovel {
private double factorQualidade ;
private double espessuraParedes ;


public double precoDia(){
    return super.getPrecoBase()*(this.factorQualidade*0.5+ this.espessuraParedes*0.5);
}
}
