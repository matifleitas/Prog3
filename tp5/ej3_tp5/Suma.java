package ej3_tp5;

import java.util.ArrayList;

import java.util.List;

public class Suma {	
	public Suma() {
	}

	public List<List<Integer>> sumaSubconjunto(int[] nums, Integer m) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> listActual = new ArrayList<Integer>();
		backtrackingSuma(nums, m, 0, listActual, result);
        return result;
	}
	
//	m=10	nums{2, 3, 5, 7};	
//	private void backtrackingSuma(int[] nums, int m, int start, List<Integer> listActual, List<List<Integer>> result) {
//		if(m == 0) { 
//			result.add(new ArrayList<>(listActual));
//		} else if(m > 0) {
//			for(int i=start;i<nums.length;i++) {
//				listActual.add(nums[i]);
//				backtrackingSuma(nums, m - nums[i], i + 1, listActual, result);
//				listActual.remove(listActual.size()-1);
//			}
//		}
//	}
	
	private void backtrackingSuma(int[] nums, int m, int indice, List<Integer> listActual, List<List<Integer>> result) {
		if(getSuma(listActual)==m) {
			result.add(new ArrayList<>(listActual));
		} else {
			if(indice<nums.length) {
				listActual.add(nums[indice]);
				backtrackingSuma(nums, m, indice+1, listActual, result);
				listActual.remove(listActual.size()-1);
				backtrackingSuma(nums, m, indice+1, listActual, result);
			}
		}
	}

	private int getSuma(List<Integer> listActual) {
		int sum=0;
		for (Integer integer : listActual) {
			sum+=integer;
		}
		return sum;
	}

}
