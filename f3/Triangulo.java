package f3;


/**
 * Escreva a descrição da classe Triangulo aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Triangulo
{
    private Ponto a;
    private Ponto b;
    private Ponto c;
    
    public Triangulo(){
        this.a=new Ponto();
        this.b=new Ponto();
        this.c=new Ponto();
    }
    
    public Triangulo(Ponto a,Ponto b,Ponto c){
        this.a=a.clone();
        this.b=b.clone();
        this.c=c.clone();
    }
    public Triangulo(Triangulo t){
        this.a=t.getA();
        this.b=t.getB();
        this.c=t.getC();
    }
    public Ponto getA(){
        return this.a.clone();
    }
    public Ponto getB(){
      return this.b.clone();
}
 public Ponto getC(){
      return this.c.clone();
}
public void setA(Ponto p){
    this.a=p.clone();
}
public void setB(Ponto p){
    this.b=p.clone();
}
public void setC(Ponto p){
    this.c=p.clone();
}
 public int getA_X(){
        return this.a.getX();
    }
    
    /**
     * consulta a ordenada;
     * 
     * @returns o valor da ordenada do Ponto
     */
    public int getA_Y(){
        return this.a.getY();
    }
    
    /**
     * consulta a abcissa;
     * 
     * @returns o valor da abcissa do Ponto
     */
    
    public int getB_X(){
        return this.b.getX();
    }
    
    /**
     * consulta a ordenada;
     * 
     * @returns o valor da ordenada do Ponto
     */
    public int getB_Y(){
        return this.b.getY();
    }
    
    /**
     * consulta a abcissa;
     * 
     * @returns o valor da abcissa do Ponto
     */
    
    public int getC_X(){
        return this.c.getX();
    }
    
    /**
     * consulta a ordenada;
     * 
     * @returns o valor da ordenada do Ponto
     */
    public int getC_Y(){
        return this.c.getY();
    }
    
    

  
   
    /**
     * actulizam  a abcissa;
     */
    
    public void setA_X(int x){
        this.a.setX(x);
    }
    
    /**
     * actulizam a ordenada;
     */
    
    public void setA_Y(int y){
        this.a.setY(y);
    }
    
    /**
     * actulizam  a abcissa;
     */
    
    public void setB_X(int x){
        this.b.setX(x);
    }
    
    /**
     * actulizam a ordenada;
     */
    
    public void setB_Y(int y){
        this.b.setY(y);
    }
    
    
    /**
     * actulizam  a abcissa;
     */
    
    public void setC_X(int x){
        this.c.setX(x);
    }
    
    /**
     * actulizam a ordenada;
     */
    
    public void setC_Y(int y){
        this.c.setY(y);
    }
/**
 *b) calcula area do triangulo conseguii
 */
public double calculaAreaTriangulo(){
    double h=altura();
    double distab=getA().distancia(getB());
    double distbc=getB().distancia(getC());
    double distca=getC().distancia(getA());
    double maior=0;
    if(distab>maior) maior=distab;
    if(distbc>maior) maior=distbc;
    if(distca>maior) maior=distca;
    double area =(maior*h)/2;
    return area;
}
/**
 * c) conseguii
 */
public double calculaPerimetroTriangulo(){
    return this.a.distancia(this.b)+this.b.distancia(this.c)+this.c.distancia(this.a);
}
/**
 * d) calcula a altura do triangulo
 */
public double altura(){
    double alt=0;
    double min=getA().getY();
      if(min > getB().getY()) min = getB().getY();
      if (min > getC().getY()) min = getC().getY();
      
      double max=getA().getY();
      if(max < getB().getY()) max = getB().getY();
      if (max < getC().getY()) max = getC().getY();
      
      alt = max - min;
      return alt;
    }
    public String toString(){
    StringBuilder sb=new StringBuilder("triangulo: ");
    sb.append(this.a.toString());
    sb.append("/");
    sb.append(this.b.toString());
    sb.append("/");
    sb.append(this.c.toString());
    sb.append("/");
    return sb.toString();
    //alternativa
    //return "triangulo: "+this.p1.toString() +"/"
    //                    +this.p2.toString() +"/"
    //                  +this.p3.toString();
    }
public boolean equals(Object o){
    if(this==o) return true;
    if(o==null ||o.getClass()!=this.getClass()) return false;
    Triangulo t =(Triangulo) o;
    return this.a.equals(t.getA()) && this.b.equals(t.getB()) && this.c.equals(t.getC());
}
public Triangulo clone(){
    return new Triangulo(this);
}
}
