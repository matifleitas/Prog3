package ej5;

public class Main {
	public static void main (String [] args){
		MyArray<Integer> myA = new MyArray<>();
		
		myA.addElement(1);
		myA.addElement(4);
		myA.addElement(6);
		myA.addElement(7);
		myA.addElement(9);
		myA.addElement(11);
		myA.addElement(43);
		myA.addElement(66);
		myA.addElement(71);
		myA.addElement(92);
		System.out.println(myA);
		myA.verificacion(7);
		//buscar un numero que sea igual a la posicion del que te mando x parametros
	}
}
