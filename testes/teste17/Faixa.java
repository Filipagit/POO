package com.company.testes.teste17;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class Faixa implements Comparable<Faixa>,Playable {
    private String nome;
    private String autor;
    private double duracao;
    private int classificaçao;
    private ArrayList<String> letra; //letra da musica
    private int numeroVezesTocada;
    private LocalDateTime ultimaVez; // regista qd foi tocada pela ultima vez

    //alinea a)
    public  Faixa(String nome,String autor,double duracao, int classificaçao,ArrayList<String> letra,int numeroVezesTocada,LocalDateTime ultimaVez){
        this.nome=nome;
        this.autor=autor;
        this.duracao=duracao;
        this.classificaçao=classificaçao;
        this.setLetra(letra);
        this.numeroVezesTocada=numeroVezesTocada;
        this.ultimaVez=ultimaVez;
    }
    public Faixa(Faixa f){
       this.nome=f.getNome();
       this.autor=f.getAutor();
       this.duracao=f.getDuracao();
       this.classificaçao=f.getClassificaçao();
       this.setLetra(f.getLetra());
       this.numeroVezesTocada=f.getNumeroVezesTocada();
       this.ultimaVez=f.getUltimaVez();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getDuracao() {
        return duracao;
    }

    public int getClassificaçao() {
        return classificaçao;
    }

    public int getNumeroVezesTocada() {
        return numeroVezesTocada;
    }

    public String getAutor() {
        return autor;
    }

    public LocalDateTime getUltimaVez() {
        return ultimaVez;
    }

    public ArrayList<String> getLetra() {
        ArrayList<String> r = new ArrayList<>();
        if(this.letra!=null)
            r.addAll(this.letra);
        return  r;
    }

    public void setLetra(ArrayList<String> letra) {
        this.letra=new ArrayList<>();
        if(letra!=null)
            this.letra.addAll(letra);
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setClassificaçao(int classificaçao) {
        this.classificaçao = classificaçao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public void setNumeroVezesTocada(int numeroVezesTocada) {
        this.numeroVezesTocada = numeroVezesTocada;
    }

    public void setUltimaVez(LocalDateTime ultimaVez) {
        this.ultimaVez = ultimaVez;
    }

    //alinea b)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faixa faixa = (Faixa) o;
        return Double.compare(faixa.duracao, duracao) == 0 && classificaçao == faixa.classificaçao && numeroVezesTocada == faixa.numeroVezesTocada && Objects.equals(nome, faixa.nome) && Objects.equals(autor, faixa.autor) && Objects.equals(letra, faixa.letra) && Objects.equals(ultimaVez, faixa.ultimaVez);
    }
    @Override
    public  Faixa clone(){
        return new Faixa(this);
    }

    //alinea c) ordena se por ordem crescente do nr de vezes que foi tocada
    public  int compareTo1(Faixa f){
        int n = f.getNumeroVezesTocada();
        int res;
        if(this.numeroVezesTocada == n ) res=0;
        else if(this.numeroVezesTocada > n) res=1;
        else res=-1;
        return  res;
    }

    //alternativa c)
    public  int compareTo(Faixa f){
        return Integer.compare(this.numeroVezesTocada,f.getNumeroVezesTocada());
}

    //alinea d) ordenar faixas por ordem cronologica da ultima vez que foram tocadas
    class ComparaUltimaVez implements Comparator<Faixa>{
        public int compare(Faixa f1, Faixa f2){
            return f1.getUltimaVez().compareTo(f2.getUltimaVez());
        }
    }

    public void play(){
        System.audio(this.letra);
    }
}
