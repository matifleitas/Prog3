package ej5;

public class Main {
	public static void main (String [] args){
		int [] A = {-3, -1, 0, 1, 3, 5, 10, 13};
		
		MyArrayManager admin = new MyArrayManager();
		int fin = A[A.length-1];
		
		boolean result = admin.estaEnArray(A, 0, fin);
		System.out.println("Existe un valor que cumple la condicion en el array?: "+result);
	}
}
