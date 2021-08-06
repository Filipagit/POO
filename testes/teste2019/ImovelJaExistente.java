package testes.teste2019;


/**
 * Escreva a descrição da classe ImovelNaoExistente aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */

public class ImovelJaExistente extends Exception{
    public ImovelJaExistente(){
        super();
    }

    public ImovelJaExistente(String s){
        super(s);
    }
}
