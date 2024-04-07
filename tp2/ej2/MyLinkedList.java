package ej2;

import java.util.Iterator;

import ej1.MyIterator;
import ej1.Node;

public class MyLinkedList<T>  implements Iterable<T>{
	private Node<T> first;
	private int size;
	
	public MyLinkedList() {
		this.first = null;
		this.size = 0;
	}
	
	public void insertFront(T info) {
		Node<T> temp = new Node<T>(info, null);
		temp.setNext(this.first);
		this.first = temp;
		this.size++;
	}
	
	public T extractFront() { //'extrar el primero'
		Node<T> current = this.first;
		Node<T> prev = null;
		
		while(current.getNext() != null) {
			prev = current;
			current = current.getNext();
		}
		
		T info = current.getInfo();
		prev.setNext(null); //2-3-6-8(previo)-null(devuelvo su info y queda en null)
		this.size--;
		
		return info;
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
	
	@Override
	public Iterator<T> iterator() {
		return new MyIterator<>(this.first);
	}
}
