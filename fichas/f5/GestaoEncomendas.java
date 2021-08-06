package fichas.f5;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.*;
import java.time.LocalDate;

/**
 * Escreva uma descrição da classe GestaoEncomendas aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class GestaoEncomendas
{
    private Map<String,Encomenda> enc;
    
    public GestaoEncomendas(){
        this.enc= new HashMap<>();
    }
    
    public GestaoEncomendas(GestaoEncomendas g){
        this.enc=g.getGestEnc();
    }
    
    public GestaoEncomendas(Map<String,Encomenda> enc){
        this.setEncomendas(enc);
    }
    
    public Map<String,Encomenda> getGestEnc(){
        Map<String,Encomenda> e = new HashMap<>();
        this.enc.forEach((key,value) -> e.put(key,value.clone()));
        return e;
    }
    public void setEncomendas(Map<String,Encomenda> enc){
        this.enc=new HashMap<>();
        enc.forEach((key,value) -> this.enc.put(key,value.clone()));
    }
    
    /**
     * i)método que determina os códigos de encomenda existentes
     */
    public Set<String> todosCodigosEnc(){
        return this.enc.keySet();
    }
    /**
     * ii)método que adiciona mais uma encomenda ao sistema 
     */
    public void addEncomenda(Encomenda enc){
        this.enc.put(enc.getIdEnc(),enc.clone());
    }
    
    /**
     * iii)método que dado um código de encomenda devolve a informação respectiva 
     */
    public Encomenda getEncomenda(String codEnc){
        return this.enc.get(codEnc).clone();
    }
    /**
     * iv) método que remove uma encomenda dado o seu código 
     */
    public void removeEncomenda(String codEnc){
        this.enc.remove(codEnc);
    }
    
    /**
     * v)método que determina a encomenda com mais produtos encomendados 
     */
    public String encomendaComMaisProdutos(){
        String nova= new String();
        int max=0;
        for(Encomenda e : this.enc.values()){
            if(e.getEncomendas().size() > max){
                max=e.getEncomendas().size();
                nova=e.getIdEnc();
            }
        }
        return nova;
    }
    
    /**
     * vi)método que determina todas as encomendas em que um determinado produto, identificado pelo código, está presente 
     */
     public Set<String> encomendasComProduto(String codProd){
         return this.enc.values().stream()
                 .filter(x -> x.existeProdutoEncomenda(codProd))
                 .map(Encomenda::getnEnc)
                 .collect(Collectors.toSet());
     }
    /**
     * vii)método que determina todas as encomendas com data posterior
     * a uma data fornecida como parâmetro
     */ 
    public Set<String> encomendasAposData(LocalDate d){
        return this.enc.values().stream()
                .filter(x -> x.getData().isAfter(d))
                .map(Encomenda::getnEnc)
                .collect(Collectors.toSet());
    }
}

