package ej1;

import java.util.Comparator;

public class Node<T>{
	private T info;
	private Node<T> next;
	
	public Node() {
		this.info = null;
		this.next = null;
	}

	public Node(T info) {
		this.setInfo(info);
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}
	
	public void insertNext(Comparator<T> c, Node<T> nodo) {
		if(this.next == null) {
			this.next = nodo;
		} else if(c.compare(this.next.getInfo(), nodo.getInfo()) > 0) {
			nodo.insertNext(c, next);
			next = nodo;
		} else {
			next.insertNext(c, nodo);
		}
	}
}
