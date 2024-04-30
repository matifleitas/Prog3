package ej1_tp4;

import java.util.ArrayList;

public class Vertice<T> {
	private ArrayList<Arco> aristas;

	public Vertice() {
		this.aristas = new ArrayList<>();
	}
	
	public void addArista(Arco a) {
		this.aristas.add(a);
	}
	
	public boolean contiene(Arco a) {
		return aristas.contains(a);
	}
	
	public void borrarMisArcos() {
		this.aristas.clear();
	}
}
