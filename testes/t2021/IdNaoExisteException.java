package testes.t2021;

public class IdNaoExisteException extends Exception{
    public IdNaoExisteException(){
        super();
    }
    public IdNaoExisteException (String msg){
        super(msg);
    }
}
