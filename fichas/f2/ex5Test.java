package f2;

import java.util.ArrayList;



/**
 * A classe de teste ex5Test.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class ex5Test
{
    public static void main(String [] args){
    ArrayList<String> l= new ArrayList<String>();
    l.add("Eu");
    l.add("desejei");
    l.add("passar");
    l.add("a");
    l.add("tudo");
    l.add("passar");
    l.add("tudo");
    ex5 p5= new ex5(l);
    //a
    System.out.println("Strings sem repetiçoes: " + p5.semrepetidos());
    //b
    System.out.println("maior String: " + p5.maiorString());
    //c
    System.out.println("Strings repetidas: " + p5.srepetidas());
    //d
    System.out.println("o numero de vezes de ocorrencias de 'passar': " + p5.numeroOcorr("passar"));
}
}
