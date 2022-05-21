/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package txt;

/**
 *
 * @author Abril
 */
public class Lista {
    private Nodo cabeza;
    private int len;
    
    public Lista(){
        this.cabeza = null;
        this.len = 0;
    }
    
    public Lista(Nodo cabeza){
        this.cabeza = cabeza;
        this.len = 1;
    }
    

    
    //Metodos de la lista
    
    public boolean vacia(){
        return (getCabeza() == null);
        
    }
        
    public Nodo getCabeza(){
        return this.cabeza;
    }
    
    public void setCabeza(Nodo cabeza){
        this.cabeza = cabeza;
    }
    
    public int getLen(){
        return this.len;
    }
    
    public void setLen(int len){
        this.len = len;
    }
    
    
    public void insertarInicio(Object elemento, Object cedula){
        Nodo nodo = new Nodo(elemento, cedula);
        if(vacia()){
            setCabeza(nodo);
        }else{
            nodo.setSiguiente(getCabeza());
            setCabeza(nodo);
        }
        len++;
    }
    
    public void insertarFinal(Object elemento, Object cedula){
        Nodo nodo = new Nodo(elemento, cedula);
        if(vacia()){
            setCabeza(nodo);
        }else{
            Nodo pointer = getCabeza();
            for (int i = 0; i < (getLen() - 1); i++){
                pointer = pointer.getSiguiente();
            }
            pointer.setSiguiente(nodo);
        }
        len++;
    }
    
    public void insertarPosicion(Object elemento, Object cedula, int posicion){
        
        if (posicion == 0){
            insertarInicio(elemento, cedula);
        }else if(posicion == (len +1)){
            insertarFinal(elemento, cedula);
        }else{
            Nodo nodo = new Nodo(elemento, cedula);
            if(vacia()){
            setCabeza(nodo);
            }else{

                int count = 0;
                Nodo pointer = getCabeza();
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
            Nodo pointer = getCabeza();
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
            Nodo pointer = getCabeza();
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
            Nodo pointer = getCabeza();
            int count = 0;
            while(count < (posicion - 1)){
                pointer = pointer.getSiguiente();
                count++;
            }
            Nodo temp = pointer.getSiguiente();
            pointer.setSiguiente(temp.getSiguiente());
            temp.setSiguiente(null); 
            len -=1;
        }
    }
    
    public Nodo buscarNodo(int index){
        int count = 0;
        Nodo pointer = getCabeza();
        while(count != index){
            pointer = pointer.getSiguiente();
            count++;
        }
        
        return pointer;
        
    }
}        
