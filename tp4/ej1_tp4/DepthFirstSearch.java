package ej1_tp4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class DepthFirstSearch { //en profundidad, recursivamente
	private HashMap<Integer,InfoCamino> recorrido;
    private int tiempo;

    public DepthFirstSearch(){
        this.recorrido = new HashMap<>();
    }
//    
//    public void inicializarP(Grafo g) {
//    	Iterator<Integer> listVert = g.obtenerVertices();
//    	while(listVert.hasNext()) {
//    		Integer aux = listVert.next(); //obtengo numVertice
//    		InfoCamino info = new InfoCamino(0, 0, "blanco"); //creo info del camino
//    		recorrido.put(aux, info);//agrego mi numVertice, con su infoCamino a mi hashMap de DFS
//    	} this.tiempo = 0;
//    }
//    
//    //verificar con debugging
//    public List<Integer> dfsCamino(Grafo g, Integer i, Integer j) {
//    	List<Integer> listFinal = new ArrayList<Integer>();
//    	List<Integer> listAcutal = new ArrayList<Integer>();
//    	inicializar(g);//meto al recorrido mi primer vertice
//    	Iterator<Integer> iteratVertices = g.obtenerVertices();
//    	
//    	while(iteratVertices.hasNext()) {
//    		Integer vertice = iteratVertices.next();//num de vert
//    		if(recorrido.get(vertice).getColor() == "blanco" && vertice.equals(i)) {
//    			listAcutal = dfsVisitCamino(g, vertice, listAcutal, i, j);
//    			if(listFinal.size() < listAcutal.size()) {
//    				listFinal = listAcutal;
//    			}
//    		}
//    	} return listFinal;
//    }
//    
//    private List<Integer> dfsVisitCamino(Grafo grafito,Integer vertice, List<Integer> listFinal, Integer i, Integer j){
//    	InfoCamino info = recorrido.get(vertice);
//    	info.setColor("amarillo");
//    	listFinal.add(vertice);
//    	this.tiempo++;
//    	info.setTiempo(tiempo);
//    	recorrido.put(vertice, info); //piso el color de mi vertice, pegandole a la misma key
//    	
//    	if(vertice.equals(j)) {
//    		return listFinal;
//    	} else {
//	    	Iterator<Integer> ady = grafito.obtenerAdyacentes(vertice);
//	    	while(ady.hasNext()) {
//	    		Integer vertAdy = ady.next();
//	    		if(this.recorrido.get(vertAdy).getColor() == "blanco") {
//	    			return dfsVisitCamino(grafito, vertAdy, listFinal, i, j);
//	    		} else {
//	    			if(this.recorrido.get(vertAdy).getColor() == "amarillo") {
//	    				System.out.println("Tenemos un ciclo!");
//	    				return new ArrayList<Integer>();
//	    			}
//	    		}
//	    	}
//	    	info.setColor("negro");
//	    	this.tiempo++;
//	    	info.setTiempoFinal(tiempo);
//	    	recorrido.put(vertice, info);
//	    	return listFinal;
//    	}
//    }
//    /////////////////////////////////////////////////////////////
    public void dfs(Grafo g) {
    	inicializar(g);//meto al recorrido mi primer vertice
    	Iterator<Integer> iteratVertices = g.obtenerVertices();
    	while(iteratVertices.hasNext()) {
    		Integer vertice = iteratVertices.next();//num de vert
    		if(recorrido.get(vertice).getColor() == "blanco") {
    			dfsVisit(g, vertice);
    		}
    	}
    }
    
    //metodo exclusivamente para chuquear que alla vertices aun y comenzar el recorrido
    public void inicializar(Grafo g) {
    	Iterator<Integer> listVert = g.obtenerVertices();
    	while(listVert.hasNext()) {
    		Integer aux = listVert.next(); //obtengo numVertice
    		InfoCamino info = new InfoCamino(0, 0, "blanco"); //creo info del camino
    		recorrido.put(aux, info);//agrego mi numVertice, con su infoCamino a mi hashMap de DFS
    	} this.tiempo = 0;
    }
    
    private void dfsVisit(Grafo grafito,Integer vertice){
    	InfoCamino info = recorrido.get(vertice);
    	info.setColor("amarillo");
    	this.tiempo++;
    	info.setTiempo(tiempo);
    	recorrido.put(vertice, info); //piso el color de mi vertice, pegandole a la misma key
    	
    	Iterator<Integer> ady = grafito.obtenerAdyacentes(vertice);
    	while(ady.hasNext()) {
    		Integer vertAdy = ady.next();
    		if(this.recorrido.get(vertAdy).getColor() == "blanco") {
    			dfsVisit(grafito, vertAdy);
    		} else {
    			if(this.recorrido.get(vertAdy).getColor() == "amarillo") {
    				System.out.println("Tenemos un ciclo!");
    			}
    		}
    	}
    	info.setColor("negro");
    	this.tiempo++;
    	info.setTiempoFinal(tiempo);
    	recorrido.put(vertice, info);
    }
}

