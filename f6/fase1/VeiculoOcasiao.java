package fichas.f6.fase1;
import java.util.ArrayList;


/**
 * Escreva uma descrição da classe VeiculoOcasiao aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class VeiculoOcasiao extends Veiculo
{
    private static double desconto=0.25;
    private boolean promotion;
    
    public VeiculoOcasiao(){
        super();
        this.promotion=false;
    }
    
    public VeiculoOcasiao(String marca,String modelo,String matricula,int ano,double velocidademedia,
         double precokm,ArrayList<Integer> classificacao,int kms,int kmsUltimo){
             super(marca,modelo,matricula,ano,velocidademedia,precokm,classificacao,kms,kmsUltimo);
             this.promotion=promotion;
         }
         public VeiculoOcasiao(VeiculoOcasiao v){
        super(v);
        this.promotion=v.getPromotion();
    }
    public boolean getPromotion(){
        return this.promotion;
    }
    public void setPromotion(boolean pr){
        this.promotion=pr;
    }
    public VeiculoOcasiao clone(){
        return new VeiculoOcasiao(this);
    }
    public double getCustoPorKM(){
        if(promotion) return custoRealKM()*(1-VeiculoOcasiao.desconto);
        else  return custoRealKM();
    }
 public boolean equals(Object o){
        if (o == this) return true;
        if (o == null || ! o.getClass().equals(this.getClass())) return false;
        VeiculoOcasiao v = (VeiculoOcasiao) o;   
        return super.equals(v) && this.promotion==v.getPromotion();
}

}
