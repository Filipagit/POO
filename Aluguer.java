package testes.teste2019;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
/**
 * Escreva a descrição da classe Aluguer aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */

public class Aluguer implements Serializable {
private String codCliente ;
private String codImovel ;
private LocalDate dataInicio ;
private LocalDate dataFim ;
private List<Aluguer> alugueres;

public List<Aluguer> getAlug(){
    List<Aluguer> al= new ArrayList<>();
      for(Aluguer a : this.alugueres){
          al.add(a);
}
return al;
}
public String getCodIm(){
    return this.codImovel;
}
}

