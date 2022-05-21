
package servicioacme;


public class Nodo {
    private Nodo siguiente;
    private Nodo anterior;
    private Object elemento;
    
    public Nodo(Object elemento){
        this.siguiente = this;
        this.anterior = this;
        this.elemento = elemento;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }
    
    
}
