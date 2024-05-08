package ej3_tp4;

import java.util.HashMap;
import java.util.Iterator;

public class BusquedaDeCiclo {
	private HashMap<Integer, InfoCamino> recorrido;

	public BusquedaDeCiclo(HashMap<Integer, InfoCamino> recorrido) {
		this.recorrido = recorrido;
	}
	
	public boolean hayCiclo(Grafo g) {
		Iterator<Integer> vertices = g.obtenerVertices();
		inicializar(vertices);
		while(vertices.hasNext()) {
			Integer aux = vertices.next();
			if(!recorrido.get(aux).getVisitado()) {
				return hayCiclo(g, aux);
			}
		}
		return false;
	}
	
	private boolean hayCiclo(Grafo g, Integer vertice) {
		InfoCamino info = recorrido.get(vertice);
		info.setVisitado(true);
		Iterator<Integer> adyacentes = g.obtenerAdyacentes(vertice);
		while(adyacentes.hasNext()) {
			Integer vertAdy = adyacentes.next();
			if(!this.recorrido.get(vertAdy).getVisitado()) {
				if(this.hayCiclo(g, vertAdy)) { // Si se encuentra un ciclo en la llamada recursiva, devolver true
					return true;
				}
			} else {
				System.out.println("CICLO!");// Si el vértice adyacente ya ha sido visitado, hay un ciclo
				return true;
			}
		} return false;
	}
	
	public void inicializar(Iterator<Integer> itVertices) {
		while(itVertices.hasNext()) {
			Integer indiceVertice = itVertices.next();
			InfoCamino info = new InfoCamino(false);
			recorrido.put(indiceVertice, info);
		}
	}
}
