
package asociasiovecinos;

public class ListaEdificio {
    private NodoEdificio cabeza;
    private int len;
    
    public ListaEdificio(){
        this.cabeza = null;
        this.len = 0;
    }
    
    public boolean vacia(){
        return (this.cabeza == null);  
    }
        
    public NodoEdificio getCabeza(){
        return this.cabeza;
    }
    
    public void setCabeza(NodoEdificio cabeza){
        this.cabeza = cabeza;
    }
    
    public int getLen(){
        return this.len;
    }
    
    public void setLen(int len){
        this.len = len;
    }
    
    
    public void insertarInicio(String elemento){
        NodoEdificio nodo = new NodoEdificio(elemento);
        if(vacia()){
            setCabeza(nodo);
        }else{
            nodo.setSiguiente(getCabeza());
            setCabeza(nodo);
        }
        len++;
    }
    
    public void insertarFinal(String elemento){
        NodoEdificio nodo = new NodoEdificio(elemento);
        if(vacia()){
            setCabeza(nodo);
        }else{
            NodoEdificio pointer = getCabeza();
            for (int i = 0; i < (getLen() - 1); i++){
                pointer = pointer.getSiguiente();
            }
            pointer.setSiguiente(nodo);
        }
        len++;
    }
    
    public void insertarPosicion(String elemento, int posicion){
        
        if (posicion == 0){
            insertarInicio(elemento);
        }else if(posicion == (len +1)){
            insertarFinal(elemento);
        }else{
            NodoEdificio nodo = new NodoEdificio(elemento);
            if(vacia()){
            setCabeza(nodo);
            }else{

                int count = 0;
                NodoEdificio pointer = getCabeza();
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
            NodoEdificio pointer = getCabeza();
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
            NodoEdificio pointer = getCabeza();
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
            NodoEdificio pointer = getCabeza();
            int count = 0;
            while(count < (posicion - 1)){
                pointer = pointer.getSiguiente();
                count++;
            }
            NodoEdificio temp = pointer.getSiguiente();
            pointer.setSiguiente(temp.getSiguiente());
            temp.setSiguiente(null); 
            len -=1;
        }
    }
    
    public NodoEdificio buscarNodo(int index){
        if (vacia()){
            return null;
        }else{
            int count = 0;
            NodoEdificio pointer = getCabeza();
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
    
    public void imprimir(ListaEdificio lista){
        NodoEdificio pointer = lista.getCabeza();
        for(int i = 0; i < lista.getLen(); i++){
            System.out.println(pointer.getName());
            pointer = pointer.getSiguiente();
        }
    }
}
