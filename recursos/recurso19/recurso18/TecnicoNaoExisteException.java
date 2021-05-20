package com.company.testes.recurso18;

public class TecnicoNaoExisteException extends Exception{
    public TecnicoNaoExisteException(){
        super();
    }
    public TecnicoNaoExisteException(String s){
        super(s);
    }
}
