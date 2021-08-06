package f3;


/**
 * Escreva a descrição da classe LinhaEncomenda aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class LinhaEncomenda
{
   private String referencia;
   private String descricao;
   private double precoantes;
   private int quantidade;
   private double imposto;
   private double desconto;
   
   public LinhaEncomenda(){
       this.referencia=("");
       this.descricao=("");
       this.precoantes=0;
       this.quantidade=0;
       this.imposto=0;
       this.desconto=0;
    }
    public LinhaEncomenda(String referencia,String descricao,double precoantes,int quantidade,double imposto,double desconto){
       this.referencia=referencia;
       this.descricao=descricao;
       this.precoantes=precoantes;
       this.quantidade=quantidade;
       this.imposto=imposto;
       this.desconto=desconto;
    }
    public LinhaEncomenda(LinhaEncomenda le){
       this.referencia=le.getReferencia();
       this.descricao=le.getDescricao();
       this.precoantes=le.getPrecoantes();
       this.quantidade=le.getQuantidade();
       this.imposto=le.getImposto();
       this.desconto=le.getDesconto();
    }
   public String getReferencia(){
       return this.referencia;
    }
   public void setReferencia(String referencia){
       this.referencia=referencia;
    }
   public String getDescricao(){
       return this.descricao;
    }
   
    public double getPrecoantes() {
        return this.precoantes;
    }

    public void setPrecoantes(double precoantes) {
        this.precoantes = precoantes;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getImposto() {
        return this.imposto;
    }

    public void setImposto(double imposto) {
        this.imposto =imposto;
    }

    public double getDesconto() {
        return this.desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    } 
   public LinhaEncomenda clone(){
       return new LinhaEncomenda(this);
    }
        public String toString() {
        final StringBuffer sb = new StringBuffer("Linha de Encomenda {\n");
        sb.append("\treferência='").append(referencia).append("',\n");
        sb.append("\tdescrição='").append(descricao).append("',\n");
        sb.append("\tpreco antes de impostos=").append(precoantes).append(",\n");
        sb.append("\tquantidade encomendada=").append(quantidade).append(",\n");
        sb.append("\timposto=").append(String.format("%.2f%%",imposto)).append(",\n");
        sb.append("\tdescontoComercial=").append(String.format("%.2f%%",desconto)).append(",\n");
        sb.append('}');
        return sb.toString();
    }
    public boolean equals(Object obj) {
        if(obj==this) return true;
        if(obj==null || obj.getClass() != this.getClass()) return false;
        LinhaEncomenda le = (LinhaEncomenda) obj;
        return le.getReferencia().equals(this.referencia) &&
              le.getDescricao().equals(this.descricao) && 
              le.getPrecoantes() == this.precoantes;
    }
   /**
    * b) determina o valor da venda com os impostos e descontos 
    */ 
   public double calculaValorLinhaEnc(){
       double valor=this.quantidade*this.precoantes;
       valor-=this.desconto;
       valor*=1+this.imposto;
       return valor;
    }
  
    
   /**
    * c) determina o valor do desconto em euros 
    */ 
   public double calculaValorDesconto(){
       double valor= this.quantidade*this.precoantes;
       valor*=this.imposto;
       return this.calculaValorLinhaEnc()-valor;
    }
    
}

