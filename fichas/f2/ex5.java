package f2;
import java.util.ArrayList;

/**
 * Escreva a descrição da classe ex5 aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class ex5
{
 private ArrayList<String> arr= new ArrayList();
  public ex5(ArrayList<String> arr){
      this.arr=arr;
    }
 /*
  * a)determinar o array sem repetiçoes
  */   
 public ArrayList<String> semrepetidos(){
   ArrayList<String> v = new ArrayList<>();
   for(String elemento : arr){
       if((v.contains(elemento))==false){
           v.add(elemento);
        }
}
return v;
}
/**
 * b) determinar a maior string inserida
 */
public String maiorString(){
    String maiorS= new String("");
    int tam=0;
    for(String elem : arr){
        if(elem.length()>tam){
            maiorS=elem;
            tam=elem.length();
        }
    }
    return maiorS;
}
/**
 * c) determinar um array com as strings repetidas
 */
public ArrayList<String> srepetidas(){
    ArrayList<String> v= new ArrayList<>();
    for(String elem : arr){
        if(arr.lastIndexOf(elem)!=arr.indexOf(elem) && v.contains(elem)==false) v.add(elem);
    }
    return v;
}
/**
 * d) determinar quantas vezes uma determinada String ocorre no array
 */
public int numeroOcorr (String string){
    int num=0;
    for(String elem : arr){
        if(elem.equals(string)==true) num++;
    }
    return num;
}
}

