package ej3_tp4;

public class InfoCamino {
	
    private boolean visitado;

    public InfoCamino(boolean visitado) {
        this.visitado = visitado;
    }
    public void setVisitado(Boolean visitado) {
        this.visitado = visitado;
    }
    public boolean getVisitado() {
        return visitado;
    }
}
