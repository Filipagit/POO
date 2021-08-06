package Recursos.r2021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpotifyPOO {
   private Map<String,Podcast> podcasts;
   private  Map<String,Utilizador> utilizadores;

   public SpotifyPOO() {
      this.podcasts = new HashMap<>();
      this.utilizadores = new HashMap<>();
   }

   public SpotifyPOO(SpotifyPOO s) {
      this.podcasts = s.getPodcasts();
      this.utilizadores = s.getUtilizadores();
   }
   public Map<String, Podcast> getPodcasts() {
      Map<String, Podcast> res = new HashMap<>();

      for (Map.Entry<String, Podcast> entry : this.podcasts.entrySet())
         res.put(entry.getKey(), entry.getValue().clone());

      return res;
   }

   public void setPodcasts(Map<String, Podcast> podcasts) {
      this.podcasts = podcasts;
   }

   public Map<String, Utilizador> getUtilizadores() {
      Map<String, Utilizador> res = new HashMap<>();

      for (Map.Entry<String, Utilizador> entry : this.utilizadores.entrySet())
         res.put(entry.getKey(), entry.getValue().clone());

      return res;
   }

   public void setUtilizadores(Map<String, Utilizador> utilizadores) {
      this.utilizadores = utilizadores;
   }

   /**
    * 6) dado um id de um podcast devolve uma lista com os ep disp para esse pod
    */
   public List<Episodio> getEpisodios(String nomePodcast){
      return this.podcasts.get(nomePodcast).getEpisodios();
   }

   /**
    * alternativa
    */
   public List<Episodio> getEpisodioss(String nomePodcast) throws podcastNaoExisteException{
           if(!this.podcasts.containsKey(nomePodcast)) throw  new podcastNaoExisteException();
           else{
              List<Episodio> ep= new ArrayList<>();
              Podcast p = new Podcast();
              p=podcasts.get(nomePodcast);
                for(Episodio e : p.getEpisodios()){
                   ep.add(e);
                }
                return  ep;
           }
   }

   /**
    * 8) remove o podcast
    */
   public void remove(String nomeP) throws podcastNaoExisteException,podcastSubException{
        if(!this.podcasts.containsKey(nomeP)) throw  new podcastNaoExisteException();
        else{
           for(Utilizador u : this.utilizadores.values()){
              if(u.getInfopodsub().contains(this.podcasts.get(nomeP))) throw new podcastSubException();
              else this.podcasts.remove(nomeP);
           }
        }
   }

   /**
    * 9)
    */
}
