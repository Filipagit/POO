package f3;


/**
 * Escreva a descrição da classe circulo aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class circulo
{
  private double x;
  private double y;
  private double raio;
  
  public circulo(){
      this.x=0;
      this.y=0;
      this.raio=1;
      //alternativa this(0.0,0.0,1.0);
    }
  public circulo(double x,double y,double raio){
        this.x=x;
        this.y=y;
        this.raio=raio;
  }
  public circulo(circulo c){
      this.x=c.getX();
      this.y=c.getY();
      this.raio=c.getRaio();
      //alternativa this(c.getX(),c.getY(),c.getRaio());
    }
    
  /**
   * a) metodo que devolve o valor da variavel x 
   */  
  public double getX(){
      return this.x;
    }
  /**
   * b) metodo que devolve o valor da variavel y 
   */  
  public double getY(){
      return this.y;
    }
  /**
   * c) metodo que devolve o valor da variavel raio 
   */  
  public double  getRaio(){
      return this.raio;
    }
  /**
   * d)i) altera o valor da variavel x 
   */  
  public void setX(double x){
      this.x=x;
    }
  /**
   * d)ii) altera o valor de y 
   */  
  public void setY(double y){
      this.y=y;
    }
  /**
   * d)iii) altera o valor do raio 
   */  
  public void setRaio(double raio){
      this.raio=raio;
    }
  /**
   * e) altera o posicionamento do centro 
   */  
  public void alteraCentro(double x, double y){
      this.x=x;
      this.y=y;
    }
  /**
   * f) calcula a area do circulo 
   */  
  public double calculaArea(){
      return Math.PI * Math.pow(this.raio,2);
      //alternativa return Math.PI *this.raio*this.raio;
    }
  /**
   * g) calcula o perimetro do circulo 
   */
  public double calculaPerimetro(){
      return 2*Math.PI*this.raio;
    }
  /**
   * metodo toString 
   */  
  public String toString(){
      return "circulo("+this.x+",y:"+this.y+",raio:"+this.raio+")";
    }
  /**
   * metodo clone
   */  
  public circulo clone(){
      return new circulo(this);
    }
  /**
   * metodo equals 
   */  
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if ((o == null) || (this.getClass() != o.getClass()))
      return false;
    circulo circle = (circulo) o;
    return (this.x == circle.getX() && this.y == circle.getY() && this.raio==circle.getRaio());
      
  }
  
}
