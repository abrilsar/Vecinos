
package servicioacme;

public class ListaCircularDoble {
    private Nodo ultimo;
    private int len;
    
    public ListaCircularDoble(){
        this.ultimo = null;
        this.len = 0;
    }

    public Nodo getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }
    
    public boolean vacia(){
        return (getUltimo() == null);
    }
    
    public void inserta(Object elemento){
        Nodo nodo = new Nodo(elemento);
        if(vacia()){
            setUltimo(nodo);
        }else{
            Nodo pointer = getUltimo();
            nodo.setSiguiente(pointer.getSiguiente());
            nodo.setAnterior(pointer);
            pointer.getSiguiente().setAnterior(nodo);
            pointer.setSiguiente(nodo);
            setUltimo(nodo);
        }
        
        len++;
    }
    
    public Nodo getNodo(int index){
        if(vacia()){
            return null;
        }else{
            int count = 0;
            Nodo pointer = getUltimo().getSiguiente();
            while(count < index && pointer.getSiguiente() != getUltimo().getSiguiente()){
                pointer = pointer.getSiguiente();
                count++;
            }
            if(count == index){
                return pointer;
            }else{
                return null;
            }
        }
    }
}
