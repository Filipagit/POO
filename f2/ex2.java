package f2;


/**
 * Escreva a descrição da classe ex2 aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class ex2
{
    private int [][] notasTurma;
/**
 * a) ler as notas e atualizar o array da pauta 
 */
public  ex2(int [][] notasTurma){
   this.notasTurma = notasTurma; 
}
/**
 * b) calcular soma das notas conseguii
 */
public int sumnotas(int uc){
    int sum=0;
    int i;
    for(i=0;i<notasTurma.length;i++){
        sum+=notasTurma[i][uc];
    }
    return sum;
}
/**
 * c) calcular a media das notas de um aluno fornecendo o indice da posicao
 * conseguii
 */
public double medianotas(int aluno){
    double media=0;
    int i;
    for(i=0;i<notasTurma.length;i++){
       media+=notasTurma[aluno][i];
    }
    media/=notasTurma[aluno].length;
    return media;
}
/**
 * d) calcular a media das notas de uma uc dado o indice da uc
 */
public double mediaUc(int iuc){
    double media=0;
    int i;
    for(i=0;i<notasTurma.length;i++){
        media+=notasTurma[i][iuc];
    }
    media/=notasTurma.length;
    return media;
}
/**
 * e) calcula a nota mais alta a tds as Uc conseguiii
 */
public int notaAltaUc(int uc){
    int maisalta=0;
    int i;
    for(i=0;i<notasTurma.length;i++){
        if(notasTurma[i][uc]>maisalta){
            maisalta=notasTurma[i][uc];
        }
    }
    return maisalta;
}
/**
 * f) calcula a nota mais baixa .. conseguiii
 */
public int notaBaixaUc(int uc){
    int maisbaixa=notasTurma[0][uc];
    int i;
    for(i=0;i<notasTurma.length;i++){
        if(notasTurma[i][uc]<maisbaixa){
            maisbaixa=notasTurma[i][uc];
        }
    }
    return maisbaixa;
}
/**
 * g) devolver um array c as notas superiores a um determinado valor 
 */
public int[] notasSuperiores(int n){
    int [] arr= new int [25];
    int i,j;
    int r=0;
    for(i=0;i<notasTurma.length;i++){
        for(j=0;j<notasTurma.length;j++){
            if(notasTurma[i][j]>n){
                arr[r]=notasTurma[i][j];
                r++;
            }
        }
    }
    int [] copy=new int[r];
    System.arraycopy(arr,0,copy,0,r);
    return copy;
}
public static void viewArray(int[] array){
        int i, size=array.length;
        for(i=0;i<size;i++){
        System.out.println("Array["+i+"]:"+array[i]);
    }
    }
/**
 * i) determinar o indice da uc c a media mais alta
 *
 */    
public int maisaltaUc(){
    int uc,i;
    int media=0;
    int alta=0;
    int maisalta=0;
    for(uc=0;uc<notasTurma.length;uc++){
        for(i=0;i<notasTurma.length;i++){
            media+=notasTurma[i][uc];
        }
        media=media/3;
        if(alta<media){
            alta=media;
            maisalta=uc;
        }
    }
    return maisalta;
}
}
