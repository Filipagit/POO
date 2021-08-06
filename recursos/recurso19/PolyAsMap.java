package recursos.recurso19;

import java.util.HashMap;
import java.util.Map;
/**
 * Escreva a descrição da classe PolyAsMap aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class PolyAsMap implements Poly
{
    Map<Integer,Poly> pol;
    
    public PolyAsMap(){
        this.pol= new HashMap<>();
    }
    
    public Map<Integer,Poly> getPoly(){
        Map<Integer,Double> novo = new HashMap<>();
          for(Integer i : this.pol.keySet())
              novo.put(i,this.pol.get(i));
             return novo; 
    }
   
    public void setPoly(Map<Integer,Double> pol){
        for(Integer i : pol.keySet())
           this.pol.put(i,pol.get(i));
        }
    
    public void addMonomio(int grau, double coeficiente){
        if(this.pol.isEmpty()){
          for(int i=0; i< grau; i++)
             this.pol.put(i,0.0);
            }
             else 
                for(j=pol.size();j<grau;j++)
                   this.pol.put(j,0.0);
                   
              this.pol.put(grau,coeficiente);
            }
    
    public double calcula ( double x ){
        double r=0.0;
        if(!this.pol.isEmpty()){
             for(int i=0;i<pol.size();i++)
               r += this.pol.get(i) * Math.pow(x,i);
    }
    return r;
}
public String toString (){
    StringBuilder sb = new StringBuilder();
        for(int i = this.pol.size() - 1; i >= 0; i--){
            if(this.pol.get(i) > 0.0)
                sb.append("+").append(this.pol.get(i)).append("x^").append(i).append(" ");
            else
                sb.append(this.pol.get(i)).append("x^").append(i).append(" ");
        }
        return sb.toString();
}
}