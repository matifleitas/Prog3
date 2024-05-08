package ej1_tp4;
import java.util.HashMap;
import java.util.Iterator;

public class DepthFirstSearch { //en profundidad, recursivamente
	private HashMap<Integer,InfoCamino> recorrido;
    private int tiempo;

    public DepthFirstSearch(){
        this.recorrido = new HashMap<>();
    }
    
    public void dfs(Grafo g) {
    	Iterator<Integer> iteratVertices = g.obtenerVertices();
    	inicializar(iteratVertices);//meto al recorrido mi primer vertice
    	while(iteratVertices.hasNext()) {
    		Integer vertice = iteratVertices.next();//num de vert
    		if(recorrido.get(vertice).getColor() == "blanco") {
    			dfsVisit(g, vertice);
    		}
    	}
    }
    
    //metodo exclusivamente para chuquear que alla vertices aun y comenzar el recorrido
    public void inicializar(Iterator<Integer> listVert) {
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

