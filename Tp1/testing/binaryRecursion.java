package testing;

public class binaryRecursion {
	int [] Aint = {2, 5, 6, 7, 9, 11, 15, 44, 65, 71, 72, 77, 82, 84, 88, 91, 95};
	
	public int BinaryRecursiva(int[] A, int x, int ini, int fin) {
		int medio;
		if(ini > fin) {
			return -1;
		} else {
			medio = (ini+fin)/2; //busco el medio
		}
		if(x > A[medio]) {
			return BinaryRecursiva(A, x, medio+1, fin);//ini = (medio+1), dividiendo el array a la mitad
		}else {
			if(x < A[medio]) {
				return BinaryRecursiva(A, x, ini, medio-1);//fin = (medio-1), dividiendo el array a la mitad
			} else {
				return medio;
			}
		}
	}
}
