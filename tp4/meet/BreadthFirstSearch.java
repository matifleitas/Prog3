package meet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    private Queue<Integer> cola;
    private HashMap<Integer, Boolean> visitado;

    public BreadthFirstSearch() {
        this.cola = new LinkedList<>();
        this.visitado = new HashMap<Integer, Boolean>();
    }

    public void inicializar(Grafo grafito,Iterator<Integer> listVertices){
        while(listVertices.hasNext()){
            Integer vertice = listVertices.next();
            visitado.put(vertice,false);
        }
    }

    public void bfs (Grafo grafito){
        Iterator<Integer> listVertices = grafito.obtenerVertices();
        inicializar(grafito,listVertices);

        while (listVertices.hasNext()){
            Integer vertice = listVertices.next();
            if(!visitado.get(vertice)){
                bfs(grafito,vertice);
            }
        }
    }

    private void bfs(Grafo grafito, Integer vertice){
        visitado.replace(vertice,true);
        cola.add(vertice);
        while(!cola.isEmpty()){
            Integer vert = cola.poll();
            Iterator<Integer> adj = grafito.obtenerAdyacentes(vert);
            while(adj.hasNext()){
                Integer verticeAdj = adj.next();
                if(!visitado.get(verticeAdj)){
                    visitado.replace(verticeAdj,true);
                    cola.add(verticeAdj);
                }
            }
        }
    }

}