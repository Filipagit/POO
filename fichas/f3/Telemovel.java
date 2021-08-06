package f3;
import java.util.ArrayList;

/**
 * Escreva a descrição da classe Telemovel aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Telemovel
{
    private String marca;
    private String modelo;
    private int x;
    private int y;
    private int numMensagens;
    private String[] mensagens;
    private int dimFotos;
    private int dimApps;
    private double armazenamentoTotal;
    private double espacoOcupado;
    private int numFotos;
    private int numApps;
    private String[] nomeApps;
    
    public Telemovel(){
        this.marca=("");
        this.modelo=("");
        this.x=0;
        this.y=0;
        this.numMensagens=0;
        this.mensagens= new String[100];
        this.dimFotos=1024;
        this.dimApps=2048;
        this.armazenamentoTotal=this.dimFotos+this.dimApps;
        this.espacoOcupado=0;
        this.numFotos=0;
        this.numApps=0;
        this.nomeApps= new String[100];
    }
    public Telemovel(Telemovel t){
        this.marca=t.getMarca();
        this.modelo=t.getModelo();
        this.x=t.getX();
        this.y=t.getY();
        this.numMensagens= t.getnumMensagens();
        String[] tmp = t.getMensagens();
        this.mensagens=new String[tmp.length];
        System.arraycopy(tmp,0,mensagens,0,tmp.length);
        this.dimFotos=t.getdimFotos();
        this.dimApps=t.getdimApps();
        this.armazenamentoTotal=t.getarmazenamentoTotal();
        this.espacoOcupado=t.getespacoOcupado();
        this.numFotos=t.getnumFotos();
        this.numApps=t.getnumApps();
        tmp=t.getnomeApps();
        this.nomeApps= new String[tmp.length];
        System.arraycopy(tmp,0,nomeApps,0,tmp.length);
    }
    public Telemovel(String marca, String modelo, int x, int y,int numMensagens, String[] mensagens, int dimFotos, int dimApps, int espacoOcupado, int numFotos, int numApps, String[] nomeApps){
        this.marca=marca;
        this.modelo=modelo;
        this.x=x;
        this.y=y;
        this.numMensagens=numMensagens;
        this.mensagens= new String[mensagens.length*2];
        System.arraycopy(mensagens,0,this.mensagens,0,mensagens.length);
        this.dimFotos=dimFotos;
        this.dimApps=dimApps;
        this.armazenamentoTotal=this.dimFotos + this.dimApps;
        this.espacoOcupado=espacoOcupado;
        this.numFotos=numFotos;
        this.numApps=numApps;
        this.nomeApps=nomeApps;
    }
    public String getMarca(){
        return this.marca;
    }
    public void setMarca(String marca){
        this.marca=marca;
    }
    public String getModelo(){
        return this.modelo;
    }
    public void setModelo(String modelo){
        this.modelo=modelo;
    }
    public int getX(){
        return this.x;
    }
    public void setX(int x){
        this.x=x;
    }
    public int getY(){
        return this.y;
    }
    public void setY(){
        this.y=y;
    }
    public int getnumMensagens(){
        return this.numMensagens;
    }
    public String[] getMensagens(){
        String[] res= new String[this.mensagens.length];
        System.arraycopy(this.mensagens,0,res,0,this.mensagens.length);
        return res;
    }
    public void setMensagens(String[] mensagens){
        this.mensagens= new String[mensagens.length];
        System.arraycopy(mensagens,0,this.mensagens,0,mensagens.length);
        int c=0;
          for(String m : this.mensagens){
              if(m!=null) c++;
            }
            this.numMensagens=c;
        }
    public int getdimFotos(){
        return this.dimFotos;
    }
    public int getdimApps(){
        return this.dimApps;
    }
    public double getarmazenamentoTotal(){
        return this.armazenamentoTotal;
    }
    public double getespacoOcupado(){
        return this.espacoOcupado;
    }
    public int getnumFotos(){
        return this.numFotos;
    }
    public int getnumApps(){
        return this.numApps;
    }
    public String[] getnomeApps(){
        String[] res= new String[this.nomeApps.length];
        System.arraycopy(this.nomeApps,0,res,0,this.nomeApps.length);
        return res;
    }
    public void setnomeApps(String[] nomeApps){
        this.nomeApps=nomeApps;
    }
    
    /**
     * a) metodo que valida se um determinado conteudo pode ser carregado para o telefone 
     */
    public boolean existeEspaco(int numeroBytes){
        if((this.armazenamentoTotal)-(this.espacoOcupado) > numeroBytes) return true;
        else return false;
    }
    
    /**
     * b) metodo que instala uma app nova
     */
    public void instalaApp(String nome, int tamanho){
        if(existeEspaco(tamanho) && this.numApps < nomeApps.length){
            this.nomeApps[this.numApps]=nome;
            this.numApps++;
            this.espacoOcupado += tamanho;
        }
}
/**
 * c) recebe e guarda uma mensagem de texto 
 */
public void recebeMsg(String msg){
    if(this.numMensagens < this.mensagens.length){
        this.mensagens[this.numMensagens]=msg;
        this.numMensagens++;
    }
}
/**
 * d) determina o tamanho medio das aplicacoes
 */
public double tamMedioApps(){
    return numApps/dimApps;
}
/**
 * e) devolve a maior mensagem recebida 
 */
public String maiorMsg(){
    String maior=mensagens[0];
    for(int i=0; i<numMensagens;i++){
        if(this.mensagens[i].length()>maior.length()){
            maior=this.mensagens[i];
        }
    }
    return maior;
}
/**
 * f) desinstala uma aplicacao
 */
public void removeApp(String nome, int tamanho){
    int i;
    for(i=0;i<this.numApps;i++){
        if(this.nomeApps[i]== nome){
            for(int j=i;j<this.numApps;j++) nomeApps[i]=nomeApps[i+1];
            this.numApps--;
            this.espacoOcupado-=tamanho;
        }
    }
}
 public Telemovel clone(){
        return new Telemovel(this);
    }
public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("marca:");
        sb.append(this.getMarca());
        sb.append("\nmodelo:");
        sb.append(this.getModelo());
        sb.append("\nx:");
        sb.append(this.getX());
        sb.append("\ny:");
        sb.append(this.getY());
        sb.append("\nnummensagens:");
        sb.append(this.getnumMensagens());
        sb.append("s\n:");
        for(int j = 0; j < this.mensagens.length; j++){
             sb.append("Mensagem número");
            sb.append(j+1);
            sb.append(": ");
            sb.append(this.mensagens[j]);
            sb.append("\n");
            
        }
        
        sb.append("\ndimfotos:");
        sb.append(this.getdimFotos());
        sb.append("\ndimapps");
        sb.append(this.getdimApps());
        sb.append("\naramtotal:");
        sb.append(this.getarmazenamentoTotal());
        sb.append("\nespacoOcupado");
        sb.append(this.getespacoOcupado());
         sb.append("\nnumfotos:");
        sb.append(this.getnumFotos());
        sb.append("\nnumapps:");
        sb.append(this.getnumApps());
        sb.append("s\n");
        for(int i = 0; i < this.nomeApps.length; i++){
            sb.append("Nome número");
            sb.append(i+1);
            sb.append(": ");
            sb.append(this.nomeApps[i]);
            sb.append("\n");
        }
        return sb.toString();
    }
 
}
        
      
             
       
     
       
