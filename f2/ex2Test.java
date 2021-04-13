package f2;

import java.util.Scanner;


/**
 * A classe de teste ex2Test.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class ex2Test
{ 
    public static void main(String[] args){
        int[][] pauta={{15,14,13,17,18},
                      {13,12,15,18,20},
                      {11,12,14,19,14},
                      {10,12,15,18,20},
                      {20,20,15,10,20}};
        ex2 p2= new ex2(pauta);
        //System.out.println(p2.sumnotas(2)); alinea b
        //System.out.println(p2.medianotas(2)); alinea c
        //System.out.println(p2.mediaUc(2)); alinea d
        //System.out.println(p2.notaAltaUc(2)); alinea e
        //System.out.println(p2.notaBaixaUc(2)); alinea f
        //int [] arr=p2.notasSuperiores(13); alinea g 
        //ex2.viewArray(arr);
        //System.out.println(p2.maisaltaUc()); alinea i
    }
    
}

