package com.company.testes.teste17;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MusicaComVideo extends Faixa{
    private String video;
    public MusicaComVideo(String nome, String autor, int classificaçao, ArrayList<String> letra, int numeroVezesTocada, LocalDateTime ultimaVez,String video){
        super(nome,autor,classificaçao,letra,numeroVezesTocada,ultimaVez);
        this.video=video;
    }

    public  void play(){
        super.play();
        System.out.println(video);
    }
}
