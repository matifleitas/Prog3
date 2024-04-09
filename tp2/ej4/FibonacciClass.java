package ej4;


public class FibonacciClass {
	
	public static void fibonacci(int cantidad) {
		fibonacciPrivate(cantidad, 0, 1);
	}
	
	private static void fibonacciPrivate(int cantidad, int valorUno, int valorDos) {
		if(cantidad > 0) {
			System.out.println(valorUno);
			fibonacciPrivate(cantidad-1, valorDos, valorDos + valorUno);
		} else {
			System.out.println("La recursion finalizo.");
		}
	}
}