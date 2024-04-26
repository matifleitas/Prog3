package ej1_tp4;

import java.util.ArrayList;

import estructura.Arista;

public class Vertice<T> {
	private ArrayList<Arista> aristas;

	public Vertice() {
		this.aristas = new ArrayList<>();
	}
	
	public void addArista(Arista a) {
		this.aristas.add(a);
	}
}
