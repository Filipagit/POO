package com.company.testes.recurso19;

import java.io.InvalidClassException;
import java.io.Serializable;

public class GrowingArrayOfActividade implements Serializable {
    // vari´aveis de inst^ancia
    private Atividade [] lista ;
    private int tamanho ;

    public Atividade get(int indice) throws InvalidIndexException {
       if(indice>=tamanho || indice<0) throw new InvalidIndexException();
       else return this.lista[indice].clone();
    }
    public void add(Atividade a){
        if(this.lista.length==this.tamanho){
            Atividade [] newl = new Atividade[this.lista.length*2];
            this.tamanho =newl.length;
            System.arraycopy(this.lista,0,newl,0,this.lista.length);
            this.lista=newl;
        }
        this.lista[this.tamanho++]=a.clone();
    }


}