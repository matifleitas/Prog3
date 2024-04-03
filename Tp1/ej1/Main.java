package ej1;

public class Main {
    public static void main(String[] args) {
//    	MySimpleLinkedList<T> listaResultante = new MySimpleLinkedList<>();
        MySimpleLinkedList<Integer> listaDesordenada = new MySimpleLinkedList<>();
        listaDesordenada.insertFront(4);
        listaDesordenada.insertFront(9);
        listaDesordenada.insertFront(7);
        listaDesordenada.insertFront(11);

        MySimpleLinkedList<Integer> listaOrdenada = new MySimpleLinkedList<>();
        listaOrdenada.insertFront(1);
        listaOrdenada.insertFront(2);
        listaOrdenada.insertFront(3);
        listaOrdenada.insertFront(8);
        listaOrdenada.insertFront(5);

        MySimpleLinkedList<Integer> listaOrdenadaFinal = Alistar(listaDesordenada, listaOrdenada);

        System.out.println("Elementos comunes: " + listaOrdenadaFinal);
        
    }
}