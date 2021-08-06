package f3;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.lang.System;
/**
 * Escreva a descrição da classe YouTube aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class YouTube
{
    private String nomeV;
    private byte[] conteudo;
    private LocalDate data;
    private String  resolucao;
    private int[] tempo;    //  guardo o tempo como array, onde na primeira posição guardo os minutos e na segunda os segundos; 
    private String[] comentarios;
    private int likes;
    private int dislikes;
    private int numcomentarios;
   
    public YouTube(){
        this.nomeV="";
        this.conteudo= new byte[10];
        this.data=LocalDate.now();
        this.resolucao="1080p";
        this.comentarios= new String[100];
        this.likes=0;
        this.dislikes=0;
        this.numcomentarios=0;
    }
    public YouTube(YouTube y){
        this.nomeV=y.getNome();
        byte[] tmp = y.getConteudo();
        this.conteudo=new byte[tmp.length];
        System.arraycopy(tmp,0,conteudo,0,tmp.length);
        this.data=y.getData();
        this.resolucao=y.getResolucao();
        this.tempo=y.getTempo();
         String[] tp = y.getComentarios();
        this.comentarios=new String[tmp.length];
        System.arraycopy(tp,0,comentarios,0,tp.length);
        this.likes=y.getLikes();
        this.dislikes=y.getDislikes();
        this.numcomentarios=y.getNumcomentarios();
    }
    public String getNome(){
        return this.nomeV;
    }
    public void setNome(String nomeV){
        this.nomeV=nomeV;
    }
    public byte[] getConteudo(){
        byte[] tmp= new byte[this.conteudo.length];
        System.arraycopy(this.conteudo,0,tmp,0,this.conteudo.length);
        return tmp;
    }
    public void setConteudo(byte[] conteudo){
        byte[] tmp = new byte[conteudo.length];
        System.arraycopy(conteudo,0,tmp,0,conteudo.length);
        this.conteudo=tmp;
    }
    public LocalDate getData(){
        return this.data;
    }
    public void setData(LocalDate data){
        this.data=data;
    }
    public String getResolucao(){
        return this.resolucao;
    }
    public void setResolucao( String resolucao){
        this.resolucao=resolucao;
    }
    public int[] getTempo(){
        int[] tmp = new int[this.tempo.length];
        System.arraycopy(this.tempo, 0, tmp, 0, this.tempo.length);
        return tmp;
    }
    public int getMin(){
        return this.tempo[0];
    }
    public int getSegundos(){
        return this.tempo[1];
    }
    
    public void setTempo(int[] tempo){
        this.tempo = new int[tempo.length];
        System.arraycopy(tempo, 0, this.tempo, 0, tempo.length);
    }
    public String[] getComentarios(){
        return this.comentarios;
    } 
    public void setComentarios(String[] comentarios){
        this.comentarios=comentarios;
    }
    public int getDislikes(){
        return this.dislikes;
    }
    public void setDislikes(int dislikes){
        this.dislikes=dislikes;
    }
    public int getLikes(){
        return this.likes;
    }
    public void setLikes(int likes){
        this.likes=likes;
    }
    public int getNumcomentarios(){
        return this.numcomentarios;
    }
    public YouTube(String nomeV,byte[] conteudo,LocalDate data,String  resolucao,int[]  tempo,String[] comentarios,int likes,int dislikes,int numcomentarios){
        this.nomeV=nomeV;
        this.conteudo=conteudo;
        this.data=data;
        this.resolucao=resolucao;
        this.tempo=tempo;
        this.comentarios=comentarios;
        this.likes=likes;
        this.dislikes=dislikes;
        this.numcomentarios=numcomentarios;
    }
    
    /**
     * b) inserir comentario ao video 
     */
    public void insereComentario(String comentario){
        if(this.numcomentarios < this.comentarios.length){
            this.comentarios[this.numcomentarios]=comentario;
            numcomentarios++;
        }
    }
    
    /**
     * c) determina quantos dias passaram desde que o video foi publicado
     */
    public long qtsDiasDepois(){
        LocalDate datatual = LocalDate.now();
        LocalDate datavideo;
        datavideo=getData();
        long diferenca=datatual.until(datavideo,ChronoUnit.DAYS);// para ter o nr de dias
        return diferenca;
    }
    /**
     * d) faz um like 
     */    
    public void thumbsUp(){
        this.likes++;
    }
    /**
     * e)devolve o conteudo do video
     */    
    public String processa(){
      return String.valueOf(conteudo);//valueof(10) =10;
    }
    
    public YouTube clone(){
        return new YouTube(this);
    }
       public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("nome:");
        sb.append(this.getNome());
        sb.append("\nconteúdo:");
        for(int j = 0; j < this.conteudo.length; j++){
            sb.append(this.conteudo[j]);
        }
        sb.append("\ndata:");
        sb.append(this.getData());
        sb.append("\nresolução");
        sb.append(this.getResolucao());
        sb.append("\ntempo:");
        sb.append(this.getMin());
        sb.append("m");
        sb.append(this.getSegundos());
        sb.append("s\n");
        for(int i = 0; i < this.comentarios.length; i++){
            sb.append("Comentário número");
            sb.append(i+1);
            sb.append(": ");
            sb.append(this.comentarios[i]);
            sb.append("\n");
        }
        sb.append("likes:");
        sb.append(this.getLikes());
        sb.append("\ndislikes:");
        sb.append(this.getDislikes());
        
        return sb.toString();
    }
}


   