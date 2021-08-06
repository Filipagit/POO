package f2;
import java.util.Arrays;

/**
 * Escreva a descrição da classe ex1 aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class ex1
{
    /**
  * 1a ler inteiros para um array e determinar o minimo desse array e indicar em que posicao
  * conseguiii
  */   
 public int menorint(int [] a){
     int menor=a[0];
     int i;
     int pos=0; //posicao em que se encontra o min do array
     for(i=1;i< a.length;i++){
         if(a[i] < menor){
             menor=a[i];
             pos=i;
            }
        }
        System.out.println("minimo= " + menor + "na posicao" + pos); 
        return menor;
    }
 /**
  * 1b ler 1 array de inteiros e 2 indices e determinar o array c os valores entre
  * esses indices conseguiii
  */
 public int[] array(int i,int f,int [] a){
     int tamanho=f-i+1;
     int [] b = new int[tamanho];
       System.arraycopy(a,i,b,0,tamanho); //0 pois e o indice inicial de b
        return b;
    }
 /**
  * 1c ler 2 arrays de inteiros e determinar o array c os elementos comuns
  * conseguiii
  */  
 public int [] elemsComuns(int [] a,int [] b){
     int[] comum = new int[a.length];
     int i,j;
     int indb=0;
     for(i=0;i<a.length;i++){
         for(j=0;j<b.length;j++)
             if(a[i]==b[j]){
               comum[indb]=a[i];
               indb++;
                }
            }
            return comum;
        }  
 public static void viewArray(int[] array){
        int i, size=array.length;
        for(i=0;i<size;i++){
        System.out.println("Array["+i+"]:"+array[i]);
    }
    }
    
    }