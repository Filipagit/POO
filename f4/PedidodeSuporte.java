package f4;
import java.time.LocalDateTime;

/**
 * Escreva a descrição da classe PedidodeSuporte aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class PedidodeSuporte
{
    private String user; // quem efetuou o pedido
    private LocalDateTime datai; // instante em que foi submetido o pedido
    private String assunto;
    private String descricao;
    private String qtp;
    private LocalDateTime dataf;
    private String info;
    
    public PedidodeSuporte(){
        this.user="";
        this.datai=null;
        this.assunto="";
        this.descricao="";
        this.qtp="";
        this.dataf=null;
        this.info="";
    }
    public PedidodeSuporte(String user,LocalDateTime datai,String assunto,String descricao,String qtp,LocalDateTime dataf,String info){
        this.user=user;
        this.datai=datai;
        this.assunto=assunto;
        this.descricao=descricao;
        this.qtp=qtp;
        this.dataf=dataf;
        this.info=info;
    }
    public PedidodeSuporte(PedidodeSuporte p){
        this.user=p.getUser();
        this.datai=p.getDataI();
        this.assunto=p.getAssunto();
        this.descricao=p.getDescricao();
        this.qtp=p.getQtp();
        this.dataf=p.getDataF();
        this.info=p.getInfo();
    }
    
    public String getUser(){
        return this.user;
    }
     public void setUser(String user) {
        this.user = user;
    }
    public LocalDateTime getDataI() {
        return this.datai;
    }

    public void setDataI(LocalDateTime datai) {
        this.datai = datai;
    }

    public String getAssunto() {
        return this.assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getQtp() {
        return this.qtp;
    }

    public void setQtp(String qtp) {
        this.qtp = qtp;
    }

    public LocalDateTime getDataF() {
        return this.dataf;
    }

    public void setDataF(LocalDateTime dataf) {
        this.dataf = dataf;
    }

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    public PedidodeSuporte clone(){
        return new PedidodeSuporte(this);
}
}


    