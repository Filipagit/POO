package com.company.testes.recurso18;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class SmartHome implements Serializable {
    Map<String, Eletrodomestico> eletrodomesticos;

    public SmartHome(Map<String, Eletrodomestico> novosEletrodomesticos) {
        this.setEletrodomesticos(novosEletrodomesticos);
    }

    public void setEletrodomesticos(Map<String, Eletrodomestico> eletrodomesticos) {
        if (this.eletrodomesticos == null) this.eletrodomesticos = new HashMap<>();
        for (String s : eletrodomesticos.keySet())
            this.eletrodomesticos.put(s, eletrodomesticos.get(s));
    }

    // conseguiii
    public void addEletrodomestico(Eletrodomestico e) {
        if (this.eletrodomesticos == null) this.eletrodomesticos = new HashMap<>();
        this.eletrodomesticos.put(e.getIdent(), e);
    }

    // conseguiii
    public void desligaEletrodomestico(String id) throws EletrodomesticoNaoExisteException {
        if (!this.eletrodomesticos.containsKey(id)) throw new EletrodomesticoNaoExisteException();
        else {
            this.eletrodomesticos.get(id).EletrodomesticoOFF();
        }
    }

    //dos inteligentes e ecologicos
    public double consumoParcial() {
        double consumo = 0.0;
        for (Eletrodomestico e : this.eletrodomesticos.values())
            if (e instanceof EletrodomesticoEcologico || e instanceof EletrodomesticoInteligente) {
                consumo += e.getConsumoParcial();
            }
        return consumo;
    }
}

