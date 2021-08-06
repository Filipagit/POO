package f3;


/**
 * A classe de teste circuloTest.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class circuloTest
{
   public static void main(String[] args){
       circulo c1,c2,c3;
       c1=new circulo();
       c2= new circulo(10,5,20);
       c3=new circulo(c2);
        System.out.println("c2==c3? "+c2.equals(c3));
        System.out.println("Area de c1: " +c1.calculaArea());
        System.out.println("X do c3: "+c3.getX());
        c3.alteraCentro(2,5);
        //System.out.println("X do c3: "+c3.getX());
        //System.out.println("X do c2: "+c2.getX());
        System.out.println("c3: "+c3.toString());
        System.out.println("c2: "+c2.toString());
        
        System.out.println("c2==c3? "+c2.equals(c3));
    }
}

