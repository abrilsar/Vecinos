
package asociasiovecinos;

public class ListaApartamento {
    private NodoApartamento cabeza;
    private int len;
    
    public ListaApartamento(){
        this.cabeza = null;
        this.len = 0;
    }
    
    public boolean vacia(){
        return (this.cabeza == null);  
    }
        
    public NodoApartamento getCabeza(){
        return this.cabeza;
    }
    
    public void setCabeza(NodoApartamento cabeza){
        this.cabeza = cabeza;
    }
    
    public int getLen(){
        return this.len;
    }
    
    public void setLen(int len){
        this.len = len;
    }
    
    
    public void insertarInicio(int elemento){
        NodoApartamento nodo = new NodoApartamento(elemento);
        if(vacia()){
            setCabeza(nodo);
        }else{
            nodo.setSiguiente(getCabeza());
            setCabeza(nodo);
        }
        len++;
    }
    
    public void insertarFinal(int elemento){
        NodoApartamento nodo = new NodoApartamento(elemento);
        if(vacia()){
            setCabeza(nodo);
        }else{
            NodoApartamento pointer = getCabeza();
            for (int i = 0; i < (getLen() - 1); i++){
                pointer = pointer.getSiguiente();
            }
            pointer.setSiguiente(nodo);
        }
        len++;
    }
    
    public void insertarPosicion(int elemento, int posicion){
        
        if (posicion == 0){
            insertarInicio(elemento);
        }else if(posicion == (len +1)){
            insertarFinal(elemento);
        }else{
            NodoApartamento nodo = new NodoApartamento(elemento);
            if(vacia()){
            setCabeza(nodo);
            }else{

                int count = 0;
                NodoApartamento pointer = getCabeza();
                while(count < (posicion - 1)){
                    pointer = pointer.getSiguiente();
                    count++;
                }
                nodo.setSiguiente(pointer.getSiguiente());
                pointer.setSiguiente(nodo);
            }
            len++;
            }
    }
    
    public void eliminarUltimo(){
        if (vacia()){
            System.out.println("No hay elementos en la lista");
        }else{
            NodoApartamento pointer = getCabeza();
            while(pointer.getSiguiente().getSiguiente() != null){
                pointer = pointer.getSiguiente();
            }
            pointer.setSiguiente(null);
           
            len -= 1;         
        }
        
    }
    
    public void eliminarInicio(){
        if (vacia()){
            System.out.println("No hay elementos en la lista");
        }else{
            NodoApartamento pointer = getCabeza();
            setCabeza(pointer.getSiguiente());
            pointer.setSiguiente(null);
            len -=1;
           }  
    }
    
    public void eliminarPosicion(int posicion){
        if(posicion == 0){
            eliminarInicio();
        }else if(posicion == len){
            eliminarUltimo();
        }else{
            NodoApartamento pointer = getCabeza();
            int count = 0;
            while(count < (posicion - 1)){
                pointer = pointer.getSiguiente();
                count++;
            }
            NodoApartamento temp = pointer.getSiguiente();
            pointer.setSiguiente(temp.getSiguiente());
            temp.setSiguiente(null); 
            len -=1;
        }
    }
    
    public NodoApartamento buscarNodo(int index){
        if (vacia()){
            return null;
        }else{
            int count = 0;
            NodoApartamento pointer = getCabeza();
            while(count < index && pointer.getSiguiente() != null){
                pointer = pointer.getSiguiente();
                count++;
            }
            if (count == index){
                return pointer;
            }else{
                return null;
            }
        }
    }
    
    public void imprimir(){
        NodoApartamento pointer = this.getCabeza();
        for(int i = 0; i < this.getLen(); i++){
            System.out.println(pointer.getNumero());
            pointer = pointer.getSiguiente();
        }
    }
}
