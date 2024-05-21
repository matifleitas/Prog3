package ej3_tp5;

import java.util.ArrayList;
import java.util.List;

public class SumaConjuntos {

	private List<List<Integer>> resultado;
	private boolean encontro;
	
	public SumaConjuntos() {
		this.resultado = new ArrayList<>();
		this.encontro = false;
	}
	
	public List<List<Integer>> sumaConjuntos(int [] a) {
		List<Integer> listIzq = new ArrayList<>();
		List<Integer> listDer = new ArrayList<>();
		sumaConjuntos(a, listIzq, listDer, 0);
		return this.resultado;
	}
							   //{2, 7, 9, 12, 14, 16}
	private void sumaConjuntos(int [] nums, List<Integer> listIzq, List<Integer> listDer, int indice) {
		if(listIzq.size() + listDer.size() == nums.length && !this.encontro) {
			if(esSolucion(listIzq, listDer)) {
				this.resultado.add(new ArrayList<>(listIzq));
				this.resultado.add(new ArrayList<>(listDer));
				this.encontro = true;
			}
		} else {
			if(indice<nums.length) {
				listIzq.add(nums[indice]);
				sumaConjuntos(nums, listIzq, listDer, indice+1);
				listIzq.remove(listIzq.size()-1);
				listDer.add(nums[indice]);
				sumaConjuntos(nums, listIzq, listDer, indice+1);
				listDer.remove(listDer.size()-1);
			}
		}
	}

	private boolean esSolucion(List<Integer> listIzq, List<Integer> listDer) {
		int sum1=0;
		int sum2=0;
		for (Integer integer : listIzq) {
			sum1+=integer;
		}
		for (Integer integer : listDer) {
			sum2 += integer;
		}
		return sum1==sum2;
//		long sum1 = listIzq.stream().mapToInt(e -> e.intValue()).summaryStatistics().getSum();
//		long sum2 = listDer.stream().mapToInt(e -> e.intValue()).summaryStatistics().getSum();
//		return sum1==sum2;
	}
}
