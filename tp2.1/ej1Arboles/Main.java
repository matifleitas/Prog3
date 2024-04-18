package ej1Arboles;

public class Main {

	public static void main(String[] args) {
		Tree treeOrd = new Tree(null);
		
		treeOrd.add(5);
		treeOrd.add(3);
		treeOrd.add(6);
		treeOrd.add(3);
		treeOrd.add(7);
		treeOrd.add(11);
		treeOrd.add(100);
		treeOrd.add(91);

		
		System.out.println("Árbol mostrado:");
		treeOrd.mostrarArbol();
		
		System.out.println("El arbol tiene una altura de: "+treeOrd.getHeight());
		
		System.out.println("La raiz del arbol es: "+treeOrd.getRoot());
		
		treeOrd.delete(11);
		System.out.println("--------------------------");
		treeOrd.mostrarArbol();

	}

}
