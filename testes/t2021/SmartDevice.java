package testes.t2021;

import java.time.LocalDateTime;

public class SmartDevice {
    private String id;
    private boolean on;
    private double consumoPorHora;
    private LocalDateTime inicio;


    public SmartDevice( String id, boolean on, double consumoPorHora, LocalDateTime inicio) {
        this.id = id;
        this.on = false;
        this.consumoPorHora = consumoPorHora;
        this.inicio=inicio;
    }
    public SmartDevice(SmartDevice s) {
        this.id = s.getId();
        this.on = s.isOn();
        this.consumoPorHora = s.getConsumoPorHora();
        this.inicio = s.getInicio();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public boolean isOn(){
        return on;
    }
    public double getConsumoPorHora() {
        return consumoPorHora;
    }
    public LocalDateTime getInicio() {
        return inicio;
    }

    // devolve o consumo desde o inicio
    public double totalConsumo() {return 0;}

    //liga o device. Se for a primeira vez inicializa o tempo de inicio
    public void turnOn() {
        this.on = true;
        if (this.inicio == null)
            this.inicio = LocalDateTime.now();
    }
    public SmartDevice clone(){
        return  new SmartDevice(this);
    }

}
