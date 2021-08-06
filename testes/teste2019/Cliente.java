package testes.teste2019;

import java.io.Serializable;
import java.util.List;
/**
 * Escreva a descrição da classe Cliente aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */

public class Cliente implements Serializable {
private String nome ;
private String codCliente ;
private List < Aluguer > meusAlugueres ;

public String getCod(){
    return this.codCliente;
}

}
