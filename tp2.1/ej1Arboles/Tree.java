package ej1Arboles;

public class Tree {
	private Node root;

	public Tree(Node root) {
		this.root = null;
	}
/*	    8
      /   \
     3    10
    / \     \
   1   6     14
      / \   /
     4   7 13
*/	
	public void add(Integer value) { //add publico
		if(this.root == null) {
			this.root = new Node(value);
		} else {
			add(this.root, value);
		}
	}

	private void add(Node actual, Integer value) { //add privado         
		if(actual.getValue() > value) {
			if(actual.getIzq() == null) {
				Node temp = new Node(value);
				actual.setIzq(temp);
			} else {
				add(actual.getIzq(), value);
			}
		} else if(actual.getValue() < value) {
			if(actual.getDer() == null) {
				Node temp = new Node(value);
				actual.setDer(temp);
			} else {
				add(actual.getDer(), value);
			}
		}
	}
	
	public Node getRoot() {
		return root;
	}
	
	public boolean isEmpty() {
		return this.root == null;
	}
	
	public boolean hasElement(Integer element) {
		return hasElement(this.root, element);
	}
	
	private boolean hasElement(Node actual, Integer element) {
		if(element == actual.getValue()) {
			return true;
		}
		
		if(element<root.getValue()) {
			return hasElement(actual.getIzq(), element);
		} else {
			return hasElement(actual.getDer(), element);
		}	
	}
	
	public int getHeight() {
		return getHeightPrivado(this.root, 1);
	}
	
	private int getHeightPrivado(Node actual, int h) {
		if(actual == null) {
			return h;
		}
		int mayorIzq = getHeightPrivado(actual.getIzq(), h++);
		int mayorDer = getHeightPrivado(actual.getDer(), h++);
		if(mayorIzq > mayorDer) {
			return mayorIzq;
		} else {
			return mayorDer;
		}
	}
	
	public void mostrarArbol() {
	    mostrarArbolRec(this.root, 0);
	}

	private void mostrarArbolRec(Node nodo, int nivel) {
	    if (nodo != null) {
	        
	        for (int i = 0; i < nivel; i++) {
	            System.out.print("   ");
	        }
	        System.out.println(nodo.getValue());
	        mostrarArbolRec(nodo.getIzq(), nivel + 1);
	        
	        for (int i = 0; i < nivel; i++) {
	            System.out.print("   ");
	        }
	        
	        mostrarArbolRec(nodo.getDer(), nivel + 1);
	    }
	}
	
	//devolver true si borro el elemento, y false en caso de que el elemento no exista
	public boolean delete(int e) {
		return deleteP(e, this.root);
	}
	
	private boolean deleteP(int value, Node raiz) {
	   if (raiz == null) {
	        return false; // Nodo no encontrado
	    }
		
		if(raiz.getValue() > value) {
			return deleteP(value, raiz.getIzq());
		} else if(raiz.getValue() < value){
			return deleteP(value, raiz.getDer());
		} else { 
			if(raiz.tieneUnSoloHijo()) {
				if(raiz.getIzq() != null) {
					raiz = raiz.getIzq(); // Hijo izquierdo se convierte en el nodo actual
				} else {
					raiz = raiz.getDer();
				}
				return true;
			} else if(raiz.tieneDosHijos()) {
				int valorMinimo = encontrarValorMinimoDerecho(raiz.getDer());
				raiz.setValue(valorMinimo);
				// preguntar como seguir
				
			} else { //no tiene hijos es una hoja
				raiz = null;
				return true;
			}
		} return false;
	}
	
	public int encontrarValorMinimoDerecho(Node actual) {
		if(actual.getIzq() != null) {
			return encontrarValorMinimoDerecho(actual.getIzq());
		} else {
			return actual.getValue();
		} 
	}
	
}
