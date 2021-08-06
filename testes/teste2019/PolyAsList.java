package testes.teste2019;

import java.util.List;
/**
 * Escreva a descrição da classe PolyAsList aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class PolyAsList implements Poly
{
   private List<Double> polyn;
   
   public void addMonomio(double coef, int grau){
    double val;
    int maxGrau= polyn.size()-1;
    for(int i = maxGrau; i<grau;i++)
        polyn.add(0.0);
        val=polyn.get(grau)+coef;
        polyn.add(grau,val);
}

public double calcula(double x){
    int r=0;
    for(int i=0; i< polyn.size(); i++)
      r += polyn.get(i)*Math.pow(x,i);
      return r;
}

public Poly derivada() {
    Poly p = new PolyAsList();
    for(int i=0; i< polyn.size();i++)
        p.addMonomio(polyn.get(i)*i,i-1);
        return p;
}

}
