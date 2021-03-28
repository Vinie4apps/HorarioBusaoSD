package com.vinie4apps.horriobusaosd.item;

public class Horarios_Model {


    private String sbairro;
    private String scentro;
    private String horaiobairro;
    private String horariocentro;

    public Horarios_Model(String sbairro, String horaiobairro, String scentro, String horariocentro) {

        this.sbairro = sbairro;
        this.horaiobairro = horaiobairro;
        this.scentro = scentro;
        this.horariocentro = horariocentro;
    }

    public String getSbairro() {
        return sbairro;
    }

    public void setSbairro(String sbairro) {
        this.sbairro = sbairro;
    }

    public String getScentro() {
        return scentro;
    }

    public void setScentro(String scentro) {
        this.scentro = scentro;
    }

    public String getHoraiobairro() {
        return horaiobairro;
    }

    public void setHoraiobairro(String horaiobairro) {
        this.horaiobairro = horaiobairro;
    }

    public String getHorariocentro() {
        return horariocentro;
    }

    public void setHorariocentro(String horariocentro) {
        this.horariocentro = horariocentro;
    }
}
