package com.company.testes.recurso18;

public class Tecnico {
    private String ident ; // identificador do t´ecnico
    private String nome ; // nome do t´ecnico
    private int numTickets ; // n´umero de tickets resolvidos

    public int getNumTickets() {
        return numTickets;
    }

    public void setNumTickets(int numTickets) {
        this.numTickets = numTickets;
    }

    public String getIdent() {
        return ident;
    }

    public String getNome() {
        return nome;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
