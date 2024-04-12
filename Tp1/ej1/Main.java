package ej1;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MySimpleLinkedList<Integer> myListDesord = new MySimpleLinkedList<>();
        myListDesord.insertFront(1);
        myListDesord.insertFront(9);
        myListDesord.insertFront(7);
        myListDesord.insertFront(11);       
        myListDesord.insertFront(91);
        myListDesord.insertFront(56);
        myListDesord.insertFront(99);
        
        MySimpleLinkedList<Integer> myListDesord2 = new MySimpleLinkedList<>();
        myListDesord2.insertFront(99);
        myListDesord2.insertFront(14);
        myListDesord2.insertFront(9);
        myListDesord2.insertFront(71);
        myListDesord2.insertFront(90);
        myListDesord2.insertFront(104);
        myListDesord2.insertFront(11);       
        
        MySimpleLinkedList<Integer> myListOrde = new MySimpleLinkedList<>();
        myListOrde.insertFront(3);
        myListOrde.insertFront(6);
        myListOrde.insertFront(7);
        myListOrde.insertFront(9);       
        myListOrde.insertFront(14);
        myListOrde.insertFront(24);
        myListOrde.insertFront(99);
        
        MySimpleLinkedList<Integer> myListOrde2 = new MySimpleLinkedList<>();
        myListOrde2.insertFront(4);
        myListOrde2.insertFront(9);
        myListOrde2.insertFront(11);
        myListOrde2.insertFront(12);       
        myListOrde2.insertFront(14);
        myListOrde2.insertFront(99);
        myListOrde2.insertFront(104);

//        MySimpleLinkedList<Integer> myListFinal = obtenerListOrdenadaElementComunesDes(myListDesord, myListDesord2);
//        for (Integer i : myListFinal) {
//			System.out.println(i);
//		}
        
        MySimpleLinkedList<Integer> myListFinal2 = obtenerListOrdenadaElementComunesOrd(myListOrde, myListOrde2);
        for (Integer i : myListFinal2) {
			System.out.println(i);
		}
        

    }   
    
    public static MySimpleLinkedList<Integer> obtenerListOrdenadaElementComunesDes(MySimpleLinkedList<Integer> list1, MySimpleLinkedList<Integer> list2){
    	Iterator<Integer> iterat = list1.iterator();
    	MySimpleLinkedList<Integer> listFinal = new MySimpleLinkedList<Integer>();
    	Comparador c = new Comparador();
    	
    	while(iterat.hasNext()) {
    		Integer num = iterat.next();
    		if(list2.exists(num)) {
    			listFinal.insertOrder(num, c);
    		}
    	}
    	return listFinal;
    }
    
    public static MySimpleLinkedList<Integer> obtenerListOrdenadaElementComunesOrd(MySimpleLinkedList<Integer> list1, MySimpleLinkedList<Integer> list2){
    	MySimpleLinkedList<Integer> listFinal = new MySimpleLinkedList<Integer>();
    	MyIterator<Integer> iterat1 = (MyIterator<Integer>)list1.iterator();
    	MyIterator<Integer> iterat2 = (MyIterator<Integer>)list2.iterator();
    	
    	while(iterat1.hasNext() && iterat2.hasNext()) {
  
    		if(iterat1.getInformacion() == iterat2.getInformacion()) {
    			listFinal.insertFront(iterat1.getInformacion());
    			iterat1.next();
    			iterat2.next();
    		} else if(iterat1.getInformacion() < iterat2.getInformacion()) {
    			iterat2.next();
    		} else {
    			iterat1.next();
    		}
    	}
    	return listFinal;
    }
    
}