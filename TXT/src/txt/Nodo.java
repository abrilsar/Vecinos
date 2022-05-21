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
public class Nodo {
    //Atributos
    private Object elemento;
    private Object dni;
    private Nodo siguiente; //Puntero
    
    //Constructor
    public Nodo(Object elemento, Object dni){
        this.elemento = elemento;
        this.siguiente = null;
        this.dni = dni;
    }
    
    //Constructor para insertar al principio
    public Nodo(Object elemento , Nodo siguiente){
        this.elemento = elemento;
        this.siguiente = siguiente;
    }
    
    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public Object getDni() {
        return dni;
    }

    public void setDni(Object dni) {
        this.dni = dni;
    }
    
    
    
}
