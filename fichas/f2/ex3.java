package f2;
import java.util.Arrays;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;

/**
 * Escreva a descrição da classe ex3 aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class ex3
{
private LocalDate datas[];
private int tam;


public ex3(){
    this(10);
}
public ex3(int n){
    this.datas= new LocalDate[n];
    this.tam=0;
}
/**
 * a) inserir uma nova data
 */
public void insereData(LocalDate data){
    if(tam<datas.length)
    this.datas[tam++]=data;
}
/**
 * b) dada uma data determinar a data mais proxima
 */
public LocalDate dataMaisProxima(LocalDate data){
    long menordif=Math.abs(DAYS.between(data,this.datas[0])); //menor diferenca entre 2 datas 
    LocalDate datamaisproxima=this.datas[0];
    int i;
    for(i=0;i<this.tam;i++){
        LocalDate dataX=this.datas[i];
        long diasentre=Math.abs(DAYS.between(data,dataX));//calcula o nr de dias entre as 2 datas 
        if(diasentre<menordif){
        datamaisproxima=dataX;
        menordif=diasentre;
    }
}
return datamaisproxima;
}
/**
 * devolve uma string com todas as datas do array 
 */
public String toString(){
    return "ListadeLocalDates("+Arrays.toString(this.datas);
}
}
