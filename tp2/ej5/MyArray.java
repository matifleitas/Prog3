package ej5;

import java.util.ArrayList;
import java.util.List;

public class MyArray<T> {
	
	private ArrayList<Integer> lista;

	public MyArray() {
		lista = new ArrayList<>();
	}
	
	public void addElement(Integer e) {
		this.lista.add(e);
	}
	
	public void verificacion(int e) {
			boolean encontro = false;
			int posActual = 0;
			
			while(posActual < this.lista.size() && !encontro) {
				
				if(this.lista.contains(e)) {
					int valorDePosActual = (int) lista.get(e);
					int posDeE = lista.indexOf(e);
					if(valorDePosActual == posDeE) {
						encontro = true;
						System.out.println("se encontro el valor: " + valorDePosActual + ", en la posicion "+posDeE);
					}
				} else {
					posActual++;
				}
			}
	}
		
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < lista.size(); i++) {
            sb.append(lista.get(i));
            if (i < lista.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
