package ej1_tp4;

public class InfoCamino {
    private Integer tiempo;
    private Integer tiempoFinal;
    private String color;

    public InfoCamino(Integer tiempo, Integer tiempoFinal, String color) {
        this.tiempo = tiempo;
        this.color = color;
        this.tiempoFinal = tiempoFinal;
    }

    public Integer getTiempoFinal() {
        return tiempoFinal;
    }

    public void setTiempoFinal(Integer tiempoFinal) {
        this.tiempoFinal = tiempoFinal;
    }

    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getTiempo() {
        return tiempo;
    }

    public String getColor() {
        return color;
    }
}
