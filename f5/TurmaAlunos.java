package fichas.f5;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Collection;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Escreva uma descrição da classe TurmaAlunos aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class TurmaAlunos
{   
   private Map<String,Aluno> turma; 
   private  String uc;
   private String nomeT;
   
   public TurmaAlunos(){
       this.turma= new HashMap<>();
       this.nomeT="";
       this.uc="";
   }
   
   public TurmaAlunos(Map<String,Aluno> turma, String nomeT, String uc){
       this.turma= new HashMap<>();
       this.nomeT=nomeT;
       this.uc=uc;
   }
   
   public TurmaAlunos(TurmaAlunos t){
       this.turma=t.getTurma();
       this.nomeT=t.getNomeT();
       this.uc=t.getUC();
   }
   
   public  Map<String,Aluno> getTurma(){
        Map<String,Aluno> t1= new HashMap<>();
        for(Aluno a : this.turma.values()){
            t1.put(a.getNumero(),a.clone());
        }
        return t1;
   }
   
   public void setTurma( Map<String,Aluno> turma){
       for(Aluno a : turma.values()){
           this.turma.put(a.getNumero(),a.clone());
       }
   }
   
   public String getNomeT(){
       return this.nomeT=nomeT;
   }
   public void setNomeT(String nomeT){
       this.nomeT=nomeT;
   }
   public String getUC(){
       return this.uc;
   }
   public void setUC(String uc){
       this.uc=uc;
   }
   public TurmaAlunos clone(){
        return new TurmaAlunos(this);
   }
   public boolean equals(Object o){
        if (this == o) return true;
        else if (o == null || this.getClass() != o.getClass()) return false;
        TurmaAlunos t = (TurmaAlunos) o;
        return (this.nomeT.equals(t.getNomeT()) && this.uc.equals(t.getUC()) && this.turma.equals(t.getTurma()));
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("Turma: ")
                .append(nomeT).append(" | ")
                .append(uc).append(" | ")
                .append(turma.toString())
                .append("\n");
        return sb.toString();
    }
    
     public int sizeT(){
        return this.turma.size();
    }
    
    public int compareTo(TurmaAlunos t1){
        return this.turma.size() - t1.sizeT();
    
    }
    
    /**
     * ii) adicionar um novo aluno à turma conseguii
     */
    public void insereAluno(Aluno a){
         this.turma.put(a.getNumero(),a.clone());
    }
    
    /**
     * iii)dado um código de aluno devolver a instância de Aluno associada
     */
    public Aluno getAluno(String codAluno){
        return this.turma.get(codAluno).clone();
    }
    
    /**
     * iv) remover um aluno dado o seu codigo conseguiii
     */
    public void removeAluno(String codAluno){
        this.turma.remove(codAluno);
    }
    /**
     * v) devolver a informação de todos os números de aluno existentes
     */
    public Set<String> todosOsCodigos(){
        Set<String> hs= new HashSet<>();
        for(String s : this.turma.keySet()){
            hs.add(s);
        }
        return hs;
    }
    /**
     * vi) devolver quantos alunos existem na turma conseguiii
     */
    public int qtsAlunos(){
        return this.turma.size();
    }
    /**
     * vii) devolver os alunos ordenados por ordem alfabética do seu nome
     */
    public Collection<Aluno> alunosOrdemAlfabetica(){
        Collection<Aluno> a = new TreeSet<>(Aluno::compareTo);//Aluno a a.compareTo
        for(Aluno al : this.turma.values()){
            a.add(al.clone());
        }
        return a;
    }
    
    /**
     * viii) devolver os alunos ordenados por ordem decrescente do seu número
     */
    public Set<Aluno> alunosOrdemDescrescenteNumero(){
        return this.turma.values().stream()
                .map(Aluno::clone).sorted((a1,a2)->a2.getNumero().compareTo(a1.getNumero()))
                .collect(Collectors.toSet());
    }
    
}
