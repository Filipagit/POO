package Recursos.r2021;

import java.util.ArrayList;
import java.util.List;

public class Utilizador {
    private  String id;
    private String nome;
    private List<Podcast> infopodsub;

    public Utilizador(){
        this.id="";
        this.nome="";
        this.infopodsub= new ArrayList<>();
    }
    public Utilizador(String id,String nome,List<Podcast>infopodsub){
        this.id=id;
        this.nome=nome;
        this.infopodsub=infopodsub;
    }
    public Utilizador(Utilizador u){
        this.id=u.getId();
        this.nome=u.getNome();
        this.infopodsub=u.getInfopodsub();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Podcast> getInfopodsub() {
        List<Podcast> p = new ArrayList<>();
        for(Podcast pod : this.infopodsub)
             p.add(pod);
        return  p;
    }

    public void setInfopodsub(List<Podcast> infopodsub) {
        this.infopodsub = infopodsub;
    }

    public Utilizador clone(){
        return  new Utilizador(this);
    }
}
