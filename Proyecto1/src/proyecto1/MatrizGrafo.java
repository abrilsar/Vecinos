
package proyecto1;

public class MatrizGrafo {
    int nVertices;
    int maxVertices;
    int[][] matriz; 
    Vertice [] vertices;

    public MatrizGrafo(int max) {
        this.nVertices = 0;
        this.maxVertices = max;
        this.matriz = new int[max][max];
        this.vertices = new Vertice[max];
        for (int i = 0; i< max; i++){
            for (int j = 0; j< max; j++){
                this.matriz[i][j] = 0;
            }
        }
    }
    
    
    
}
