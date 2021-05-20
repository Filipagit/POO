package com.company.testes.recurso19;

public class ClienteNaoExisteException extends Exception {
    public ClienteNaoExisteException(){
        super();
    }
    public ClienteNaoExisteException(String s){
        super(s);
    }
}
