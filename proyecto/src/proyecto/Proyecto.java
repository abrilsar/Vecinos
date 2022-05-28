
package proyecto;

public class Proyecto {

    public static void main(String[] args) {
        txt t = new txt();
        Grafo grafo = t.readTxt();
        grafo.readRoutes();
        grafo.printMatrix();
    }
    
}
