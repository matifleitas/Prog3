package estructura;

import java.util.ArrayList;

public class Vertice<T> {
	private ArrayList<Arista> aristas;

	public Vertice() {
		this.aristas = new ArrayList<>();
	}
	
	public void addArista(Arista a) {
		this.aristas.add(a);
	}
}
