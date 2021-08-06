package f3;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.lang.Math;
/**
 * Escreva a descrição da classe Lampada aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Lampada
{
    private int estado;//0-> deligada 1-> ligada 2-> eco
    private double consumo;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private long tempo;
    private double gasto;
    private double ultimoGasto;
    
    public Lampada(){
        this.estado=0;
        this.consumo=0;
        this.tempo=0;
        this.gasto=0;
        this.ultimoGasto=0;
    }
    
    public Lampada(double consumo){
        this.consumo=consumo;
    }
    public Lampada(Lampada lamp){
        this.estado=lamp.getEstado();
        this.consumo=lamp.getConsumo();
    }
    public int getEstado(){
        return this.estado;
    }
    public double getConsumo(){
        return this.consumo;
    }
    public LocalDateTime getDataInicio(){
        return this.dataInicio;
    }
    public LocalDateTime getDataFim(){
        return this.dataFim;
    }
    public long getTempo(){
        return this.tempo;
    }
    public double getGasto(){
        return this.gasto;
    }
    public double getUltimoGasto(){
        return this.ultimoGasto;
    }
    public void setEstado(int estado){
       this.estado = estado;
   }
   
   public void setConsumo(double consumo){
       this.consumo = consumo;
   }
   
   public void setDataInicio(LocalDateTime dataInicio){
       this.dataInicio = dataInicio;
   }
   
   public void setDataFim(LocalDateTime dataFim){
       this.dataFim = dataFim;
   }
   
   public void setTempo(long tempo){
       this.tempo = tempo;
   }
   
   public void setGasto(double gasto){
       this.gasto = gasto;
   }
   
   public void setUltimoGasto(double ultimoGasto){
       this.ultimoGasto = ultimoGasto;
    }
   public Lampada clone(){
       return new Lampada(this);
    }
    /**
     * a) metodo para ligar a lampada no modo consumo maximo
     */
     public void lampON(){
         setEstado(1);
         LocalDateTime dataInicio=LocalDateTime.now();
         this.setDataInicio(dataInicio);
        }
    /**
     * b) desligar a lampada
     */
     public void lampOFF(){
         setEstado(0);
         LocalDateTime dataFim=LocalDateTime.now();
         this.setDataFim(dataFim);
         LocalDateTime inicio;
         inicio=getDataInicio();
         setTempo(Math.abs(inicio.until(getDataFim(),ChronoUnit.MILLIS)));
         double gasto= getGasto();
         this.setGasto((gasto + this.getTempo()*this.getConsumo()));
         this.setUltimoGasto((this.getTempo()*this.getConsumo()));
         this.setConsumo(0);
        }
    /**
     * c) ligar a lampada em modo ECO
     */     
    public void lampECO(){
        setEstado(2);
        setConsumo(1);
    }
    /**
     * d) quanto se gastou desde a criacao da lamp 
     */
    public double totalConsumo(){
        return getGasto();
    }
    /**
     * e) devolver de quanto se gastou no ult reset
     */
    public double periodoConsumo(){
        return getUltimoGasto();
    }
    
   public String toString(){
       StringBuilder sb = new StringBuilder();
       sb.append("Estado:");
       sb.append(this.getEstado());
       sb.append("\nConsumo:");
       sb.append(this.getConsumo());
       sb.append("\nData ínicio:");
       sb.append(this.getDataInicio());
       sb.append("\nData fim:");
       sb.append(this.getDataFim());
       sb.append("\nTempo:\n");
       sb.append(this.getTempo());
       sb.append(" ms\nGasto:\n");
       sb.append(this.getGasto());
       return sb.toString();
   }
}

    