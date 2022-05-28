
package proyecto;

public class Proyecto {

    public static void main(String[] args) {
        txt t = new txt();
        Grafo grafo = t.readTxt();
        grafo.readRoutes();
        for (int i = 0; i < grafo.getVertices().getLength() -1; i++){
            for (int j = 0; j < grafo.getVertices().getLength() -1; j++){
                System.out.print(grafo.getMatriz()[i][j]);
            }
            System.out.println("");
        }
    }
    
}
