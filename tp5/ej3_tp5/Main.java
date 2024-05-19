package ej3_tp5;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		Suma s = new Suma();
		int[] nums = {2, 3, 5, 7}; // Ejemplo de conjunto de números
        int m = 10; // Ejemplo de valor de
        List<List<Integer>> lista = s.sumaSubconjunto(nums, m);
        System.out.println("Subconjuntos cuya suma es " + m + ": " + lista);
    
	}

}
