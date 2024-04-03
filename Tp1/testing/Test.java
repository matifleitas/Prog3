package testing;

public class Test {
	//RECURSIVIDAD
	public static void imprimir(int x) {
		if(x > -10) { /*Condicion de corte*/
			System.out.println(x);
			imprimir(x-1);
		} else {
			System.out.println("llegamos a la condicion de corte");
		}
	}
	
	public static void main(String[] args) {
		Test t = new Test();
		t.imprimir(7);
	}
}
