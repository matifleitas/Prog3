package ej1_tp4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T>{
//	private ArrayList<Integer> vertices;
	private MyHashMap vertices;

	public GrafoDirigido() {
		this.vertices = new MyHashMap<>();
	}

	@Override
	public void agregarVertice(int verticeId) {
		if(!vertices.containsKey(verticeId)) {
			this.vertices.put(vertices, null);
		}
	}

	@Override
	public void borrarVertice(int verticeId) {
		
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		Arco arco = new Arco<T>(verticeId1, verticeId2, etiqueta);
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		return false;
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		return false;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		return null;
	}

	@Override
	public int cantidadVertices() {
		return 0;
	}

	@Override
	public int cantidadArcos() {
		return 0;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		return null;
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		return null;
	}
}
