package f2;
import java.util.Arrays;

/**
 * Escreva a descrição da classe ex4 aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class ex4
{
    // variáveis de instância;
    private int [] a;

/**
     * Construtor de copia de array, dado um array no imput o copia para o original
     */
    public ex4(int [] a)
    {
        this.a=a;
    }
 /* 
 * a) metodo que ordene um array de inteiros por ordem crescente conseguii
 */
public void ordenaArray(){
    int i,j;
    for(i=0;i<a.length;i++){
        for(j=i+1;j<a.length;j++){
            if(a[i]>a[j]){
               int tmp=a[i];
               a[i]=a[j];
               a[j]=tmp;
            }
        }
}
}
/*
 * b) metodo que implementa a procura binaria(array ordenado) de um array de inteiros
 */
public int procuraBin(int x){
   int inf=0; //limite inferior ( o primeiro indice :0)
   int sup=a.length-1;// limte superior(termina um nr a menos 0 a 9 sao 10 nrs)
   int meio;
   while(inf<=sup){
       meio=(inf+sup)/2;
       if(x==a[meio])
       return meio;
       if(x<a[meio])
       sup=meio-1;
       else inf=meio+1;
   }
   return -1;//elemento nao encontrado
}
}