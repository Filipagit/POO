package f1;

import java.time.LocalDateTime;
import java.time.Clock;


/**
 * Escreva a descrição da classe ficha1 aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class ficha1{
     /**
     * Metodos para converter Celsius em Farheinheit 
     * 
     * @param graus Temperatura em graus Celsius
     * @return Temperatura em graus  Farheinheit 
     * conseguiii
     */  
   public double celsiusParaFarenheit(double graus){
        return graus*1.8+32;
    }
    /**
     * ler 2 inteiros e determinar o maximo dos dois e escrever no ecra
     * conseguiiii
     */
   public int maximoNumeros(int a, int b){
       int maximo=0;
       if(a>=b) maximo=a;
       else maximo=b;
       System.out.println("o maximo corresponde a "+maximo);
       return maximo;
    }

   /**
    * ler um nome(String) e um saldo(decimal) e imprimir um texto com os valores 
    * obtidos na leitura
    * conseguiii
    */ 
   public String criaDescricaoConta(String nome, double saldo){
      return ("Nome: "+ nome + "," +"Saldo: "+ saldo);
    }
   
   /**
    * converte euros em libras conseguuii
    */
   public double eurosParaLibras(double valor, double taxaConversao){
       double converter=valor*taxaConversao;
       System.out.println("o valor em libras corresponde a "+converter);
       return converter;
    }
   
   /**
    * ler 2 inteiros e escrever por ordem decrescente assim como a media
    * conseguiiii
    */ 
   public void decresceMedia(int a,int b){ 
       double media=(a+b)/2;
       if(a>b){
           System.out.println(a+" "+ b +"media="+media);
        }else {
          System.out.println(b+" "+ a +"media="+media);
        }
    }
        
   /**
    * calcula o fatorial de um numero inteiro conseguiii
    */
   public long factorial(int num){
       long fat=num;
       num--;
       while(num!=0){
           fat*=num;
           num--;
        }
        return fat;
    }
   
 /**
    * determinar a data e hora do sistema 
    * calcular o fatorial de 50000 done 
    * determinar hora apos tal ciclo
    * calcular o total de milissegundos que o ciclo demorou a executar
    */ 
public long tempoGasto(){
       long inicio = System.currentTimeMillis();
       long fact=factorial(5000);
       long fim = System.currentTimeMillis();
       return fim-inicio;
    }
}