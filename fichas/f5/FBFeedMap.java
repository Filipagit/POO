package fichas.f5;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.time.LocalDateTime;


/**
 * Escreva uma descrição da classe FBFeedMap aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class FBFeedMap
{
    private Map<String, List<FBPost>> feed;
    
    public FBFeedMap(){
        this.feed= new HashMap<>();
    }
    
    public FBFeedMap( Map<String, List<FBPost>> feed){
        this.feed=feed;
    }
    public FBFeedMap(FBFeedMap f){
        this.feed=f.getFeed();
    }
    public void setFeed( Map<String, List<FBPost>> feed){
        this.feed= new HashMap<>();
        for(String s : feed.keySet())
          this.feed.put(s,new ArrayList<>(feed.get(s)));
    }
    public Map<String, List<FBPost>> getFeed(){
        Map<String, List<FBPost>> r = new HashMap<>();
        for(String s : this.feed.keySet())
        r.put(s,new ArrayList<>(this.feed.get(s)));
        return r;
    }
    
    /**
     * i) adicionar um post de um utilizador
     */
    public void addPost(String user,FBPost post){
        this.feed.get(user).add(post);
    }
    /**
     * ii) remove os posts de um utilizador entre 2 datas 
     */
    public void removePosts(String user, LocalDateTime di, LocalDateTime df){
        for(FBPost fb : this.feed.get(user))
           if(!fb.getData().isBefore(di) && !fb.getData().isAfter(df))
           this.feed.get(user).remove(fb);
    }
    
    /**
     * iii) determina quantos posts foram publicados entre  2 datas 
     */
    public int postsNumPeriodo(String user,LocalDateTime di, LocalDateTime df){
        int numPosts=0;
        for(FBPost fb : this.feed.get(user)){
            if(!fb.getData().isBefore(di) && !fb.getData().isAfter(df))
            numPosts++;
        }
        return numPosts;
    }
    
    /**
     * iv) determina o utilizador mais ativo entre 2 datas 
     */
    public String utilizadorMaisActivo(LocalDateTime di, LocalDateTime df){
        String user="";
        int u=0;
        int aux=0;
        for(String s : this.feed.keySet()){
            aux=this.postsNumPeriodo(s,di,df);
            if(aux > u){
                u=aux;
                user=s;
            }
        }
        return user;
    }
    
    /**
     * v) determina a timeline do sist ordenado cronologicamente
     */
     public List<FBPost> timelineGlobal(){
         Map<LocalDateTime, FBPost> aux = new HashMap<>();
         List<FBPost> p = new ArrayList<>();
         for(String user : this.feed.keySet())
            for(FBPost fp :  this.feed.get(user))
                aux.put(fp.getData(),fp.clone());
                p.addAll(aux.values());
        return p;
    }
    
    /**
     * vi) valida que nao existe nenhum user que tenha feito mais que 1 post num dado instante
     */
    public boolean validaPostsSimultaneos(){
        int l_size,s_size;
        for(String user : this.feed.keySet()){
            l_size= this.feed.get(user).size();
            s_size= this.feed.get(user).stream()
                      .map(fp-> fp.getData()).collect(Collectors.toSet()).size();
            if(l_size != s_size)
                return false;
        }

        return true;
    }

}

