package ej3_tp4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class BusquedaDeCiclo {
	private HashMap<Integer, InfoCamino> recorrido;

	public BusquedaDeCiclo() {
		this.recorrido = new HashMap<Integer, InfoCamino>();
	}
	
	public void hayCiclo(Grafo g) {
		inicializar(g);
		Iterator<Integer> vertices = g.obtenerVertices();
		while(vertices.hasNext()) { //el iterator queda apuntando al ultimo y los anteriores los elimina, corregir
			Integer aux = vertices.next();
			if(recorrido.get(aux).getColor() == "Blanco") {
				hayCiclo(g, aux);
			}
		}
	}
	
	private void hayCiclo(Grafo g, Integer vertice) {
		InfoCamino info = recorrido.get(vertice);
		info.setColor("Amarillo");
		recorrido.put(vertice, info);
		
		Iterator <Integer> vertAdyacentes = g.obtenerAdyacentes(vertice);
		while(vertAdyacentes.hasNext()) {
			Integer vAdy = vertAdyacentes.next();
			if(this.recorrido.get(vAdy).getColor() == "Blanco") {
				hayCiclo(g, vAdy);
			} else {
				if(recorrido.get(vAdy).getColor() == "Amarillo") {
					System.out.println("Hay ciclo!");
				}
			}
		}
		info.setColor("Negro");
		recorrido.put(vertice, info);
	}
	
	public void inicializar(Grafo g) {
		Iterator<Integer> vertices = g.obtenerVertices();
		while(vertices.hasNext()) {
			Integer indiceVertice = vertices.next();
			InfoCamino info = new InfoCamino("Blanco");
			recorrido.put(indiceVertice, info);
		}
	}
	
}
