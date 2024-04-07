package ej5;

import java.util.Iterator;

public class LinkedList <T> implements Iterable<T>{
	private Node<T> first;

	public LinkedList() {
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
		
		while(actual.getNext() != null) { 
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

	public Node<T> getFirst() {
	    return first;
	}
	
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
	public Iterator<T> iterator() {
		return null;
	}
	
	public void elementosComunes(LinkedList<T> list1, LinkedList<T> list2) {
		
	}

}
