package com.company.testes.recurso19;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GinasioPOO implements Serializable {
    private Map< String , Cliente > clientes ;

    public double valorTotalCaloriasGastas(String codCliente) throws ClienteNaoExisteException{
        double r=0.0;
        if(!this.clientes.containsKey(codCliente)) throw  new ClienteNaoExisteException();
        else{
            Cliente c= this.clientes.get(codCliente);
            Map<LocalDate, List<Exercicio> > ex = c.getMeusExercicios();
             for(LocalDate l : ex.keySet())
                 for(Exercicio e : ex.get(l))
                 r += e.getActividade().caloriasGastas();
        }
        return  r;
    }
    public double totalKmsCliente ( String codCliente , LocalDate dataExercicio ) throws ClienteNaoExisteException , ExercicioInexistenteException{
        if(!clientes.containsKey(codCliente)) throw  new ClienteNaoExisteException();
        else{
            double r=0.0;
            List<Exercicio> ex = clientes.get(codCliente).getMeusExercicios().get(dataExercicio);
            for(Exercicio e : ex)
                if(e instanceof  ComDistancia)
                r += ((ComDistancia)e).getKmsPercorridos();
                return  r;
        }
    }

    public boolean existeProfessor(String prof){
        boolean r = false;
        for(Cliente c : this.clientes.values()){
            if(r) break;
            for(List<Exercicio> ex : c.getMeusExercicios().values()){
                if (r) break;
                for (Exercicio e : ex)
                     if(e.getProfessor().equals(prof))
                         r= true;
                     break;
            }
        }
        return r;
    }
//determina o professor que fez os alunos gastarem mais calorias
    public String professorMaisExigente(){
          double maxc=0.0;
          String r="";
          Map<String,Double>  prof = new HashMap<>();
            for(Cliente c : this.clientes.values())
                for(List<Exercicio> es : c.getMeusExercicios().values())
                     for(Exercicio e : es)
                         if(prof.containsKey(e.getProfessor())) {
                             double cals = prof.get(e.getProfessor());
                             cals += e.getActividade().caloriasGastas();
                             prof.put(e.getProfessor(), cals);
                         }
            else prof.put(e.getProfessor(),e.getActividade().caloriasGastas());
             for(String s : prof.keySet())
                 if(prof.get(s)>maxc){
                 r=s;
                 maxc=prof.get(s);
             }
             return r;
    }
}
