package testes.teste2019;


/**
 * Escreva a descrição da classe Apartamento aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
*/
public class Apartamento extends Imovel {
private String andar ;
private double factorQualidade ;

public double precoDia() {
	return super.getPrecoBase() * factorQualidade;
}
}