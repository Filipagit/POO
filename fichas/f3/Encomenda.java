package f3;
import java.util.Arrays;
/**
 * Escreva a descrição da classe Encomenda aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Encomenda
{
   private String nomeC;
   private String nif;
   private String moradaC;
   private int numEnc;
   private LinhaEncomenda[] linhasenc;
   
  public Encomenda(){
      this.nomeC="";
      this.nif="";
      this.moradaC="";
      this.numEnc=0;
      this.linhasenc= new LinhaEncomenda[10];
    }
  public Encomenda(String nomeC,String nif,String moradaC,int numEnc,LinhaEncomenda[] linhasenc){
      this.nomeC=nomeC;
      this.nif=nif;
      this.moradaC=moradaC;
      this.numEnc=numEnc;
      this.linhasenc=linhasenc;
    }
  public Encomenda(Encomenda enc){
      this.nomeC=enc.getNomeC();
      this.nif=enc.getNif();
      this.moradaC=enc.getMoradaC();
      this.numEnc=enc.getNumEnc();
      this.linhasenc=enc.getLinhasenc();
    }
  public String getNomeC(){
      return this.nomeC;
    }
  public void setNomeC(String nomeC){
      this.nomeC=nomeC;
    }
  public String getNif(){
      return this.nif;
    }
  public void setNif(String nif){
      this.nif=nif;
    }
  public String getMoradaC(){
      return this.moradaC;
    }
  public void setMoradaC(String moradaC){
      this.moradaC=moradaC;
    }
  public int getNumEnc(){
      return this.numEnc;
    }
  public void setNumEnc(int numEnc){
      this.numEnc=numEnc;
    }
  public LinhaEncomenda[] getLinhasenc(){
      return this.linhasenc;
    }
  public void setLinhasenc(LinhaEncomenda[] linhasenc){
      this.linhasenc=linhasenc;
    }
  public Encomenda clone(){
      return new Encomenda(this);
    }
    
    public boolean equals(Object o){
        if(this == o)return true;
        
        if(o == null || (this.getClass() != o.getClass()))return false;
        
        Encomenda enc = (Encomenda) o;
        
        return(this.nomeC.equals(enc.getNomeC()) && this.nif.equals(enc.getNif()) 
        && this.moradaC.equals(enc.getMoradaC()) && this.numEnc == enc.getNumEnc() 
        && this.linhasenc.equals(enc.getLinhasenc()));
    }
  /**
   * b) metodo que calcula o valor total da encomenda
   */  
  public double calculaValorTotal(){
      double total=0;
      for(LinhaEncomenda le : this.linhasenc){
          total+=le.calculaValorLinhaEnc();
        }
        return total;
    }
  /**
   * c) metodo que calcula o total dos descontos obtidos 
   */ 
  public  double calculaValorDesconto(){
      double total=0;
      for(LinhaEncomenda le : this.linhasenc){
          total+=le.calculaValorDesconto();
        }
        return total;
    }
  /**
   * d) metodo que calcula o total de produtos a receber 
   */ 
  public int numeroTotalProdutos(){
      int total=0;
      for(LinhaEncomenda le : this.linhasenc){
          total+=le.getQuantidade();
        }
        return total;
    }
    /**
     * e) determina se um produto vai ser encomendado 
     */
    public boolean existeProdutoEncomenda(String refProduto){
        for(LinhaEncomenda le : this.linhasenc)
            if(refProduto.equals(le.getReferencia())) 
            return true;
            return false;
}
/**
 * f) adiciona uma nova linha de encomenda 
 */
public void adicionaLinha(LinhaEncomenda linha){
    int tamanho=this.linhasenc.length;
    for(LinhaEncomenda le : this.linhasenc){
    linhasenc[tamanho+1]=linha;
    tamanho++;
}
}
/**
 * g) remover uma linda dado a ref do prod
 */
public void removeProduto(String codProd){
     for(LinhaEncomenda le : this.linhasenc){
        if(codProd.equals(le.getReferencia())) this.linhasenc.remove(le);
    }
}
}
