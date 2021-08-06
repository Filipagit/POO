package com.company.testes.recurso18;

import java.io.Serializable;
import java.time.LocalDateTime;

public class EletrodomesticoInteligente extends Eletrodomestico implements Serializable {

    public EletrodomesticoInteligente(String ident, double consumo) {
        super(ident, consumo);
    }

    public void turnOn(LocalDateTime d){
        if(LocalDateTime.now().isEqual(d)) this.EletrodomesticoON();
    }

    public void turnOff(LocalDateTime d){
        if(LocalDateTime.now().isEqual(d)) this.EletrodomesticoOFF();
    }

}

