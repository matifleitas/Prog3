package ej2Arboles;

public class Tree {
	private Node root;
	private int valueTree;
	
	public Tree() {
		this.root = null;
		this.valueTree = 0;
	}
	
	public void add(Integer value) {
		if (this.root == null) {
			this.root = new Node(value);
		} else {
			this.add(this.root,value);
		}
//		valueTree += value;
	}
	
	public void delete(Integer value) {
		root = deleteNode(this.root, value);
	}
	
	private Node deleteNode(Node actual, Integer value) {
		if(actual == null) {
			return null;
		}
		
		int state = value.compareTo(actual.getValue());
		if (state < 0) {
			actual.setLeft(deleteNode(actual.getLeft(), value));
		} else if (state > 0) {
			actual.setRight(deleteNode(actual.getRight(), value));
		} else {
			if(actual.getLeft() == null) {
				return actual.getRight();
			} else if(actual.getRight() == null) {
				return actual.getLeft();
			}
			Integer valueMoreLeft = findNodeMoreLeft(actual.getRight());
			actual.setValue(valueMoreLeft);
			actual.setRight(deleteNode(actual.getRight(), actual.getValue()));
			
		} return actual;
	}
	
	private Integer findNodeMoreLeft(Node n) {
		if(n.getLeft() == null) {
			return n.getValue();
		} return findNodeMoreLeft(n.getLeft());
	}
	
	private void add(Node actual, Integer value) {
		if (actual.getValue() > value) {
			if (actual.getLeft() == null) { 
				Node temp = new Node(value);
				actual.setLeft(temp);
			} else {
				add(actual.getLeft(),value);
			}
		} else if (actual.getValue() < value) {
			if (actual.getRight() == null) { 
				Node temp = new Node(value);
				actual.setRight(temp);
			} else {
				add(actual.getRight(),value);
			}
		}
	}
	
	public void inOrder() {
		inOrder(root);
	}
	
	private void inOrder(Node raiz) {
        if (raiz != null) {
            inOrder(raiz.getLeft());
            System.out.print(raiz.getValue() + " Valor de mi hijo izquierda: {"+ raiz.getLeft() + "} Valor de mi hijo derecho: {" + raiz.getRight() + "} ");
            inOrder(raiz.getRight());
        }
    }
	
	public void preOrder() {
		preOrder(root);
	}
	
	private void preOrder(Node raiz) {
        if (raiz == null) {
        	return;
        }
    	System.out.println(raiz.getValue() + "");
    	preOrder(raiz.getLeft());
        preOrder(raiz.getRight());
    }

	public Node getRoot() {
		return root;
	}

	public int getValueTree() {
		return valueTree;
	}
	
	public int getSumInternal() {
		return getSum(this.root);
	}
	
	private int getSum(Node nodeActual) {
		if (nodeActual == null) {
			return 0;
		}
		if(nodeActual.hasChild()) {
			this.valueTree = nodeActual.getValue() + getSum(nodeActual.getLeft()) + getSum(nodeActual.getRight());
		} return valueTree;
	}
}

