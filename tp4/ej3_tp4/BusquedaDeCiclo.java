package ej3_tp4;

import java.util.HashMap;
import java.util.Iterator;

public class BusquedaDeCiclo {
	private HashMap<Integer, InfoCamino> recorrido;

	public BusquedaDeCiclo(HashMap<Integer, InfoCamino> recorrido) {
		this.recorrido = recorrido;
	}
	
	public void hayCiclo(Grafo g) {
		Iterator<Integer> vertices = g.obtenerVertices();
		inicializar(vertices);
		while(vertices.hasNext()) { //el iterator queda apuntando al ultimo, corregir
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
	
	public void inicializar(Iterator<Integer> itVertices) {
		while(itVertices.hasNext()) {
			Integer indiceVertice = itVertices.next();
			InfoCamino info = new InfoCamino("Blanco");
			recorrido.put(indiceVertice, info);
		}
	}
}
