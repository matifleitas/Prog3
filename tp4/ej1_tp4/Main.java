package ej1_tp4;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		// Creo un grafo dirigdo donde las etiquetas de los arcos son valores Float
		GrafoDirigido<Float> grafito = new GrafoDirigido<>();
		
//		grafito.agregarVertice(1);
//		grafito.agregarVertice(2);
//		grafito.agregarVertice(7);
//		grafito.agregarVertice(5);
//		grafito.agregarVertice(8);
//		grafito.agregarVertice(12);
//		grafito.agregarVertice(22);
        grafito.agregarVertice(1);
        grafito.agregarVertice(2);
        grafito.agregarVertice(3);
        grafito.agregarVertice(4);
        grafito.agregarVertice(5);
        grafito.agregarVertice(6);
        grafito.agregarVertice(7);
        grafito.agregarVertice(8);
        grafito.agregarVertice(9);
        grafito.agregarVertice(10);
        grafito.agregarVertice(11);
        grafito.agregarVertice(12);
        grafito.agregarVertice(13);
        grafito.agregarVertice(14);

//		grafito.agregarArco(1, 2, 3F);
//		grafito.agregarArco(12, 22, 3F);
//		grafito.agregarArco(7, 8, 6F);
//		grafito.agregarArco(5, 2, 12F);
//		grafito.agregarArco(7, 1, 111F);
//		grafito.agregarArco(1, 22, 111F);
//		grafito.agregarArco(22, 5, 111F);
//		grafito.agregarArco(2, 12, 111F);
		grafito.agregarArco(1, 2, 3F);
		grafito.agregarArco(1, 6, 3F);
		grafito.agregarArco(2, 3, 6F);
		grafito.agregarArco(2, 7, 12F);
		grafito.agregarArco(3, 4, 111F);
		grafito.agregarArco(3, 8, 111F);
		grafito.agregarArco(4, 5, 111F);
		grafito.agregarArco(4, 9, 111F);
		grafito.agregarArco(5, 10, 3F);
		grafito.agregarArco(6, 7, 3F);
		grafito.agregarArco(6, 11, 6F);
		grafito.agregarArco(7, 8, 12F);
		grafito.agregarArco(7, 12, 111F);
		grafito.agregarArco(8, 9, 111F);
		grafito.agregarArco(8, 13, 111F);
		grafito.agregarArco(9, 10, 111F);
		grafito.agregarArco(9, 14, 6F);
		grafito.agregarArco(10, 15, 12F);
		grafito.agregarArco(11, 12, 6F);
		grafito.agregarArco(12, 13, 12F);
		grafito.agregarArco(13, 14, 111F);
		grafito.agregarArco(14, 15, 111F);
	
		
		
 
		
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
		System.out.println(ciudad.bfs(1, 14));
	}
}
