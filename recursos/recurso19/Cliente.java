package com.company.testes.recurso19;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cliente implements Serializable {
    private String nome;
    private String codCliente;
    private Map<LocalDate, List<Exercicio>> meusExercicios;

    public Map<LocalDate, List<Exercicio>> getMeusExercicios() {
         Map<LocalDate,List<Exercicio>> r = new HashMap<>();
            for(LocalDate l : this.meusExercicios.keySet()){
                List<Exercicio> toAdd= new ArrayList<>();
                  for(Exercicio e : this.meusExercicios.get(l))
                      toAdd.add(e.clone());
                  r.put(l,toAdd);
            }
        return r;
    }
    public Map<String, List<Exercicio>> exerciciosPorProf(){
        Map<String,List<Exercicio>> r= new HashMap<>();
        if(this.meusExercicios != null && !this.meusExercicios.isEmpty())
            for(List<Exercicio> es : this.meusExercicios.values())
                for(Exercicio e : es)
                    if(r.containsKey(e.getProfessor()))
                        r.get(e.getProfessor()).add(e.clone());
                    else{
                        List<Exercicio> toAdd = new ArrayList<>();
                        toAdd.add(e.clone());
                        r.put(e.getProfessor(),toAdd);
                    }
                    return  r;
    }
}
