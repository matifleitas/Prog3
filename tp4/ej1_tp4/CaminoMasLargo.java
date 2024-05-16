package ej1_tp4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class CaminoMasLargo<T> {
	private GrafoDirigido<T> grafo;
    private HashMap<Integer, Boolean> visitados;
	private List<Integer> caminoActual;
	private List<Integer> caminoMasLargo;
	
	public CaminoMasLargo(GrafoDirigido<T> grafo) {
		this.grafo = grafo;
		this.visitados = new HashMap<>();
		this.caminoActual = new ArrayList<>();
		this.caminoMasLargo = new ArrayList<>();
	}
	
	public List<Integer> encontrarCaminoMasLargo(int i, int j){
		dfsCaminoMasLargo(i, j);
		return caminoMasLargo;
	}
	
	private void dfsCaminoMasLargo(int indice, int j) {
		visitados.put(indice, true);
		caminoActual.add(indice);		
		
		if(indice==j) {
			if(this.caminoActual.size() > this.caminoMasLargo.size()) {
                caminoMasLargo.clear();
                caminoMasLargo.addAll(caminoActual);
			}
		}else {
			Iterator<Integer> ady = grafo.obtenerAdyacentes(indice);
			while(ady.hasNext()) {
				Integer vertAdy = ady.next();
				if (!visitados.containsKey(vertAdy)) {
                    dfsCaminoMasLargo(vertAdy, j);
                }
			} 
		}
		caminoActual.remove(caminoActual.size() - 1);//bactraking eliminando el caminoActual
        visitados.remove(indice); //eliminando la memoria de visitados de ese camino
	}
}
