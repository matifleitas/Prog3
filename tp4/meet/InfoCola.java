package meet;

public class InfoCola {
    private Integer value;
    private Boolean visitado;

    public InfoCola(Integer value) {
        this.value = value;
        this.visitado = false;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Boolean getVisitado() {
        return visitado;
    }

    public void setVisitado(Boolean visitado) {
        this.visitado = visitado;
    }
}