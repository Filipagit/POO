package testes.t2021;

import com.sun.source.tree.UsesTree;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class CasaInteligente {
    private Map<String, SmartDevice> devices; //info de tds os disp existentes
    private Map<String, List<String>> dispdiv; // dispositivos em cada div
    private final Consumer<SmartBulbDimmable> consumer = sd -> sd.setIntensidade(sd.getIntensidade()*0.25);

    public CasaInteligente(CasaInteligente c) {
        this.devices = c.getDispositivos();
        this.dispdiv = c.getDispDiv();
    }

    public Map<String, SmartDevice> getDispositivos() {
        return this.devices;
    }

    public Map<String, List<String>> getDispDiv() {
        return this.dispdiv;
    }

    /**
     * 6) Efectue a declaracao das variaveis de instancia de CasaInteligente e codifique o construtor que recebe uma colecao de SmartDevice e que assume que estamos numa estrategia de
     * composicao
     */
    public CasaInteligente(Collection<SmartDevice> devices) {
        Iterator<SmartDevice> it = devices.iterator();
        SmartDevice s;
        while (it.hasNext()) {
            s = it.next();
            this.devices.put(s.getId(), s.clone());
        }
    }

    /**
     * 8) remove completamente
     * do sistema o dispositivo cujo identificador é passado por parametro
     */
    public void remove(String id) throws IdNaoExisteException{
        if(!this.devices.containsKey(id)) throw new IdNaoExisteException();
        else{
            this.devices.remove(id);
        }
    }

    /**
     * 9)devolve um iterador com ordenacao crescente por consumo
     */
    public Iterator<SmartDevice> devicesPorConsumoCrescente(){
        TreeSet<SmartDevice> treeAdd = new TreeSet<>(devices.values());
        return treeAdd.iterator();
    }

    /**
     * 10)que determina a divisao da casa que apresenta o menor consumo. Se duas divisoes apresentarem o
     * mesmo consumo entao devera ser devolvida a divisao cuja designacao tem o maior valor
     * alfabetico.                                                                                   nao entendi mt bem
     */
    public String divisaoMaisEconomica() {
        Map<String, Double> consumos = new HashMap<>();
        TreeSet<Map.Entry<String, Double>> t = new TreeSet<>(new MapEntryComparator());
        double consumotot = 0;

        for(String d : this.dispdiv.keySet()){
            for(SmartDevice s : this.devices.values())
                consumotot += s.getConsumoPorHora();
            consumos.put(d,consumotot);
            consumotot=0;
        }
        for(Map.Entry<String, Double> map : consumos.entrySet())
            t.add(map);
        return  t.first().getKey();
    }
    /**
     * 12) nao entendiiiii
     */
    public void alteraInfo(Consumer<SmartBulbDimmable> bd){
        Set<SmartBulbDimmable> s =  new HashSet<>();
         for(SmartDevice sd : this.devices.values()){
             if(sd instanceof SmartBulbDimmable){
                 SmartBulbDimmable sb = (SmartBulbDimmable) sd;
                 s.add(sb);
             }
         }
         s.forEach(bd);
    }

    /**
     * 13) da true se nao existir nenhum SD em mais que uma div
     */
    public boolean apenasNumaDivisao() {
        Set<String> ids = new HashSet<>();
          for(List<String> l : this.dispdiv.values()){
              for (String s : l){
                  if(!ids.contains(s)) ids.add(s);
                  else return false;
              }
          }
          return  true;
    }
    /**
     * 14)Codifique o metodo que grava num ficheiro de objectos, cujo nome é fornecido no parametro,
     * todas os SmartSpeaker existentes na casa.
     */
    public void gravaEmFichObjectos(String fich) throws FileNotFoundException, IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fich));
           for(SmartDevice s : this.devices.values())
                if(s instanceof SmartSpeaker)
                    oos.writeObject(s);
                oos.flush();
                oos.close();
    }
}




