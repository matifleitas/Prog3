package ej1;

import java.util.Iterator;

public class MySimpleLinkedList<T> implements Iterator<T>, Comparable<MySimpleLinkedList<T>>{ //preguntar lo de abs
	private Node<T> first;
	
	public MySimpleLinkedList() { //constructor
		this.first = null;
	}
	
	public void insertFront(T info) {
		Node<T> temp = new Node<T>(info, null);
		temp.setNext(this.first);
		this.first = temp;
	}
	
	public T extractFront() {		
		Node<T> actual = this.first;
		Node<T> anterior = null;
		
		while(actual.getNext() != null) { //voy hasta el ultimo node
			anterior = actual;
			actual = actual.getNext();
		}

		T infoUltimo = actual.getInfo();
		anterior.setNext(null); //desconectar ultimo node
		
		return infoUltimo;
	}

	public boolean isEmpty() {
		return this.first == null;  //si no existe el primero ya esta {0}
	}
	
	/*
	public T get(int index) {
		
		return null;
	}
	*/
	public int size() {
		int count=0;
		Node<T> pointerNode = this.first;
		while(pointerNode.getNext() != null) { //si != null el proximo hace un ++
			count++;
			pointerNode = pointerNode.getNext();
		}
		return count;
	}
	
	@Override
	public String toString() {
		String infoTotal = "";
        Node<T> pointer = this.first;
		
		while(pointer != null) {
			infoTotal += pointer.getInfo() + " ";// Concatenar la info del nodo actual
			pointer = pointer.getNext(); //adelanto al node proximo
		}
        return infoTotal;
	}
	
	public int indexOf(T info) {
		T element = this.first.getInfo();
		int count = 0;
		
		while(this.first != null) {
			if(element == info) {
				return count;
			} count ++;
		} return -1;
	}


	@Override
	public boolean hasNext() {
		return (this.first != null);
	}

	@Override
	public T next() {
		if(!hasNext()) {
			System.out.println("No hay mas nodos");
		}
		T info = this.first.getInfo();
		first = first.getNext();//first ahora es el proximo
		return info;
	}
	
	@Override
    public void remove() {
        throw new UnsupportedOperationException("El método remove no está soportado");
    }
	
	public Node<T> getFirst() {
	    return first;
	}
	
	public void Alistar(MySimpleLinkedList<T> listaDesord, MySimpleLinkedList<T> listaOrdenad) {
		MySimpleLinkedList<T> listFinal = new MySimpleLinkedList<>();
		
		Node<T> pointer1 = listaDesord.getFirst();
		Node<T> pointer2 = listaOrdenad.getFirst();
		
		 while (pointer1 != null && pointer2 != null) {
			 int comparador = pointer1.getInfo().compareTo(pointer2.getInfo());
			 if(comparador == 0) {
				 listFinal.insertFront(pointer1.getInfo());
				 pointer1 = pointer1.getNext();
				 pointer2 = pointer2.getNext();
			 }else if(comparador < 0) {
				 pointer1 = pointer1.getNext();
			 } else {
				 pointer2 = pointer2.getNext();
			 }
		}
	}
	
	public void insertInOrder(T info) {
		Node<T> newNodo = new Node<T>(info, null);
		
		if(this.isEmpty()) {
			this.first = newNodo;
			return;
		}
		
		// Caso especial: el nuevo nodo es menor que el primero
	    if (newNodo.getInfo().compareTo(this.first.getInfo()) < 0) {
	    	newNodo.setNext(this.first);
	        this.first = newNodo;
	        return;
	    }
	    
	    Node<T> previo = null;
	    Node<T> pointer = this.first;
	    
	    while (pointer != null && newNodo.getInfo().compareTo(pointer.getInfo()) > 0) {//si mi newNodo es mayor que pointer
	        previo = pointer; //mi previo pasa a ser pointer
	        pointer = pointer.getNext(); // pointer se vuelve el siguiente nodo de la lista
	    }

	    previo.setNext(newNodo); //actualizo punteros
	    newNodo.setNext(pointer); //actualizo punteros
	}


	@Override
	public int compareTo(MySimpleLinkedList<T> o) {
		int tamañoThis = this.size();
        int tamañoOtra = o.size();

        return Integer.compare(tamañoThis, tamañoOtra);;
	}
}

