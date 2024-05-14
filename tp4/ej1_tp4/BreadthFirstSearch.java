package ej1_tp4;

import java.util.Iterator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch { //en emplitud
	private Queue<Integer> cola;
	private HashMap<Integer, Boolean> visitado;//hash el cual guarda <vertice, visitado si O no>
	
	public BreadthFirstSearch() {
        this.cola = new LinkedList<>();
        this.visitado = new HashMap<Integer, Boolean>();
    }
	
	public void bfs(Grafo g) {
		inicializar(g);//poner todos en false y agregarlos a mi hashMap de visitados
		Iterator<Integer> vertices = g.obtenerVertices();
		while(vertices.hasNext()) { //empezar a recorrer con el hashMap cargado
			Integer vertice = vertices.next();
			if(!visitado.get(vertice)) { //entra si el valor de visitado sea false
				bfs(g, vertice);
			}
		}
	}
	
	private void bfs(Grafo g, Integer vertice) {
		visitado.put(vertice, true); //lo marco como visitado = true
		cola.add(vertice);
		while(!cola.isEmpty()) {
			Integer vert = cola.poll();
			Iterator<Integer> ady = g.obtenerAdyacentes(vert);
			while(ady.hasNext()) {
				Integer verticeAdj = ady.next();
				if(!visitado.get(verticeAdj)) {
					visitado.put(verticeAdj,true);
					cola.add(verticeAdj);
				}
			}
		}
	}

	public void inicializar(Grafo g) {
		Iterator<Integer> listVertices = g.obtenerVertices();
		while(listVertices.hasNext()) {
			Integer vertice = listVertices.next();
			visitado.put(vertice, false);
		}
	}
}
