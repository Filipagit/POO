package f4;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Escreva a descrição da classe EncEficiente aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class EncEficiente
{
    //variaveis de instancia
    private String nomeCliente;
    private int nif;
    private String morada;
    private int numeroenc;
    private LocalDate data;
    private ArrayList<LinhaEncomenda> linhas;
    
   /**
    * Construtor vazio para objetos da classe EncEficiente
    */
   public EncEficiente(){
       this.nomeCliente=null;
       this.nif=-1;
       this.morada=null;
       this.numeroenc=-1;
       this.data= LocalDate.now();
       this.linhas= new ArrayList<LinhaEncomenda>();
    }
    /**
    * construtor parametrizado
    */
   public EncEficiente(String nomeCliente,int nif,String morada,int numeroenc,LocalDate data,ArrayList<LinhaEncomenda> linhas){
       this.nomeCliente=nomeCliente;
       this.nif=nif;
       this.morada=morada;
       this.numeroenc=numeroenc;
       this.data=data;
       this.setLinhas(linhas);
    }
    
 
/**
 * construtor de EncEficiente por copia
 */
public EncEficiente(EncEficiente enc){
    this.nomeCliente=enc.getNomeCliente();
    this.nif=enc.getNif();
    this.morada=enc.getMorada();
    this.numeroenc=enc.getNumeroEnc();
    this.data=enc.getData();
    this.setLinhas(enc.getLinhas());
}

public String getNomeCliente(){
    return this.nomeCliente;
}
public void setNomeCliente(String nomeCliente){
    this.nomeCliente=nomeCliente;
}
public int getNif(){
    return this.nif;
}
public void setNif(int nif){
    this.nif=nif;
}
public String getMorada(){
    return this.morada;
}
public void setMorada(String morada){
    this.morada=morada;
}
public int  getNumeroEnc(){
    return this.numeroenc;
}
public void setNumeroEnc(int numeroenc){
    this.numeroenc=numeroenc;
}
public LocalDate getData(){
    return this.data;
}
public void setData(LocalDate data){
    this.data=data;
}
public ArrayList<LinhaEncomenda> getLinhas(){
    return this.linhas;
}
public void setLinhas(ArrayList<LinhaEncomenda> linhas){
       this.linhas= new ArrayList<>();
       for(LinhaEncomenda le:linhas){
           this.linhas.add(le.clone());
    }
}
/**
 * ii) metodo que determina o valor total da encomenda
 */
public double calculaValorTotal(){
    double total=0;
    for(LinhaEncomenda le : this.linhas){
        total+=le.calculaValorLinhaEnc();
    }
    return total;
}
/**
 * iii) metodo que determina o numero total dos descontos obtidos
 */ 
public double calculaValorDesconto(){
    double totdesconto=0;
    for(LinhaEncomenda le : this.linhas){
        totdesconto += le.calculaValorDesconto();
    }
    return totdesconto;
}
/**
 * iv) metodo que determina o numero total de produtos a receber  
 */
public int numeroTotalProdutos(){
    int totalprod=0;
    for(LinhaEncomenda le : this.linhas){
        totalprod += le.getQuantidade();
    }
    return totalprod;
}
/**
 * v) metodo que determina se um produto vai ser encomendado
 */
public boolean existeProdutoEncomenda(String refProduto){
    for(LinhaEncomenda le : this.linhas)
        if(refProduto.equals(le.getReferencia())) 
          return true;
        return false;
}

/**
 * vi) metodo que adiciona uma nova linha de encomenda
 */
public void  adicionaLinha(LinhaEncomenda linha){
    this.linhas.add(linha);
}
/**
 * vii) metodo que remove uma linha de encomenda dado a referencia do produto
 */
public void removeProduto(String codProd){
    for(LinhaEncomenda le : this.linhas){
        if(codProd.equals(le.getReferencia())) this.linhas.remove(le);
    }
}


    public String toString() {
        final StringBuffer sb = new StringBuffer("Encomenda {\n");
        sb.append("\tNome do cliente = '").append(nomeCliente).append("'\n");
        sb.append("\tNIF = ").append(nif).append('\n');
        sb.append("\tMorada = '").append(morada).append("'\n");
        sb.append("\tNúmero da encomenda = ").append(numeroenc).append('\n');
        sb.append("\tData = ").append(data.toString()).append('\n');
        sb.append("\tLinhas = ").append(linhas.toString()).append('\n');
        sb.append('}');
        return sb.toString();
    }
     public EncEficiente clone() {
        return new EncEficiente(this);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        EncEficiente enc = (EncEficiente) o;
        return this.nif == enc.nif &&
                this.numeroenc == enc.numeroenc &&
                this.nomeCliente.equals(enc.nomeCliente) &&
                this.morada.equals(enc.morada) &&
                this.data.equals(enc.data) &&
                this.linhas.equals(enc.linhas);
}
}
 
