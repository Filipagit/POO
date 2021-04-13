package f3;
import java.util.Scanner;

/**
 * A classe de teste LinhaEncomendaTest.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class LinhaEncomendaTest
{
    public  static void  main(String[] args){
      LinhaEncomenda linhaBlank = new LinhaEncomenda();
                System.out.println("Linha de encomenda predefinida, valores devem ser todos nulos.");
                System.out.println(linhaBlank.toString() + '\n');

                LinhaEncomenda linhaValores = new LinhaEncomenda("ABCD","Produto interessante!",29.90,4,23, 6);
                System.out.println("Linha de encomenda com valores iniciais (ref=\"ABCD\", desc=\"Produto interessante!\", precoSemTaxas=29.90, qtd=4, imposto=23%, descComercial=6%).");
                System.out.println(linhaValores.toString() + "\n");

                LinhaEncomenda linhaClone = new LinhaEncomenda(linhaValores);
                System.out.println("Linha de encomenda copiada da anterior, valores devem ser iguais.");
                System.out.println(linhaClone.toString() + "\n");

                linhaClone.setPrecoantes(25);
                System.out.println("Preço antes de impostos mudado para 25.");
                System.out.println(linhaClone.toString() + "\n");
                double valorLinhaEnc = linhaClone.calculaValorLinhaEnc();
                System.out.printf("O valor da venda já considerados os impostos e descontos é: %f\n",valorLinhaEnc);   
                double valorDesconto = linhaClone.calculaValorDesconto();
                System.out.printf("O valor do desconto é: %f\n",valorDesconto);
}
}
