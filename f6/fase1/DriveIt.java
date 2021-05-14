package fichas.f6.fase1;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;


/**
 * Escreva uma descrição da classe DriveIt aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class DriveIt
{
    private String nome;
    private Map<String,Veiculo> veiculos;
    
    public DriveIt(){
        this.nome="";
        this.veiculos= new HashMap<>();
    }
    
    public DriveIt(String nome,Map<String,Veiculo> veiculos){
        this.nome=nome;
        this.veiculos=veiculos.entrySet().stream()
                           .collect(Collectors.toMap(e->e.getKey(),e->e.getValue().clone()));
    }
    
    public DriveIt(DriveIt di){
        this.nome=di.getNome();
        this.veiculos=di.getVeiculos();
    }
    public String getNome(){
        return this.nome;
    }
    public Map<String,Veiculo> getVeiculos(){
        return this.veiculos.entrySet().stream()
                .collect(Collectors.toMap(e->e.getKey(),e->e.getValue().clone()));
    }
    public DriveIt clone(){
        return new DriveIt(this);
    }
    
    /**
     * a)verificar se o veiculo existe dado o seu codigo conseguii
     */
    public boolean existeVeiculo(String cod){
        return this.veiculos.containsKey(cod);
    }
    /**
     * b) calcula a quantidade de veiculos existentes conseguii
     */
    public int quantos(){
        return this.veiculos.size();
    }
    /**
     * c) numero total de veiculos de uma marca
     */
    public int quantos(String marca){
        return (int) this.veiculos.values().stream()
                      .filter(x-> x.getMarca().equals(marca)).count();
    }
    /**
     * d) devolve a informacao de um veiculo dado o seu codigo conseguii
     */
    public Veiculo getVeiculo(String cod){
        return this.veiculos.get(cod);
    }
    /**
     * e) adiciona um veiculo conseguiii
     */
    public void adiciona(Veiculo v){
         this.veiculos.put(v.getMatricula(),v.clone());
    }
    
    /**
     * f) devolver uma lista contendo uma copia de tds os veiculos conseguii
     */
    public List<Veiculo> getVeiculoss(){
        List<Veiculo> l = new ArrayList<>();
          for(Veiculo v : this.veiculos.values())
             l.add(v.clone());
             return l;
    }
    
    /**
     * g) adiciona a informaçao de um conjunto de veiculos
     */
    public void adiciona(Set<Veiculo> vs){
     for(Veiculo v : vs)
            this.adiciona(v.clone());
    }
    /**
     * h) registar um aluguer e indicar o nr de km feitos por esse cliente conseguii
     */
    public void registarAluguer(String codVeiculo, int numKms){
         this.veiculos.get(codVeiculo).addViagem(numKms);
    }
    /**
     * i) classificar o veiculo qd termina o aluguer conseguiii
     */
    public void classificarVeiculo(String cod, int classificacao){
        this.veiculos.get(cod).addClassificacao(classificacao);
    }
    
    /**
     * j) calcula o custo real por km conseguiii
     */
    public int custoRealKm(String cod){
        return (int) this.veiculos.get(cod).custoRealKM();
    }
    
}
