package f2;

import java.time.LocalDate;
/**
 * A classe de teste ex3Test.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class ex3Test
{
public static void main(String[] args){
  ex3 data = new ex3();
  data.insereData(LocalDate.of(2020,2,29));
  System.out.println("Inserida data 2020-02-29");
  data.insereData(LocalDate.of(2000, 8, 31));
  System.out.println("Inserida data 2000-08-31");
  data.insereData(LocalDate.of(2012,12,21));
  System.out.println("Inserida data 2012-12-21");
  data.insereData(LocalDate.of(2001,9,11));
  System.out.println("Inserida data 2001-09-11");
  LocalDate datamaisp= data.dataMaisProxima(LocalDate.of(2020,3,10));
  System.out.println("A data mais proxima da 2020-03-10 é " + datamaisp.toString()); 
}
}
