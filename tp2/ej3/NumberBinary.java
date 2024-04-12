package ej3;

import java.util.ArrayList;

public class NumberBinary {
	
	public static void numberBinaryMethod(int numero) {
		ArrayList<Integer> resultBinary = new ArrayList<Integer>();
		calcularBinary(numero, 0, 1, resultBinary);
	}
	
	private static void calcularBinary(int num, int binaryFalse, int binaryTrue, ArrayList<Integer> A){
		if(num > 1) {
			if(num % 2 == 0) {
				A.add(binaryFalse);
			} else {
				A.add(binaryTrue);
			}
			calcularBinary(num/2, binaryFalse, binaryTrue, A);
		} else { //llego a 1 y ya no se puede dividir por 2
			A.add(binaryTrue);
			
			for(int i=A.size()-1;i>=0;i--) {
	            System.out.print(A.get(i) + " ");
			}
		}
	}
}
