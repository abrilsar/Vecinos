
package proyecto;
    
    
public class Grafo {
    private List<Storage> vertices;
    private int[][] matriz;
    private int nVertices;
    private int maxVertices;
    private String[] routes;
    
    public Grafo(int max, List<Storage> storage, String[] routes){
        this.vertices =  storage;
        this.nVertices = storage.getLength();
        this.maxVertices = max;
        this.routes = routes;
        this.matriz = new int[max][max];
        for (int i = 0; i< max; i++){
            for (int j = 0; j< max; j++){
                this.matriz[i][j] = 0;
            }
        }
    }

    public List<Storage> getVertices() {
        return vertices;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public int getnVertices() {
        return nVertices;
    }

    public int getMaxVertices() {
        return maxVertices;
    }
       

    public String[] getRoutes() {
        return routes;
    }

    public void setVertices(List<Storage> vertices) {
        this.vertices = vertices;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

    public void setnVertices(int nVertices) {
        this.nVertices = nVertices;
    }

    public void setMaxVertices(int maxVertices) {
        this.maxVertices = maxVertices;
    }

    public void setRoutes(String[] routes) {
        this.routes = routes;
    }
    
    

    public void readRoutes(){
        String[] names = new String[nVertices];  /// revisar si es con max o con num
        for(int i = 0; i < (vertices.getLength()); i++){
            names[i] = vertices.getElement(i).getName();
        }

        for (int i=1; i< routes.length; i++){
            String[] temp = routes[i].split(",");
            int a = getIndex(names,temp[0]);
            int b = getIndex(names,temp[1]);
            System.out.println("Index 1: " + a + " Index 2: " + b);
            if (a != -1 && b != -1){
                matriz[a][b] = Integer.valueOf(temp[temp.length - 1]);
            }
            
        }
            
    }
    
    public int getIndex(String[] name, String word){
        for(int i = 0; i < name.length; i++){
            if(name[i].equals(word)){
                return i;
            }
        }
        return -1;
    }

    public void printMatrix(){
        for (int i = 0; i < nVertices; i++){
            for (int j = 0; j < nVertices; j++){
                System.out.print(matriz[i][j]);
            }
            System.out.println("");
        }
    }
}
    