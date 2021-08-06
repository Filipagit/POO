package fichas.f5;

import java . util . Set ;
import java . util . Map ;
import java . util . HashMap ;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.TreeSet;

 public class Grafo {
 // variáveis de instância
 private Map < Integer , Set < Integer > > adj ;
// " lista " de adjacência

 public Grafo(){
        this.adj = new HashMap<>();
    }
     public Grafo(Map<Integer, Set<Integer>> adj){
        setAdj(adj);
    }
  public void setAdj(Map<Integer, Set<Integer>> adj){
        this.adj = new HashMap<>();

        for(Integer i : adj.keySet())
            this.adj.put(i, new HashSet<>(adj.get(i)));
    }
    
    /**
     * ii) método que adiciona um arco ao grafo
     */
    public void addArco(Integer vOrig, Integer vDest) {
        if(!adj.containsKey(vOrig)){
            adj.put(vOrig,new HashSet<>());
        }
        if(!adj.containsKey(vDest)){
            adj.put(vDest,new HashSet<>());
        }
        adj.get(vOrig).add(vDest); //  vai buscar a lista dos nós que saem do vOrig e adiciona o vDest;
    }
    /**
     * iii) método que determina se um vértice é um sink lista adj vazia
     */
    public boolean isSink(Integer v){
        return this.adj.containsKey(v) && this.adj.get(v).isEmpty();
    }
    /**
     * iv) método que determina se um vértice é um source (não existem arcos a entrar nele).
     */
    public boolean isSource(Integer v){
       if(this.adj.containsKey(v)) return false;
       for(Set<Integer> s : this.adj.values())
           if(s.contains(v)) 
             return false;
             
        return true;
    }
    /**
     * v) calcula o tamanho de um grafo
     */
   public int size(){
        int tam=this.adj.size();
        tam+= this.adj.values().stream().mapToInt(x-> x.size()).sum();
        return tam;
    }
    /**
     * vi) determina se existe caminho entre 2 vertices
     */
    public boolean haCaminho(Integer vOrig, Integer vDest){
        return haCaminhoAux(vOrig,vDest, new HashSet<>());
    }
    public boolean haCaminhoAux(Integer o, Integer d, Set<Integer> visitados){
        boolean haC;
        if(o==d)
           haC=true;
           else{
               if(visitados.contains(o))
               haC=false;
               else{
                   Iterator<Integer> i = adj.get(o).iterator();
                   haC=false;
                   visitados.add(o);
                   while(i.hasNext() && !haC)
                   haC=haCaminhoAux(i.next(),d,visitados);
               }
           }
           return haC;
    }
    
    /**
     * vii) calcula o caminho entre 2 vertices
     */
    public List<Integer> getCaminho(Integer vOrig, Integer vDest){
        if(!this.adj.containsKey(vOrig)) return null;
        if(vOrig==vDest){
            List<Integer> l = new ArrayList<>();
            l.add(vOrig);
            return l;
        }
        for(Integer n : this.adj.get(vOrig)){
            if(haCaminho(n,vDest)){
                List<Integer> l =getCaminho(n,vDest);
                l.add(0,vOrig);
                return l;
            }
        }
        return null;
    }
    /**
     * viii) calcula o conjunto de tds os arcos que entram num vertice
    */
   public Set<Map.Entry<Integer, Integer>> fanOut (Integer v){
        if(this.adj.containsKey(v)) return null;
        
        Set<Map.Entry<Integer,Integer>> res = new TreeSet();    //  AQUI NÃO PODEMOS FAZER new Set<>(), pq supreendemen-te o Set é UMA INTERFACE;
        
        /*
         *  for(Map.Entry<int,Set<int>> e: adj.entrySet()){
            if(e.getValue().containsKey(v)){
            res.add(new AbstractMap.SimpleEntry(e.getKey(),v));
            }
        }*/
        
        for(Integer a: adj.get(v)){
            res.add(new AbstractMap.SimpleEntry<Integer,Integer>(v,a));
        }
        return res;
          }
/**
 * ix) determina se um grafo é subgrafo de g
 */
public boolean subGrafo(Grafo g) {
     if (!g.adj.keySet().containsAll(this.adj.keySet())) return false;

        for (Integer v : this.adj.keySet()) {
            if (!g.adj.get(v).containsAll(this.adj.get(v))) return false;
        }

        return true;
    }
}

