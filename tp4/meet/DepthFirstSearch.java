package meet;

import java.util.HashMap;
import java.util.Iterator;

public class DepthFirstSearch {
    private HashMap<Integer,InfoCamino> recorrido;
    private int tiempo;

    public DepthFirstSearch(){
        this.recorrido = new HashMap<>();
    }
    public void inicializar(Grafo grafito,Iterator<Integer> listVertices ){
        while (listVertices.hasNext()){
            Integer aux = listVertices.next();
            InfoCamino info = new InfoCamino(0,0,"blanco");
            recorrido.put(aux,info);
        }
        this.tiempo = 0;
    }

    public void dfg(Grafo grafito){
        Iterator<Integer> listVertices = grafito.obtenerVertices();
        inicializar(grafito,listVertices);
        while(listVertices.hasNext()){
            Integer vertice = listVertices.next();
            if(recorrido.get(vertice).getColor() == "blanco"){
                dfgVisit(grafito,vertice);
            }
        }
    }

    private void dfgVisit(Grafo grafito,Integer vertice){
        this.tiempo += 1;
        InfoCamino aux = recorrido.get(vertice);
        aux.setColor("amarillo");
        aux.setTiempo(tiempo);
        recorrido.replace(vertice,aux);

        Iterator<Integer> adj = grafito.obtenerAdyacentes(vertice);
        while(adj.hasNext()){
            Integer vertAdj = adj.next();
            if(recorrido.get(vertAdj).getColor() == "blanco"){
                dfgVisit(grafito, vertAdj);
            }
        }
        recorrido.get(vertice).setColor("negro");
        this.tiempo +=1;
        recorrido.get(vertice).setTiempoFinal(tiempo);

    }
}
