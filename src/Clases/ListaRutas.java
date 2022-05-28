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
public class ListaRutas {
    private NodoRuta primero;
    private NodoRuta ultimo;
    private int tamano;
    
    public ListaRutas(){
        this.primero = null;
        this.ultimo = null;
        this.tamano = 0;
    }
    
    public boolean esta_vacia(){
        return getPrimero() == null;
    }
    
    /**
     * Método que agrega un nuevo elemento al principio de la lista
     * @param restaurant El parámetro restaurante define el elemento que desea agregar el usuario
     */
    public void agregar_al_inicio(NodoRuta ruta){
        if(esta_vacia()){
            setPrimero(ruta);
            setUltimo(ruta);
        }else{
            ruta.setSiguiente(getPrimero());
            setPrimero(ruta);
        }
        setTamano(getTamano() + 1);
    }
    
    /**
     * Método que agrega un nuevo elemento al final de la lista
     * @param restaurant El parámetro restaurante define el elemento que desea agregar el usuario
     */
    public void agregar_al_final(NodoRuta ruta){
        if(esta_vacia()){
            agregar_al_inicio(ruta);
        }else{
            getUltimo().setSiguiente(ruta);
            setUltimo(ruta);
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
            NodoRuta temporal;
            temporal = getPrimero();
            String mostrar_completo = "";
            for (int i = 0; i < getTamano(); i ++){
                mostrar_completo += temporal.getOrigen() + "," + temporal.getDestino() + "," + temporal.getDistancia() + "\n";
                temporal = temporal.getSiguiente();
            }
            JOptionPane.showMessageDialog(null,mostrar_completo);
        }
    }

    /**
     * @return the primero
     */
    public NodoRuta getPrimero() {
        return primero;
    }

    /**
     * @param primero the primero to set
     */
    public void setPrimero(NodoRuta primero) {
        this.primero = primero;
    }

    /**
     * @return the ultimo
     */
    public NodoRuta getUltimo() {
        return ultimo;
    }

    /**
     * @param ultimo the ultimo to set
     */
    public void setUltimo(NodoRuta ultimo) {
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
