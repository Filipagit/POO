package f2;

import java.util.Scanner;
import java.util.Arrays;




/**
 * A classe de teste ex4Test.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class ex4Test
{
   public static void main(String [] arg){
       int [] arr={10,2,3,1};
       ex4 p1= new ex4(arr);
       p1.ordenaArray();
       System.out.println(Arrays.toString(arr));
       int procura=p1.procuraBin(3);
       System.out.println(procura);
}
}