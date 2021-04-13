package f1;

import java.util.Scanner;


/**
 * A classe de teste ficha1Test.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class ficha1Test{
 public static  void main (String[] args){
   ficha1 f1= new ficha1();
   Scanner ins= new Scanner(System.in);
   System.out.print("Temperatura em Celsius: ");
   double tempC= ins.nextDouble();
   double tempF= f1.celsiusParaFarenheit(tempC);
   System.out.println("Em Farenheit e: "+tempF);
   ins.close();
}
   
}
