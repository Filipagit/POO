package com.company.testes.recurso18;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Ticket {
    private String nomeO ; // quem originou o pedido
    private LocalDateTime horaOcorrencia ; // instante do report do ticket
    private String assunto ;
    private String descrição ;
    private String identTecnico ; // t´ecnico que resolveu o ticket
    private LocalDateTime horaFecho ; // instante do fecho do ticket

            // m´etodo que efectua a resolu¸c~ao de um ticket .
//O algoritmo de resolu¸c~ao est´a codificado neste m´etodo .
    //public void executaTarefa () {

    public Ticket(String nomeO, LocalDateTime horaOcorrencia,String assunto, String descrição, String identTecnico,LocalDateTime horaFecho){
        this.nomeO=nomeO;
        this.horaOcorrencia=horaOcorrencia;
        this.assunto=assunto;
        this.descrição=descrição;
        this.identTecnico=identTecnico;
        this.horaFecho=horaFecho;
    }
    public Ticket(Ticket t){
        this.nomeO=t.getNomeO();
        this.horaOcorrencia=t.getHoraOcorrencia();
        this.assunto=t.getAssunto();
        this.descrição=t.getDescrição();
        this.identTecnico=t.getIdentTecnico();
        this.horaFecho=t.getHoraFecho();
    }
   public String getNomeO(){
      return  this.nomeO;
    }

    public void setNomeO(String nomeO) {
        this.nomeO = nomeO;
    }
    public LocalDateTime getHoraOcorrencia(){
        return this.horaOcorrencia;
    }

    public void setHoraOcorrencia(LocalDateTime horaOcorrencia) {
        this.horaOcorrencia = horaOcorrencia;
    }

    public String getAssunto(){
        return this.assunto;
    }
    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }
    public String getDescrição(){
        return  this.descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }
    public String getIdentTecnico(){
        return  this.identTecnico;
    }

    public void setIdentTecnico(String identTecnico) {
        this.identTecnico = identTecnico;
    }
    public LocalDateTime getHoraFecho(){
        return  this.horaFecho;
    }

    public void setHoraFecho(LocalDateTime horaFecho) {
        this.horaFecho = horaFecho;
    }
    public Ticket clone(){
        return  new Ticket(this);
    }

}
