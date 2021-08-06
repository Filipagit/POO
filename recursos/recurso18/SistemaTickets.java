package com.company.testes.recurso18;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaTickets {
    private Map< String , Tecnico > funcionarios ; // funcionarios da empresa
    private List < Ticket > ticketsPorResolver ; // tickets ainda n~ao tratados
    private List< Ticket > ticketsResolvidos ; // tickets j´a satisfeitos

    // adiciona um ticket ao sistema conseguiii
    public void adicionaTicket(Ticket t){
        this.ticketsPorResolver.add(t);
    }

    // resolve um ticket do sistema
    public void resolveTicket(String ident) throws TecnicoNaoExisteException{
        if(!this.funcionarios.containsKey(ident)) throw  new TecnicoNaoExisteException();
        else{
            Ticket t = this.ticketsPorResolver.remove(0);
            t.setHoraFecho(LocalDateTime.now());
            t.setIdentTecnico(ident);
            this.ticketsResolvidos.add(t);
        }
    }

    //devolve um map em que associa a cada identificador de tecnico os tickets por ele resolvidos.
    public Map<String,List<Ticket>> ticketsPorTecnico(){
          Map<String,List<Ticket>> ticks= new HashMap<>();
          if(this.funcionarios!=null && !this.funcionarios.isEmpty())
              if(this.ticketsResolvidos != null && !this.ticketsResolvidos.isEmpty()){
                  for(String s : this.funcionarios.keySet()){
                      List<Ticket> tresolv = new ArrayList<>();
                      for(Ticket t : this.ticketsResolvidos)
                          if(t.getIdentTecnico().equals(s))
                              tresolv.add(t.clone());
                          if(!tresolv.isEmpty()) ticks.put(s,tresolv);
                  }
              }
      return  ticks;
    }

    //devolve o supervisor que resolveu mais tickets
    public String supervisorTop(){
        int maist=0;
        String supTop=null;
        for(Tecnico t : this.funcionarios.values())
             if(t.getNumTickets()>maist){
                 maist=t.getNumTickets();
                 supTop= t.getIdent();
             }
        return  supTop;
    }

}

