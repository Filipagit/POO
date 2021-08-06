package Recursos.r2021;

public class podcastNaoExisteException extends Exception {
    public podcastNaoExisteException(){
        super();
    }
    public podcastNaoExisteException(String msg){
        super(msg);
    }
}
