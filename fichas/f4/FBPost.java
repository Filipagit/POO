package f4;

import java.util.ArrayList;
import java.time.LocalDateTime;
/**
 * Escreva a descrição da classe FBPost aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class FBPost
{
   private int id;
    private String nome;
    private LocalDateTime data;
    private String conteudo;
    private int numlikes;
    private ArrayList<String> comentarios;
    
    public FBPost(){
        this.id=0;
        this.nome= new String();
        this.data=LocalDateTime.now();
        this.conteudo=new String();
        this.numlikes=0;
        this.comentarios=new ArrayList<>();
    }
    public FBPost(int id,String nome,LocalDateTime data,String conteudo,int numlikes,ArrayList<String> comentarios){
        this.id=id;
        this.nome=nome;
        this.data=data;
        this.conteudo=conteudo;
        this.numlikes=numlikes;
        this.comentarios=comentarios;
    }
   public FBPost(FBPost post){
       this.id=post.getID();
       this.nome=post.getNome();
       this.data=post.getData();
       this.conteudo=post.getConteudo();
       this.numlikes=post.getNumLikes();
       this.comentarios=post.getComentarios();
    }
   public int getID(){
       return this.id;
    }
   public void setID(int id){
       this.id=id;
    }
   public String getNome(){
       return this.nome;
    }
   public void setNome(String nome){
       this.nome=nome;
    }
   public LocalDateTime getData(){
       return this.data;
    }
   public void setData(LocalDateTime data){
       this.data=data;
    }
   public String getConteudo(){
       return this.conteudo;
    }
   public void setConteudo(String conteudo){
       this.conteudo=conteudo;
    }
   public int getNumLikes(){
       return this.numlikes;
    }
   public void setNumLikes(int numlikes){
       this.numlikes=numlikes;
    }
   public  ArrayList<String> getComentarios(){
       ArrayList<String> novo= new ArrayList<>();
       for(String s : this.comentarios)
          novo.add(s);
         return novo;
        }
   public void setComentarios(ArrayList<String> comentarios){
       this.comentarios=new ArrayList<String>();
       this.comentarios.addAll(comentarios);
    }
      public FBPost clone(){
        return new FBPost(this);
    }
      public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(this.id);
        sb.append("\nNome: ").append(this.nome);
        sb.append("\nData: ").append(this.data);
        sb.append("\nConteudo: ").append(this.conteudo);
        sb.append("\nLikes: ").append(this.numlikes);
        sb.append("\nComentários: ").append(this.comentarios);

        return sb.toString();

    }
    public boolean equals(Object o) {
        if(o==this) return true;
        if(o==null || o.getClass() != this.getClass()) return false;
        FBPost post = (FBPost) o;
        return this.nome.equals(post.getNome()) &&
                this.id == post.getID() &&
                this.data.equals(post.getData()) &&
                this.conteudo.equals(post.getConteudo()) &&
                this.numlikes == post.getNumLikes() &&
                this.comentarios.equals(post.getComentarios());
    }
}
