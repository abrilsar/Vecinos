
package asociasiovecinos;

public class NodoApartamento {
    private int numero;
    private ListaHabitantes habitantes; 
    private NodoApartamento siguiente;
    private NodoEdificio edificio;

   
    //Constructor
    public NodoApartamento (int numero){
        this.numero = numero;
        this.siguiente = null;
        this.edificio = null;
        this.habitantes = new ListaHabitantes();
    }

    
    //Constructor para insertar al principio

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public ListaHabitantes getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(ListaHabitantes habitantes) {
        this.habitantes = habitantes;
    }

    public NodoApartamento getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoApartamento siguiente) {
        this.siguiente = siguiente;
    }

    public NodoEdificio getEdificio() {
        return edificio;
    }

    public void setEdificio(NodoEdificio edificio) {
        this.edificio = edificio;
    }

    
   
}
