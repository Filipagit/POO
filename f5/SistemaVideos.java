package fichas.f5;
import java.util.Map;
import java.util.HashMap;
import java.time.LocalDate;
import java.util.*;
import java.time.chrono.ChronoLocalDateTime;

/**
 * Escreva uma descrição da classe SistemaVideos aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class SistemaVideos
{
    private Map<String,Youtube> videos;
  
    public SistemaVideos(){
        this.videos= new HashMap<>();
    }
    
    public SistemaVideos(Map<String,Youtube> videos){
        this.setVideos(videos);
    }
    
    public SistemaVideos(SistemaVideos sv){
        this.setVideos(sv.getVideos());
    }
    
    public Map<String,Youtube> getVideos(){
        Map<String,Youtube> v = new HashMap<>();
        this.videos.forEach((key,value)-> v.put(key,value.clone()));
        return v;
    }
    
    public void setVideos(Map<String,Youtube> videos){
        videos.forEach((key,value) -> this.videos.put(key,value.clone()));
    }
     public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SistemaVideos that = (SistemaVideos) o;
        return Objects.equals(videos, that.videos);
    }

    public String toString() {
        return "SistemaVideos{" +
                "videos=" + videos +
                '}';
    }
    
    /**
     * ii)adicionar um novo video ao sistema conseguii
     */
     public void addVideo(Youtube y){
         this.videos.put(y.getContent(),y.clone());
     }
    
    /**
     * iii) dado um código de video devolver a instância associado conseguii
     */ 
    
public Youtube getVideo(String codVideo){
    return this.videos.get(codVideo);
}
/**
 * iv) remover um video dado um código conseguii
 */
public void removeVideo(String codVideo){
    this.videos.remove(codVideo);
}

/**
 * v) dado um código de video adicionar mais um like ao mesmo
 */
public void addLike(String codVideo){
    this.videos.get(codVideo).thumbsUp();
}
/**
 * vi) devolver o código do video com mais likes 
 */
public String topLikes(){
    String nova= new String();
    int maisl=0;
     for(Youtube v : this.videos.values()){
         if(v.getLikes()> maisl){
             maisl=v.getLikes();
             nova=v.getCode();
         }
     }
     return nova;
    }
/**
 * vii)devolver o código do video com mais likes num intervalo de tempo 
 */    
public String topLikes(LocalDate dinicial, LocalDate dfinal){
    String nova= new String();
    int maisl=0;
    for(Youtube v : this.videos.values()){
        if(v.getLikes() > maisl && v.getUpDate().isAfter(dinicial) && v.getUpDate().isBefore(dfinal)){
            maisl=v.getLikes();
            nova=v.getCode();
        }
    }
    return nova;
}
/**
 * viii) devolve o video mais longo
 */
public Youtube videoMaisLongo(){
    int maxMin=0;
    int maxSeg=0;
    Youtube nova=null;
    for(Youtube v : this.videos.values()){
        if(v.getDurMin() > maxMin){
            maxMin=v.getDurMin();
            nova=this.videos.put(v.getContent(),v.clone());
        } 
        else if(v.getDurMin()==maxMin && v.getDurSec()> maxSeg){
            maxMin=v.getDurMin();
            maxSeg=v.getDurSec();
            nova=this.videos.put(v.getContent(),v.clone());
        }
        }
        return nova;
    }
}
