package ej4;


public class FibonacciClass {
	
	public static void main(String[] args) {
		
		fibonacci(12);
	}
	
	public static void fibonacci(int cantidad) {
		fibonacci(cantidad, 0, 1);
	}
	
	private static void fibonacci(int cantidad, int valorUno, int valorDos) {
		if(cantidad >0) {
			System.out.println(valorUno);
			fibonacci(cantidad-1, valorDos, valorDos + valorUno);
		} else {
			System.out.println("La recursion finalizo.");
		}
	}
}

