package ej1_tp4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ExistaCamino<T> {
	private GrafoDirigido<T> grafo;
	private HashMap<Integer, Boolean> visitados;
//	private List<Integer> listaFinal;
	
	public ExistaCamino(GrafoDirigido<T> grafo) {
		this.grafo = grafo;
		this.visitados = new HashMap<Integer, Boolean>();
//		this.listaFinal = new ArrayList<Integer>();
	}
	
	public List<Integer> camAV(Integer v){
		List<Integer> listaFinal = new ArrayList<Integer>();
		Iterator<Integer> vertices = this.grafo.obtenerVertices();
		while(vertices.hasNext()) {
			Integer indice = vertices.next();
			if(caminoAvertV(indice, v)) {
				listaFinal.add(indice);
			}
		}
		return listaFinal;
	}
	
	private Boolean caminoAvertV(Integer i, Integer v){
		this.visitados.put(i, true);
		Boolean fin = false;
		Iterator<Integer> ady = grafo.obtenerAdyacentes(i);
		while(ady.hasNext()) {
			Integer indice = ady.next();
			
			if(indice.equals(v)) {
				fin = true;
			} else {
//				return caminoAvertV(indice, v);
				if(!visitados.containsKey(indice))
					fin = caminoAvertV(indice, v);
			}
		}
		this.visitados.remove(i);
		return fin;
	}

}
