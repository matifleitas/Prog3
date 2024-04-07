package ej5;

import java.util.Iterator;
public class IteratorMy<T> implements Iterator<T> {
	
		private Node<T> cursor;
		
		public IteratorMy(Node<T> cursor) {
			this.cursor = cursor;
		}

		@Override
		public boolean hasNext() {
			return cursor != null;
		}

		@Override
		public T next() {
			T temp = this.cursor.getInfo();
			this.cursor = this.cursor.getNext();
			return temp;
		}
		
		public T getInformacion() {
			T temp = this.cursor.getInfo();
			return temp;
		}

	}

