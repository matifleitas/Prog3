package ej5;

public class MyArrayManager {
	/*Dado un arreglo ordenado de números distintos A se desea construir un algoritmo que
	determine si alguno de los elementos de dicho arreglo contiene un valor igual a la posición en la
	cuál se encuentra, es decir, A[i] = i*/
	public boolean estaEnArray(int [] A, int ini, int fin) {
		int medio;
		if(ini>fin) {
			return false;
		} else {
			medio = (ini+fin)/2;   //[0, 1, 2, 3, 4, 5,  6,  7]
			if(medio == A[medio]) { //{-3,-1,0, 2, 3, 5, 10, 13}
				return true; 
			} else if(medio > A[medio]) {
				return estaEnArray(A, medio+1, fin);
			} else {
				return estaEnArray(A, ini, medio-1);
			}
		}
	}
}
