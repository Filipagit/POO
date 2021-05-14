package fichas.f5;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;


/**
 * Escreva uma descrição da classe Parque aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Parque
{
    private String nomeP;
    private Map<String,Lugar> lug;

    public Parque(){
        this.nomeP="";
        this.lug= new HashMap<>();
    }
    
    public Parque(String nomeP, Map<String,Lugar> lug){
        this.nomeP=nomeP;
        this.lug=new HashMap<>();
        for(Lugar l : lug.values()){
            this.lug.put(l.getMatricula(), l.clone());
        }
    }
    
    public Parque(Parque p){
        this.nomeP=p.getNomeP();
        this.lug=p.getLug();
    }
    public String getNomeP(){
        return this.nomeP;
    }
    public void setNomeP(String nomeP){
        this.nomeP=nomeP;
    }
    public Map<String,Lugar> getLug(){
        Map m= new HashMap<>();
        for(Lugar l : this.lug.values()){
            m.put(l.getMatricula(), l.clone());
        }
        return m;
    }
    public void setLug(Map<String,Lugar> lug){
        for(Lugar l : lug.values()){
            this.lug.put(l.getMatricula(),l.clone());
        }
    }
    /**
     * 1)Método que devolve todas as matriculas dos lugares ocupados
     */
    public List<String> ocupados(){
        return this.lug.values() //values- valores que estao no map
                    .stream() //stream-percorre todos os valores  
                    .filter(x->x.getMinutos()>0) //filter-filtra tds os lugares cujos min>0
                    .map(x->x.getMatricula()) // map-a tds os filtrados vai buscar a matricula
                    .collect(Collectors.toList());// collect- mete tds as matriculas num set 
    }
    /**
     * 2)  Método que regista uma nova ocupação de lugar
     */
    public void addOcup(Lugar l){
        this.lug.put(l.getMatricula(),l);
    }
    /**
     * 3)Método que remove o lugar de dada matricula conseguiii
     */
    public void removeLug(Lugar l){
        this.lug.remove(l.getMatricula());
    }
    /**
     * 4) • Método que altera o tempo disponível de um lugar, para uma
dada matricula
     */
    public void setTempo(int tempo,String matricula){
        this.lug.get(matricula).setMinutos(tempo);
    }
/**
 * 5) Método que devolve a quantidade total de minutos atribuídos.
 */
//iteradores internos 
public int getAllmin_I(){
    return this.lug.values().stream()
    .mapToInt(x->x.getMinutos()).sum();
}
//com iteradores externos conseguiii
public int getAllmin_Ext(){
    int total=0;
    for(Lugar l : this.lug.values()){
        total+=l.getMinutos();
    }
    return total;
}
/**
 * 6) Método que verifica existe lugar atribuído a uma dada matrícula conseguiii
 */
public boolean existeLug(String matricula){
    return this.lug.containsKey(matricula);
}
/**
 * 7)Método que cria uma lista com as matriculas com tempo atribuído > x, em que o lugar seja permanente. 
 */
//iterador externo conseguiiii
public List<String> getMatTime(int x){
    List<String> l= new ArrayList<>();
    for(Lugar l1 : this.lug.values()){
        if(l1.getMinutos()>x && l1.getPermanente()){
            l.add(l1.getMatricula());
        }
    }
    return l;
}
//iterador interno
public List<String> getMat_ext(int y){
    return this.lug.values().stream()
            .filter(x->x.getMinutos()>y && x.getPermanente())
            .map(Lugar::getMatricula)
            .collect(Collectors.toList());
}

/**
 * 8)Método que devolve uma cópia dos lugares
 */
//iterador externo
public List<Lugar> copyLug(){
    return new ArrayList<>(this.lug.values());
}
//iterador interno quaseee
public List<Lugar> copyLug_Int(){
    return this.lug.values().stream()
               .map(Lugar::clone)
               .collect(Collectors.toList());
}
/**
 * 9) Método que devolve a informação de um lugar para uma dada matricula
 */
public Lugar getInfoLug(String matricula){
 return this.lug.get(matricula).clone();    
}
}
