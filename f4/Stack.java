package f4;

import java.util.List;
import java.util.ArrayList;
/**
 * Escreva a descrição da classe Stack aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Stack
{ 
    private List<String> lst;
    
    public Stack(){
        this.lst=new ArrayList();
    }
    public Stack(List<String> list){
        this();//invoca o construtor de cima, inicializa o lst
        ///this.list= new ArrayList(list.size());
        lst.addAll(list);//copia apontadores de um lado para o outro(agregacao)
        //porque as strings sao imutaveis 
    }
    public Stack(Stack s){
        this(s.getLst());
    }
    private List<String> getLst(){
        List<String> res = new ArrayList();
        lst.addAll(lst);
        return res;
    }
    /**
     * a) determina o elemento do topo da stack(ult posicao)
     */
    public String top(){
        int tam=this.lst.size();
        if(tam>0) return this.lst.get(tam-1);
        else return null;
    }
    /**
     * b) insere no topo  conseguii
     */
    public void push(String s){
        this.lst.add(s);
    }
    /**
     * c)remove o elemento do topo da stack conseguuii
     */
    public void pop(){
        int tam=this.lst.size();
        if(tam>0) this.lst.remove(tam-1);
    }
    /**
     * d) determina se a stack esta vazia conseguiii
     */
     public boolean empty(){
        return(this.lst.isEmpty());
    }
    /**
     * e) determina o comprimento da stack conseguiii
     */
    public int length(){
        return this.lst.size();
    }
}


   
