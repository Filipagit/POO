package testes.t2021;

import java.time.LocalDateTime;

public class SmartBulbDimmable extends SmartBulb {
    private double intensidade;

    public SmartBulbDimmable(String id,int tone, double consumoPorHora, double intensidade ){
        super(id,tone,consumoPorHora);
        this.intensidade=0.5*intensidade;
    }
    public double totalConsumo(){
        return intensidade*super.getConsumoPorHora()*(LocalDateTime.now().getHour()-super.getInicio().getHour());
    }

    public double getIntensidade() {
        return intensidade;
    }

    public void setIntensidade(double intensidade) {
        this.intensidade = intensidade;
    }
}
