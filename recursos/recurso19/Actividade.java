package recursos.recurso19;

import java.io.Serializable;
/**
 * Escreva a descrição da classe Exercicio aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public abstract class Actividade implements Serializable {
private String designacao ;
private double caloriasPorUnidadeTreino ; // calorias
// por unidade de treino
public abstract double caloriasGastas (); //o consumo de
// calorias depende de cada actividade espec´ıfica
}