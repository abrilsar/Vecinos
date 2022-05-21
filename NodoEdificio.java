
package asociasiovecinos;

public class NodoEdificio {
    private String name;
    private NodoEdificio siguiente; 
    private ListaApartamento apartamento;
    
    //Constructor
    public NodoEdificio(String name){
        this.name = name;
        this.siguiente = null;
        this.apartamento = null;
    }

    
    //Constructor para insertar al principio
    
    public NodoEdificio getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoEdificio siguiente) {
        this.siguiente = siguiente;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
