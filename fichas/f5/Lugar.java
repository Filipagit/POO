package fichas.f5;


/**
 * Escreva uma descrição da classe Lugar aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Lugar
{
/** Matricula do veiculo estacionado */
private String matricula ; 
/** Nome do proprietario */
private String nome ;
/** Tempo atribuido ao lugar , em minutos */
private int minutos ;
/** Indica se lugar é permanente , ou de aluguer
*/
private boolean permanente ;
  public Lugar(){
      this.matricula="";
      this.nome="";
      this.minutos=0;
      this.permanente=false;
  }
  public Lugar(String matricula,String nome,int minutos, boolean permanente){
      this.matricula=matricula;
      this.nome=nome;
      this.minutos=minutos;
      this.permanente=permanente; 
  }
  public Lugar(Lugar l){
      this.matricula=l.getMatricula();
      this.nome=l.getNome();
      this.minutos=l.getMinutos();
      this.permanente=l.getPermanente();
  }
  public String getMatricula(){
      return this.matricula;
  }
  public void setMatricula(String matricula){
      this.matricula=matricula;
  }
  public String getNome(){
     return this.nome;
  }
  public void setNome(String nome){
      this.nome=nome;
  }
  public int getMinutos(){
      return this.minutos;
  }
  public void setMinutos(int minutos){
      this.minutos=minutos;
  }
  public boolean getPermanente(){
      return this.permanente;
  }
  public void setPermanente(boolean permanente){
      this.permanente=permanente;
  }
   public Lugar clone(){
       return new Lugar(this);
   }
    public String toString() {
        
        StringBuffer sb = new StringBuffer();
        
        sb.append("Matricula = "+this.getMatricula());
        sb.append("Nome = "+this.getNome());
        sb.append("Minutos = "+this.getMinutos());
        sb.append("Permanente = "+this.getPermanente());
        
        return sb.toString();
        
    }
    
    public boolean equals(Object o) {
        if (this == o)
          return true;
          
        if((o == null) || (this.getClass() != o.getClass()))
          return false;
          
        Lugar umLugar = (Lugar) o;
        return (this.matricula.equals(umLugar.getMatricula()) && this.nome.equals(umLugar.getNome()) 
              && this.minutos == umLugar.getMinutos() && this.permanente == umLugar.getPermanente());
    }         
}
