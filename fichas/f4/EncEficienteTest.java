package f4;

import java.time.LocalDate;
import java.util.ArrayList;




/**
 * A classe de teste EncEficienteTest.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class EncEficienteTest
{
  public static void main(String [] arg){
     EncEficiente enc= new EncEficiente("Filipa",240320210,"Rua da Boavista",52,LocalDate.now(),new ArrayList<LinhaEncomenda>());  
     System.out.println("nova encomenda: " + enc.toString());
     LinhaEncomenda le1=new LinhaEncomenda("15328","manteiga",1.5,1000,0.23,0.50);
     enc.adicionaLinha(le1);
     System.out.println("linha de encomenda: " + le1.toString());
     LinhaEncomenda le2=new LinhaEncomenda("36940","sal",0.70,5000,0.23,0.10);
     enc.adicionaLinha(le2);
     System.out.println("linha de encomenda: " + le2.toString());
     
     double valorTot=enc.calculaValorTotal();
     System.out.printf("o valor total da encomenda = %f\n", valorTot);
     
     double valorDesc=enc.calculaValorDesconto();
     System.out.printf("o valor total dos descontos = %f\n", valorDesc);
     
     int numeroTotProd=enc.numeroTotalProdutos();
     System.out.printf("o numero total de produtos = %d\n", numeroTotProd);
     
     System.out.printf("O produto '12745' vai ser encomendado ? %s\n", enc.existeProdutoEncomenda("12745") ? "Sim" : "Não");
     System.out.printf("O produto '15328' vai ser encomendado (? %s\n", enc.existeProdutoEncomenda("15328") ? "Sim" : "Não");

        enc.removeProduto("15328");
        System.out.println("Produto '15328' removido.");

        System.out.printf("O produto '15328' vai ser encomendado? %s\n", enc.existeProdutoEncomenda("15328") ? "Sim" : "Não");
    }
}

