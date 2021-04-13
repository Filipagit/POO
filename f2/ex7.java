package f2;
import java.lang.Math;
import java.util.Arrays;

/**
 * Escreva a descrição da classe ex7 aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class ex7
{
   private int[][] euromilhoes;
   
public ex7(){
       this.euromilhoes= new int[2][];
       euromilhoes[0]= new int[2]; // estrelas
       euromilhoes[1]= new int [5]; //numeros 
}
public int[][] geraNumeros(){
    int liminf=1;
    int limsup=9;
    int intervalo=limsup-liminf+1;
    int ind=0;
    for(int i=0;i<2;i++){
        if(i==0){ //gerar as estrelas 
            for(int j=0;j<2;j++){
                int gera=(int)(Math.random()*intervalo) + liminf; 
                //+ liminf pq sem isso calcula desde 0 a limsup
                  if(j==1){ // se ja tem uma estrela 
                      if(euromilhoes[i][0]!=gera) euromilhoes[i][ind++]=gera;
                      //verificar se essa estrela ja foi adicionada
                      else j=0;
                    }
                    else euromilhoes[i][ind++]=gera;
                }
            }
            else{ //gerar os numeros
    int linf=1;
    int lsup=50;
    int inter=lsup-linf+1;
    int indice=0;
            for(int j=0;j<5;j++){
                int gera=(int)(Math.random()*intervalo)+ linf;
                int found=0;
                for(int z=0;z<j;z++){
                    if(euromilhoes[i][z]== gera) found=1; //ver se ja foi adicionado
                }
                if(found==0) euromilhoes[i][indice++]= gera;//nao foi adicionado
                else j--;
    }
}
}
Arrays.sort(euromilhoes[0]);//ordenar por ordem crescente os numeros
Arrays.sort(euromilhoes[1]);
return euromilhoes;
}
/**
 * comparar as chaves 
 */
public int[][] compare(int[][] key){
    int[][] res= new int[2][5];
    int indi=0,indje=0,indjnum=0;
    for(int i=0;i<2;i++){//compara as estrelas
        if(i==0){
            for(int j=0;j<2;j++){
                int est=euromilhoes[i][j];
                int igual=0;
                for(int k=0;k<2;k++){
                    if(key[i][k]== est) igual=1;
                }
                if(igual==1) res[indi][indje++]= euromilhoes[i][j];
            }
        }
        else{//compara os numeros
            for(int j=0;j<5;j++){
                int num=euromilhoes[i][j];
                int ig=0;
                for(int k=0;k<5;k++){
                    if(key[i][k]==num) ig=1;
                }
                if(ig==1) res[indi][indjnum++]= euromilhoes[i][j];
            }
        }
        indi++;
    }
    int[][] novo= new int[indi][];
    for(int i=0;i<indi;i++){
        if(i==0){
            novo[i]= new int[indje];
            System.arraycopy(res[i],0,novo[i],0,indje);
        }
        else{
            novo[i]=new int[indjnum];
            System.arraycopy(res[i],0,novo[i],0,indjnum);
        }
    }
    return novo;
}

public boolean chavesiguais(int[][] key){
    return Arrays.deepEquals(euromilhoes,key);// verifica se as chaves sao iguais 
                
}
}

