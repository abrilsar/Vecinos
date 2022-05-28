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
public class ListaCliente {
    private NodoCliente primero;
    private NodoCliente ultimo;
    private int tamano;
    
    /**
     * Constructor de la clase ListaCliente
     */
    public ListaCliente(){
        this.primero = null;
        this.ultimo = null;
        this.tamano = 0;
    }
    
    /**
     * Método que determina si la lista está vacía
     * @return Retorna null si la lista está vacía
     */
    public boolean esta_vacia(){
        return getPrimero() == null;
    }
    
    /**
     * Método que agregar un nuevo elemento al principio de la lista
     * @param cliente El parámetro cliente define el elemento que desea agregar el usuario
     */
    public void agregar_al_inicio(NodoCliente cliente){
        if(esta_vacia()){
            setPrimero(cliente);
            setUltimo(cliente);
        }else{
            cliente.setSiguiente(getPrimero());
            setPrimero(cliente);
        }
        setTamano(getTamano() + 1);
    }
    
    /**
     * Método que agrega un nuevo elemento el final de la lista
     * @param cliente El parámetro cliente define el elemento que desea agregar el usuario
     */
    public void agregar_al_final(NodoCliente cliente){
        if(esta_vacia()){
            agregar_al_inicio(cliente);
        }else{
            getUltimo().setSiguiente(cliente);
            setUltimo(cliente);
            setTamano(getTamano() + 1);
        }
    }
    
    /**
     *Método que imprime la lista creada
     */
    public void imprimir(){
        if(esta_vacia()){
            JOptionPane.showMessageDialog(null, "La lista esta vacia.");
        }else{
            NodoCliente temporal;
            temporal = getPrimero();
            String mostrar_completo = "";
            for (int i = 0; i < getTamano(); i ++){
                mostrar_completo += temporal.getNombre() + "," + temporal.getApellido() + "," + temporal.getCedula() + "\n";
                temporal = temporal.getSiguiente();
            }
            JOptionPane.showMessageDialog(null,mostrar_completo);
        }
    }

    /**
     * @return the primero
     */
    public NodoCliente getPrimero() {
        return primero;
    }

    /**
     * @param primero the primero to set
     */
    public void setPrimero(NodoCliente primero) {
        this.primero = primero;
    }

    /**
     * @return the ultimo
     */
    public NodoCliente getUltimo() {
        return ultimo;
    }

    /**
     * @param ultimo the ultimo to set
     */
    public void setUltimo(NodoCliente ultimo) {
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

    public boolean existePorCedula(int cedula) {
        NodoCliente temp = primero;
        boolean encontrado = false;
        
        if (!esta_vacia()) {            
            while (!encontrado && temp != null) {
                if (temp.getCedula() == cedula) {
                    encontrado = true;
                } else {
                    temp = temp.getSiguiente();
                }
            }
        }
        
        return encontrado;
    }
    
    public NodoCliente buscarCliente(int identificacion) {
        NodoCliente cliente = primero;
        while(cliente != null){
            if(cliente.getIdentificador() == identificacion){
                return cliente;
            }
            cliente = cliente.getSiguiente();
        }
        return null;
    }
    
//    public NodoCliente buscarPorNombre(String nombreCompleto) {
//        
//    }
}
