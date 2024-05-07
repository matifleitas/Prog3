package ej1_tp4;


public class Main {

	public static void main(String[] args) {
		// Creo un grafo dirigdo donde las etiquetas de los arcos son valores Float
		GrafoDirigido<Float> grafito = new GrafoDirigido<>();
		
		// Agrego los vertices 1 y 2
		grafito.agregarVertice(1);
		grafito.agregarVertice(2);
		grafito.agregarVertice(7);
		grafito.agregarVertice(5);
		grafito.agregarVertice(8);
		grafito.agregarVertice(12);
		grafito.agregarVertice(22);
		

		// Genero un arco desde 1 hasta 2 con el valor de etiqueta 3
		grafito.agregarArco(1, 2, 3F);
		grafito.agregarArco(2, 7, 1F);
		grafito.agregarArco(12, 22, 3F);
		grafito.agregarArco(7, 8, 6F);
		grafito.agregarArco(5, 2, 12F);
		grafito.agregarArco(8, 2, 31F);
		grafito.agregarArco(7, 2, 11F);
		grafito.agregarArco(7, 5, 111F);
		
		
		// Obtengo el arco entre 1 y 2, y le pido la etiqueta
		Float etiqueta = grafito.obtenerArco(1, 2).getEtiqueta();
		
		System.out.println(etiqueta); // Debería imprimir 3
		
		grafito.mostrarArcos(7);
		grafito.mostrarAdyacentes(7);
		
	}
}
