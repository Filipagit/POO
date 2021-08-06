package f2;
import java.util.Scanner;
import java.util.Arrays;

/**
 * A classe de teste ex7Test.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class ex7Test
{
 public static void main(String[] args){
     ex7 p7= new ex7();
     p7.geraNumeros();
        int[][] ch = new int[2][];
        ch[0] = new int[2];
        ch[1] = new int[5];
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira duas estrelas (1-9):");
        for(int i=0; i<2; i++) { 
            ch[0][i] = sc.nextInt();
        }
        System.out.println("Insira 5 numeros (1-50):");
        for(int i=0; i<5; i++) { 
            ch[1][i] = sc.nextInt();
        }
        if (p7.chavesiguais(ch)) {
            int numEsp = 0;
            for(int i=0; i<50; i++) {
                for (int j=0; j<numEsp; j++){
                    System.out.print(" ");
                }
                numEsp+=2;
                System.out.println(Arrays.deepToString(ch));
            }
        }
        else System.out.println("Acertou nos seguintes numeros: " + Arrays.deepToString(p7.compare(ch)));
    }
}

