package ej1Arboles;

public class Node {
	private Integer value;
	private Node izq;
	private Node der;
	
	public Node(Integer value) {
		this.value = value;
		this.izq = null;
		this.der = null;
	}
	
	public Node getIzq() {
		return izq;
	}

	public void setIzq(Node izq) {
		this.izq = izq;
	}

	public Node getDer() {
		return der;
	}

	public void setDer(Node der) {
		this.der = der;
	}
	
	public void setValue(int e) {
		this.value = e;
	}

	public Integer getValue() {
		return value;
	}
	
	public boolean noTieneHijos() {
		return this.izq == null && this.der == null;
	}
	
	public boolean tieneUnSoloHijo() {
		return this.izq != null && this.der == null || this.izq == null && this.der != null;
	}
	
	public boolean tieneDosHijos() {
		return this.izq != null && this.der != null;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + ", izq=" + izq + ", der=" + der + "]";
	}
	
	
}
