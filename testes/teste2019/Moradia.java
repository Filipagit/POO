package testes.teste2019;


/**
 * Escreva a descrição da classe Moradia aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Moradia extends Imovel {
private double areaPrivativa ;
private double areaExterior ;

public double precoDia(){
    return super.getPrecoBase()*(this.areaPrivativa*0.3+ this.areaExterior*0.7);
}
}