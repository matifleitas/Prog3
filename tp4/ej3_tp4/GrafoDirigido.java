package ej3_tp4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T>{

	private HashMap<Integer, ArrayList<Arco<T>>> vertices;
	private int countVerices;

	public GrafoDirigido() {
		this.vertices = new HashMap<>();
		this.countVerices = 0;
	}

	@Override
	public void agregarVertice(int verticeId) {
		if(!vertices.containsKey(verticeId)) {
			this.vertices.put(verticeId, new ArrayList<Arco<T>>());
			this.countVerices++;
			//agrego int verticeId, es decir un vertice y un new array pq es nuevo el vert
		}
	}

	@Override
	public void borrarVertice(int verticeId) {
		if(vertices.containsKey(verticeId)) {
			this.vertices.get(verticeId).clear();
			this.vertices.remove(verticeId);
			this.countVerices--;
		}
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		if (vertices.containsKey(verticeId1) && vertices.containsKey(verticeId2)) {
	       ArrayList<Arco<T>> Array = vertices.get(verticeId1);//agarro los arcos del vert origen
	       Arco<T> auxArco = new Arco(verticeId1, verticeId2, etiqueta);
	       Array.add(auxArco); //add a mi array de arcos de mi vert origen
	    }
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		if(vertices.containsKey(verticeId1) && vertices.containsKey(verticeId2)) {
			Iterator<Arco<T>> it = this.obtenerArcos(verticeId1);
			while(it.hasNext()) {
				it.remove();
			}
		}
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		return vertices.containsKey(verticeId);
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		return vertices.containsKey(verticeId1) && vertices.containsKey(verticeId2);
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		ArrayList<Arco<T>> arrayAux = vertices.get(verticeId1);
		for(int i=0;i<arrayAux.size();i++) {
			if(arrayAux.get(i).getVerticeOrigen() == verticeId1 && arrayAux.get(i).getVerticeDestino() == verticeId2) {
				Arco arco = new Arco<T>(verticeId1, verticeId2, arrayAux.get(i).getEtiqueta());
				return arco;
				//preguntar si puedo, return arrayAux.get(i)
			}
		}	return null;	
	}

	@Override
	public int cantidadVertices() {
		return this.countVerices;
	}

	@Override
	public int cantidadArcos() {
		int count=0;
		for(Integer key : vertices.keySet()) {
			ArrayList<Arco<T>> arrayArcos = vertices.get(key);
			count += arrayArcos.size();
		}
		return count;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		return vertices.keySet().iterator();
	}

	@Override //preguntar si es mas optimo asi o el de arriba
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
	    ArrayList<Integer> adyacentes = new ArrayList<>();
		if(this.vertices.containsKey(verticeId)) {
			ArrayList<Arco<T>> arcos = this.vertices.get(verticeId);
			for(Arco<T> arco : arcos) {
				adyacentes.add(arco.getVerticeDestino());
			}
		} return adyacentes.iterator();
	}
	
	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		ArrayList<Arco<T>> arcosTotales = new ArrayList<>();
		for (ArrayList<Arco<T>> ArrayArcos : this.vertices.values()) {
			for (Arco<T> arco : ArrayArcos) {
				arcosTotales.add(arco.getCopia());
			}
		}	return arcosTotales.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		ArrayList<Arco<T>> arcos = new ArrayList<>();
		if(this.vertices.containsKey(verticeId)) {
			 arcos = this.vertices.get(verticeId);
		} return arcos.iterator();
	}
	
	public void mostrarArcos(int verticeId) {
	    Iterator<Arco<T>> iterador = obtenerArcos(verticeId);
	    
	    System.out.println("Arcos para el vértice " + verticeId + ":");
	    
	    while (iterador.hasNext()) {
	        Arco<T> arco = iterador.next();
	        System.out.println(arco); // Suponiendo que Arco<T> tiene una implementación adecuada de toString()
	    }
	}
	
	public void mostrarAdyacentes(int verticeId) {
	    Iterator<Integer> iterador = this.obtenerAdyacentes(verticeId);
	    
	    System.out.println("Adyacentes de " + verticeId + ":");
	    
	    while (iterador.hasNext()) {
	        System.out.println(iterador.next()); // Suponiendo que Arco<T> tiene una implementación adecuada de toString()
	    }
	}
}
