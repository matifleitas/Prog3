package ej1_tp4;

public class Arco<T> {
	private int verticeOrigen;
	private int verticeDestino;
	private T etiqueta;
	
	public Arco(int verticeOrigen, int verticeDestino, T etiqueta) {
		this.verticeOrigen = verticeOrigen;
		this.verticeDestino = verticeDestino;
		this.etiqueta = etiqueta;
	}

	public int getVerticeOrigen() {
		return verticeOrigen;
	}

	public int getVerticeDestino() {
		return verticeDestino;
	}

	public T getEtiqueta() {
		return etiqueta;
	}	
	
	public Arco<T> getCopia(){
		return new Arco<T>(this.getVerticeOrigen(), this.verticeDestino, this.getEtiqueta());
	}
}
