package f2;


import java.lang.System;
import java.util.Scanner;

/**
 * A classe de teste ex6Test.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class ex6Test
{
  public void main(String[] args){
    int[][] mat1={{1,2},{3,4}};
    int[][] mat2={{5,6},{7,8}};
    ex6 mat= new ex6();
    int[][] sum=mat.somaMat(mat1,mat2);
    ex6.viewArray2D(sum);
    int[][] sim= mat.reverseMat(mat1);
    ex6.viewArray2D(sim);
    }

}
