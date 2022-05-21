
package asociasiovecinos;

class ListaHabitantes {
    private NodoVecino cabeza;
    private int len;
    
    public ListaHabitantes(){
        this.cabeza = null;
        this.len = 0;
    }
    
    public boolean vacia(){
        return (this.cabeza == null);  
    }
        
    public NodoVecino getCabeza(){
        return this.cabeza;
    }
    
    public void setCabeza(NodoVecino cabeza){
        this.cabeza = cabeza;
    }
    
    public int getLen(){
        return this.len;
    }
    
    public void setLen(int len){
        this.len = len;
    }
    
    
    public void insertarInicio(String name, int cedula, int phone){
        NodoVecino nodo = new NodoVecino(name, cedula, phone);
        if(vacia()){
            setCabeza(nodo);
        }else{
            nodo.setSiguiente(getCabeza());
            setCabeza(nodo);
        }
        len++;
    }
    
    public void insertarFinal(String name, int cedula, int phone){
        NodoVecino nodo = new NodoVecino(name, cedula, phone);
        if(vacia()){
            setCabeza(nodo);
        }else{
            NodoVecino pointer = getCabeza();
            for (int i = 0; i < (getLen() - 1); i++){
                pointer = pointer.getSiguiente();
            }
            pointer.setSiguiente(nodo);
        }
        len++;
    }
    
    public void insertarPosicion(String name, int cedula, int phone, int posicion){
        
        if (posicion == 0){
            insertarInicio(name, cedula, phone);
        }else if(posicion == (len +1)){
            insertarFinal(name, cedula, phone);
        }else{
            NodoVecino nodo = new NodoVecino(name, cedula, phone);
            if(vacia()){
            setCabeza(nodo);
            }else{

                int count = 0;
                NodoVecino pointer = getCabeza();
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
            NodoVecino pointer = getCabeza();
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
            NodoVecino pointer = getCabeza();
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
            NodoVecino pointer = getCabeza();
            int count = 0;
            while(count < (posicion - 1)){
                pointer = pointer.getSiguiente();
                count++;
            }
            NodoVecino temp = pointer.getSiguiente();
            pointer.setSiguiente(temp.getSiguiente());
            temp.setSiguiente(null); 
            len -=1;
        }
    }
    
    public NodoVecino buscarNodo(int index){
        if (vacia()){
            return null;
        }else{
            int count = 0;
            NodoVecino pointer = getCabeza();
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
        NodoVecino pointer = this.getCabeza();
        for(int i = 0; i < this.getLen(); i++){
            System.out.println(pointer.getCedula());
            pointer = pointer.getSiguiente();
        }
    }   
}
