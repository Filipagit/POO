package f2;
import java.util.Scanner;
import java.util.Arrays;
/**
 * A classe de teste ex1Test.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class ex1Test
{
   public static void main(String [] args){
       int[] a={1,2,3,4};
       int[] b={5,4,2,7};
       ex1 p1= new ex1();
       /* int min=p1.menorint(a);
       System.out.printf("\nO valor minimo do array é:%d\n", min);
       int[] arr=p1.array(2,5,a);
       ex1.viewArray(arr);
       */
       int [] com=p1.elemsComuns(a,b);
       ex1.viewArray(com);
    }
}

