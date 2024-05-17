package ej1_tp4;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		// Creo un grafo dirigdo donde las etiquetas de los arcos son valores Float
		GrafoDirigido<Float> grafito = new GrafoDirigido<>();
		
		grafito.agregarVertice(1);
		grafito.agregarVertice(2);
		grafito.agregarVertice(7);
		grafito.agregarVertice(5);
		grafito.agregarVertice(8);
		grafito.agregarVertice(12);
		grafito.agregarVertice(22);

		grafito.agregarArco(1, 2, 3F);
		grafito.agregarArco(12, 22, 3F);
		grafito.agregarArco(7, 8, 6F);
		grafito.agregarArco(5, 2, 12F);
		grafito.agregarArco(7, 1, 111F);
		grafito.agregarArco(1, 22, 111F);
		grafito.agregarArco(22, 5, 111F);
		grafito.agregarArco(2, 12, 111F);
		
 
		
		grafito.mostrarArcos(7);
		grafito.mostrarAdyacentes(7);
		System.out.println("-------------------------------------");
		DepthFirstSearch recorrido = new DepthFirstSearch();
		recorrido.dfs(grafito);
		CaminoMasLargo camino = new CaminoMasLargo(grafito);
		System.out.println(camino.encontrarCaminoMasLargo(1, 7));
		System.out.println(camino.encontrarCaminoMasLargo(7, 12));
		System.out.println("--------------------------------------");
		ExistaCamino exist = new ExistaCamino(grafito);
		System.out.println(exist.camAV(2));
		System.out.println("----------------------------------------");
		CiudadCuadras ciudad = new CiudadCuadras<>(grafito);
		ciudad.Bfs(1, 12);
	}
}
