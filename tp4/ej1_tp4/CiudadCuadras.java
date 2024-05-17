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
	
	public void Bfs(Integer or, Integer d) {
		inicializar(g);
		if(!visitado.get(or)) 
			System.out.println(bfs(or, d));
	}
	
	private int bfs(Integer i, Integer d) {
		int cuadras = 0;
		visitado.put(i, true); 
		cola.add(i);
		while(!cola.isEmpty()) {
			Integer vert = cola.poll();
			if(vert.equals(d)) {
				return cuadras;
			}
			Iterator<Integer> ady = g.obtenerAdyacentes(vert);
			Boolean cuadraTomada = false;
			while(ady.hasNext()) {
				if(!cuadraTomada) {
					cuadras++;
				}
				Integer verticeAdj = ady.next();
				if(!visitado.get(verticeAdj)) {
					cuadraTomada = true;
					visitado.put(verticeAdj,true);
					cola.add(verticeAdj);
				}
			}
		} return cuadras;
	}

	public void inicializar(Grafo g) {
		Iterator<Integer> listVertices = g.obtenerVertices();
		while(listVertices.hasNext()) {
			Integer vertice = listVertices.next();
			visitado.put(vertice, false);
		}
	}
}
