
package proyecto;

public class Proyecto {

    public static void main(String[] args) {
        txt t = new txt();
        Grafo grafo = t.readTxt();
        grafo.readRoutes();
        grafo.printMatrix();
        System.out.println("-=============");
        grafo.bfs(2);
        System.out.println("---------------");
        grafo.dfs(2, grafo.createListVisited());
    }
    
}
