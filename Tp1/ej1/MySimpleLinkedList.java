package ej1;

import java.util.Comparator;
import java.util.Iterator;

public class MySimpleLinkedList<T> implements Iterable<T>{
	private Node<T> first;
	
	public MySimpleLinkedList() { //constructor
		this.first = null;
	}
	
	public void insertFront(T info) {
		Node<T> temp = new Node<T>(info);
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
		T elementBuscado = this.first.getInfo();
		int count = 0;
		
		while(this.first != null) {
			if(elementBuscado == info) {
				return count;
			} else {
				count ++;
			}
		}return -1;
	}

	public Node<T> getFirst() {
	    return first;
	}
	
	public boolean exists(T info) {
		Node<T> pointer = first;
		while(pointer != null) {
			if(pointer.getInfo().equals(info)) {
				return true;
			} else {
				pointer = pointer.getNext();
			}
		}
		return false;
	}
	
	public void insertOrder(T info, Comparator<T> comp) {
		Node<T> newNode = new Node<>(info);
		if(this.first == null) {
			this.first = newNode;
		} else {
			if(comp.compare(this.first.getInfo(), info) > 0) {//si getInfo es mas mayor que info, nuevo nodo pasa a ser first
				newNode.insertNext(comp, this.first);
				this.first = newNode;
			} else {
				this.first.insertNext(comp, newNode);
			}
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new MyIterator<>(this.first);
	}
}

