package f4;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Escreva a descrição da classe CasaInteligente aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class CasaInteligente
{
   private ArrayList<Lampada> lamp;
   
   public CasaInteligente(){
       this.lamp= new ArrayList<>();
    }
   public CasaInteligente(List<Lampada> lamp){
       setLamps(lamp);
    }
   
   public List<Lampada> getLamps(){
       List<Lampada> lamps=new ArrayList<>();
       for(Lampada l : this.lamp)
        lamps.add(l.clone());
        return lamps;
    }
           
   public void setLamps(List<Lampada> lamp) {
        this.lamp = new ArrayList<>();
        for(Lampada l : lamp)
            this.lamp.add(l.clone());
    }  
   /**
    * b)i) adiciona mais uma lampada
    */ 
   public void addLampada(Lampada l){
       this.lamp.add(l.clone());
    }
   /**
    * ii) liga no modo de consumo maximo a lampada da posicao indicada
    */ 
   public void ligaLampadaNormal(int index){
       this.lamp.get(index).lampON();
}
/**
 * iii) liga no modo consumo economico a lampada da pos indicada
 */
public void ligaLampadaEco(int index){
     this.lamp.get(index).lampECO();
}
/**
 * iv) determina quantas lampadas estao no modo economico
 */
public int qtEmEco(){
          int c = 0;
        Iterator<Lampada> it = this.lamp.iterator();
        while(it.hasNext()){
            Lampada l = it.next();  //Lampada l= it[i++]
            if(l.getModo() == 2)
                c++;
        }
        return c;
    }
/**
* v) remove  a lampada da posicao indicada 
    public void removeLampada(int index){
        this.lamp.remove(index);
    }
/**
 * vi) 
 */    
public void ligaTodasEco(){
    for(Lampada l : this.lamp)
        if(l.getModo()!=2)
         l.lampECO();
        }
public void ligaTodasMax(){
    for(Lampada l : this.lamp)
        if(l.getModo()!=1)
         l.lampON();
}
/**
 * vii) determina o consumo total da casa 
 */
public double consumoTotal(){
    double total=0;
    for(Lampada l : this.lamp){
        total+=l.getTotal();
    }
    return total;
}
/**
 * viii) efetua o reset do contador parcial de consumo das lampadas
 */
public void reset(){
    for(Lampada l : this.lamp){
        l.setTotal(0);
    }
}

}