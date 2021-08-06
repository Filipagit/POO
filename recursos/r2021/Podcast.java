package Recursos.r2021;

import java.util.ArrayList;
import java.util.List;

public class Podcast {
    private String nome;
    private List<Episodio> episodios;

    public Podcast(){
        this.nome="";
        this.episodios=new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }
   public Podcast(Podcast p){
        this.nome= p.getNome();
        this.episodios=p.getEpisodios();
   }
    public List<Episodio> getEpisodios() {
        List<Episodio> e = new ArrayList<>();
        for (Episodio ep : this.episodios)
            e.add(ep);
        return  e;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEpisodios(List<Episodio> episodios) {
        this.episodios = episodios;
    }

    public Podcast(String nome, List<Episodio> episodios){
        this.nome=nome;
        this.episodios=episodios;
    }
    public Podcast clone(){
        return new Podcast(this);
    }
}
