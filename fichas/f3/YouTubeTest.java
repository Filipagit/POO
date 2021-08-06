package f3;
import java.time.LocalDate;
import java.lang.System;

/**
 * A classe de teste YouTubeTest.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class YouTubeTest
{
     public static void main(String[] args) {
      YouTube video1 = new YouTube();
        byte[] conteudo = new byte[5];
        conteudo[0] = 1;
        conteudo[1] = 1;
        conteudo[2] = 1;
        conteudo[3] = 0;
        conteudo[4] = 1;
        LocalDate data = LocalDate.of(2018,4,10);
        int[] tempo = {1,30};
        String[] comentarios = {"Video muito bom", "Gostei muito do video"};
        YouTube video2 = new YouTube("HELLO WORLD",conteudo, data, "1080X860HD", tempo, comentarios, 150, 10,4);
        
        System.out.println(video2.toString());
        //ex_3_b:
        //video2.insereComentario("NÃO GOSTEI DO VÍDEO");
        //System.out.println(video2.toString());
        //3c
        //System.out.println("dias:"+Math.abs(video2.qtsDiasDepois()));
        //d
        //System.out.println("Antes do LIKE !");
        //System.out.println(video2.toString());
        //video2.thumbsUp();
        //System.out.println("DEPOIS DO LIKES!");
        //System.out.println(video2.toString());
        //e 
        System.out.println(video2.processa());
       
    }
}
