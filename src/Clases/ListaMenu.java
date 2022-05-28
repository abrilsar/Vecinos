/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import javax.swing.JOptionPane;

/**
 *
 * @author SebasBD
 */
public class ListaMenu {
    private NodoPlato primero;
    private NodoPlato ultimo;
    private int tamano;
    
    /**
     * Constructor de la clase ListaMenu
     */
    public ListaMenu(){
        this.primero = null;
        this.ultimo = null;
        this.tamano = 0;   
    }
    
    /**
     * Método que determina si la lista está vacía
     * @return Retorna null en el nodo primero si la lista está vacía
     */
    public boolean esta_vacia(){
        return getPrimero() == null;
    }
    
    /**
     * Metódo que elimina todos los elementos de la lista
     */
    public void vaciar(){
        this.setPrimero(ultimo = null);
        this.setTamano(0);
        
    }
    
    /**
     * Método que agregar un nuevo elemento al final de la lista
     * @param plato El parámetro plato define el elemento que desea agregar el usuario
     */
    public void agregar_al_final(NodoPlato plato){
        if(this.esta_vacia()){
            primero = ultimo = plato;
        }else{
            ultimo.setSiguiente(plato);
            plato.setAnterior(ultimo);
            ultimo = plato;
        }
        tamano ++;
        plato.setIdentificador(tamano); 
    }
    
    /**
     * Método que busca un elemento de la lista
     * @param identificador El parámetro identificador define el ID del plato que desea buscar
     * @return Retorna null si el plato no es contrado
     */
    public NodoPlato buscarPlato(int identificador){
        NodoPlato plato = primero;
        while(plato != null){
            if(plato.getIdentificador() == identificador){
                return plato;
            }
            plato = plato.getSiguiente();
        }
        return null;
    } 
    
    /**
     * Método que elimina un elemento
     * @param plato El parámetro plato define el plato que se desea eliminar
     */
    public void eliminarPlato(NodoPlato plato){
        if (plato != null){
            if (tamano == 1 ){
                this.vaciar();
            }else{
                if(primero == plato){
                    primero = primero.getSiguiente();
                    primero.setAnterior(null);
                }else if(ultimo == plato){
                    ultimo = ultimo.getAnterior();
                    ultimo.setSiguiente(null);
                }else{
                    plato.getAnterior().setSiguiente(plato.getSiguiente());
                    plato.getSiguiente().setAnterior(plato.getAnterior());
                }
                tamano --;
            }
        }
        
    }
    
    /**
     * Método que imprime la lista creada
     */
    public String imprimir(){
        String mostrar_completo = "";
        if(esta_vacia()){
            JOptionPane.showMessageDialog(null,"La lista esta vacia.");
        }else{
            NodoPlato temporal;
            temporal = getPrimero();
            for (int i = 0; i < getTamano(); i ++){
               mostrar_completo += temporal.getIdentificador() + ":" + temporal.getPlatillo() + "/";
               temporal = temporal.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, mostrar_completo);
        }
        return mostrar_completo;
    }

    /**
     * @return the primero
     */
    public NodoPlato getPrimero() {
        return primero;
    }

    /**
     * @param primero the primero to set
     */
    public void setPrimero(NodoPlato primero) {
        this.primero = primero;
    }

    /**
     * @return the ultimo
     */
    public NodoPlato getUltimo() {
        return ultimo;
    }

    /**
     * @param ultimo the ultimo to set
     */
    public void setUltimo(NodoPlato ultimo) {
        this.ultimo = ultimo;
    }

    /**
     * @return the tamano
     */
    public int getTamano() {
        return tamano;
    }

    /**
     * @param tamano the tamano to set
     */
    public void setTamano(int tamano) {
        this.tamano = tamano;
    }
    
}
