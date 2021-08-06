package f3;


/**
 * Escreva a descrição da classe Futebol aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Futebol
{
    private int estado;
    private int golosVisitantes;
    private int golosVisitados;
    
    public Futebol(){
        this.estado=0;
        this.golosVisitantes=0;
        this.golosVisitados=0;
    }
    public Futebol(Futebol f){
        this.estado=f.getEstado();
        this.golosVisitantes=f.getVisitantes();
        this.golosVisitados=f.getVisitados();
    }
    public Futebol(int estado, int golosVisitantes, int golosVisitados){
        this.estado=estado;
        this.golosVisitantes=golosVisitantes;
        this.golosVisitados=golosVisitados;
    }
    public int getEstado(){
        return this.estado;
    }
    public void setEstado(int estado){
        this.estado=estado;
    }
    public int getVisitantes(){
        return this.golosVisitantes;
    }
    public void setVisitantes(int golosVisitantes){
        this.golosVisitantes=golosVisitantes;
    }
    public int getVisitados(){
        return this.golosVisitados;
    }
    public void setVisitados(int golosVisitados){
        this.golosVisitados=golosVisitados;
    }
    public Futebol clone(){
        return new Futebol(this);
    }
    public String toString(){
        StringBuilder sb= new StringBuilder();
        sb.append("Estado:");
        sb.append(this.getEstado());
        sb.append("\nGolos visitantes:");
        sb.append(this.getVisitantes());
        sb.append("\nGolos visitados:");
        sb.append(this.getVisitados());
        return sb.toString();
    }
    
    /**
     * a) metodo que da inicio ao jogo
     */
    public void startGame(){
        this.setEstado(1);
    }
    /**
     * b) termina o jogo 
     */
    public void endGame(){
        this.setEstado(0);
    }
    /**
     * c) adiciona um golo a equipa visitada
     */
    public void goloVisitado(){
        int golos=this.getVisitados();
        this.setVisitados(++golos);
    }
    /**
     * d) devolve o resultado atual do jogo 
     */
    public String resultadoActual(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.getVisitados());
        sb.append(" - ");
        sb.append(this.getVisitantes());
        sb.append("\n");
        return sb.toString();
    }
    
    
}
