package testes.teste2019;

import java.io.Serializable;
import java.util.*;

/**
 * Escreva a descrição da classe POOAIRBnB aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */

public class POOAirBnB implements Serializable {
private Map < String , Imovel > imoveis ;
private Map < String , Cliente > clientes ;

public void insereImovel(Imovel i) throws ImovelJaExistente{
    if(this.imoveis.containsKey(i)) throw new ImovelJaExistente("Ja existe este imovel" + i);
   this.imoveis.put(i.getCodIm(),i);
}

public double valorTotalAluguerCliente(String codCliente){
    double r=0;
    if(this.clientes.containsKey(codCliente)){
          for(Aluguer a : this.clientes.get(codCliente).getAlug())
          r += this.imoveis.get(a.getCodIm().precoDia());
}
return r;
}

public String clienteMaisGastador(){
    String maisG= new String();
    double mais=0;
    double aux=0;
    for(Cliente c : this.clientes.values())
        for(Aluguer a : this.clientes.get(c.getCod()).getAlug()){
        if(this.valorTotalAluguerCliente(getCod(c))> mais){
            mais= this.valorTotalAluguerCliente(getCod(c));
            maisG=a.getCod();
        }
        }
        return maisG;
    }

public Map<String, Set<String>> clientesPorImovel(){
    Map<String, Set<String>> novo = new HashMap<>();
     for(Cliente c : this.clientes.values())
        for(Aluguer a : this.clientes.get(c.getCod()).getAlug()){
            if(novo.containsKey(a.getCodIm()).add(c.getCod()));
            else{
                Set<String> toAdd = new HashSet<>();
                toAdd.add(c.getCod());
                novo.put(a.getCodIm(),toAdd);
            }
        }
        return novo;
    }
}


