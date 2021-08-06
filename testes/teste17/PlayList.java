package com.company.testes.teste17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayList {
    private String nome;
    private Map<String, List<Faixa>> musicas;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setMusicas(Map<String, List<Faixa>> musicas){
        this.musicas = new HashMap<>();
        if(musicas != null)
            for(String s : musicas.keySet()) {
                List<Faixa> toAdd = new ArrayList<>();
                List<Faixa> faixas = musicas.get(s);
                for (Faixa f : faixas)
                    toAdd.add(f.clone());
                if (this.musicas.containsKey(s)) {
                    List<Faixa> fs = this.musicas.get(s);
                    List<Faixa> tmp = new ArrayList<>();
                    for (Faixa f : fs)
                        tmp.add(f.clone());
                    for (Faixa f : toAdd)
                        tmp.add(f.clone());
                    this.musicas.put(s, tmp);
                } else this.musicas.put(s, toAdd);
            }
    }
    public Map<String, List<Faixa>> getMusicas(){
        Map<String, List<Faixa>> ans = new HashMap<>();
        if(this.musicas != null)
            for(String s : this.musicas.keySet()){
                List<Faixa> toAdd = new ArrayList<>();
                List<Faixa> faixas = this.musicas.get(s);
                for(Faixa f : faixas)
                    toAdd.add(f.clone());
                ans.put(s, toAdd);
            }
        return ans;
    }
    //2a) devolve a lista das musicas do autor conseguiii
    public List<Faixa> getFaixas(String autor) throws AutorInexistenteException{
          List<Faixa> musicas = new ArrayList<>();
          if(!this.musicas.containsKey(autor)) throw  new AutorInexistenteException();
           else {
              List<Faixa> fautor = this.musicas.get(autor);
              for (Faixa f : fautor)
                  musicas.add(f.clone());
          }
           return musicas;
    }

    //2b) devolve o tempo total das faixas de musica do autor conseguiii
    public double tempoTotal(String autor) throws AutorInexistenteException{
        double tempo=0;
        if(!this.musicas.containsKey(autor)) throw new AutorInexistenteException();
        else{
            for(Faixa f : this.musicas.get(autor)){
                tempo += f.getDuracao();
            }
            return  tempo;
        }
    }
    //3a) devolve a lista de todas as faixas existentes na playList
    public List<Faixa> todasAsFaixas(){
        List<Faixa> todas = new ArrayList<>();
        if(this.musicas!=null)
        for(List<Faixa> fs : this.musicas.values())
            for(Faixa f : fs)
                todas.add(f.clone());
        return todas;
    }
    // 3b) devolve um map que associa a cada valor de class  a lista de faixas c essa class
    public Map<Integer,List<Faixa>> faixasPorClass(){
          Map<Integer,List<Faixa>> faixas = new HashMap<>();
          this.musicas.values().forEach(f->f.forEach(c->addFaixa(c,faixas)));
          return faixas;
    }
    public void addFaixa(Faixa f, Map<Integer, List<Faixa>> m){
        int c= f.getClassificaçao();
        List<Faixa> fs = m.get(c);
        if(fs!=null){
            fs=new ArrayList<>();
            fs.add(f.clone());
        }
        else fs.add(f.clone());
        m.put(c,fs);
    }


}
