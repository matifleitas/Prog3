package ej1_tp4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class CiudadCuadras<T> {
	private Queue<Integer> cola;
	private HashMap<Integer, Boolean> visitado;
	private GrafoDirigido<T> g;
	
	public CiudadCuadras(GrafoDirigido<T> g) {
        this.cola = new LinkedList<>();
        this.visitado = new HashMap<Integer, Boolean>();
        this.g = g;
    }
	
	public int bfs(Integer i, Integer d) {
		inicializar(g);
		visitado.put(i, true); 
		cola.add(i);
		int cuadras = 0;

		while(!cola.isEmpty()) {
			Integer size = cola.size();
			for (int indice = 0; indice < size; indice++) {//cicla por mismo nivel de adyacentes agregada
				Integer vert = cola.poll();
				if(vert.equals(d)) {
					return cuadras;
				}
				Iterator<Integer> ady = g.obtenerAdyacentes(vert);
				while(ady.hasNext()) {
				Integer verticeAdj = ady.next();
					if(!visitado.get(verticeAdj)) {
						visitado.put(verticeAdj,true);
						cola.add(verticeAdj);
					}
				}
			} cuadras++;
		} 
		return -1;
	}
	
	public void inicializar(Grafo g) {
		Iterator<Integer> listVertices = g.obtenerVertices();
		while(listVertices.hasNext()) {
			Integer vertice = listVertices.next();
			visitado.put(vertice, false);
		}
	}
}
