package ej2Arboles;

public class Main {

	public static void main(String[] args) {
		Tree arbolBinary = new Tree();
		
        arbolBinary.add(3);
        arbolBinary.add(7);
        arbolBinary.add(1);
        arbolBinary.add(9);
        arbolBinary.add(12);
        arbolBinary.add(5);
        arbolBinary.add(21);
        arbolBinary.add(44);

        
        System.out.println("Árbol binario en pre-orden (Pre-order):");
        arbolBinary.preOrder();        
//        System.out.println("Árbol binario en orden (IN-order):");
//        arbolBinary.inOrder();

//        System.out.println();
        System.out.println("----------------------------------");
        System.out.println("Valor total del arbol: " + arbolBinary.getSumInternal());
        System.out.println("----------------------------------");
        arbolBinary.delete(12);
        arbolBinary.preOrder();
      
	}

}
