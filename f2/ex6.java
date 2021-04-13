package f2;

import java.lang.System;
import java.util.Scanner;
/**
 * Escreva a descrição da classe ex6 aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class ex6
{
 private int[][] matriz;  
 
 public ex6(){
     this.matriz= new int[2][2];
}
public ex6(int linhas,int colunas){
    this.matriz=new int[linhas][colunas];
}
public ex6(ex6 mat){
    int i;
    this.matriz=new int[mat.matriz.length][];
    for(i=0;i<this.matriz.length;i++){
        this.matriz[i]= new int[mat.matriz[i].length];
        System.arraycopy(mat.matriz[i],0,this.matriz[i],0,mat.matriz[i].length);
}
}
public int getLinhas(){
    return this.matriz.length;
}
public int getColunas(int i){
    return this.matriz[i].length;
}
public static void viewArray2D(int[][] array){
        
        int l,c, size=array.length;
        for(l=0;l<size;l++){
            for(c=0;c<array[l].length;c++){
            System.out.println("Array["+l+"]["+l+"]:"+array[l][c]);
        }
        }
    }
/*
 * a)ler uma matriz
 */
public void lemat(){
int i,j;
for(i=0;i<this.matriz.length;i++)
    for(j=0;j<this.matriz[i].length;j++)
    System.out.println(this.matriz[i][j]);
}
public void setMat(int elem,int linha,int coluna){
    this.matriz[linha][coluna]=elem;
}
public int getMat(int elem,int linha,int coluna){
    return this.matriz[linha][coluna];
}
public ex6 clone(){
    ex6 novo= new ex6(this);
    return novo;
}
/*
 * b) somar matrizes e devolver a matriz resultado
 */
public int[][] somaMat(int[][] matriz1,int[][] matriz2){
    int linhas=matriz1.length;
    int [][] soma= new int[linhas][];
    int linha,coluna;
    for(linha=0;linha<linhas;linha++){
        int colunas=matriz1[linha].length;
        soma[linha]= new int[colunas];
        for(coluna=0;coluna<colunas;coluna++){
            soma[linha][coluna]=matriz1[linha][coluna]+matriz2[linha][coluna];
        }
    }
    return soma;
}
/**
 * c) metodo para determinar se duas matrizes sao iguais ou nao
 */
public boolean equals(Object o){
    int i,j;
     if(this == o)return true;
     if(o == null || o.getClass() != this.getClass())return false;
     ex6 mat=(ex6) o;
     for(i=0;i<mat.matriz.length;i++)
         for(j=0;j<this.matriz[i].length;j++)
          if(mat.matriz[i][j]!=this.matriz[i][j]) return false;
          return true;
}
/**
 * d) determina a matriz simetrica 
 */
public int[][] reverseMat(int [][] matriz){
    int[][] inv= new int[matriz.length][matriz.length];
    int i;
    for(i=0;i<this.matriz.length;i++){
        for(int j=0;j<this.matriz[i].length;j++){
            if(matriz[i][j]==0) inv[i][j]= matriz[i][j];
            else{
            inv[i][j]= -matriz[i][j];
        }
    }
    } 
    return inv;
}
}


