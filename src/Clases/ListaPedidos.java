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
public class ListaPedidos {
    private NodoPedido primero;
    private NodoPedido ultimo;
    private int tamano;
    
    /**
     * Constructor de la clase LsitaPedidos
     */
    public ListaPedidos(){
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
     * Método que agrega un nuevo elemento al final de la lista
     * @param pedido El parámetro pedido define el elemento que desea agregar el usuario
     */
    public void agregar_al_final(NodoPedido pedido){
        if(this.esta_vacia()){
            primero = ultimo = pedido;
        }else{
            ultimo.setSiguiente(pedido);
            pedido.setAnterior(ultimo);
            ultimo = pedido;
        }
        tamano ++;
    }
    
    /**
     * Método que imprime la lista creada
     */
    public void imprimir(){
        if(esta_vacia()){
            JOptionPane.showMessageDialog(null, "La lista esta vacia.");
        }else{
            NodoPedido temporal;
             temporal = getPrimero();
            String mostrar_completo = "";
            for (int i = 0; i < getTamano(); i ++){
                mostrar_completo += temporal.getCliente() + "," + temporal.getRestaurant() + "," + temporal.getOrden() + "\n";
                temporal = temporal.getSiguiente();
            }
            JOptionPane.showMessageDialog(null,mostrar_completo);
        }
    }
    
    /**
     * Método que busca un elemento en la lista
     * @param cliente el parámetro cliente define el nombre del cliente que realizó el pedido
     * @param restaurant El parámetro restaurante defina el restaurante al cual el cliente le hizo el pedido
     * @param orden El parámetro orden define el plato escogido por el cliente
     * @return Retorna null si no encuentra el pedido
     */
    public NodoPedido buscarPedido(String cliente, String restaurant, String orden){
        NodoPedido pedido = primero;
        while(pedido != null){
            if(pedido.getCliente().equals(cliente) && pedido.getRestaurant().equals(restaurant) && pedido.getOrden().equals(orden)){
                return pedido;
            }
            pedido = pedido.getSiguiente();
        }
        return null;
    } 
    
    /**
     * Metódo que elimina todos los elementos de la lista
     */
    public void vaciar(){
        this.setPrimero(ultimo = null);
        this.setTamano(0);
        
    }
    
    /**
     * Método que elimina un elemento
     * @param pedido El parámetro pedido define el pedido que se desea eliminar
     */
    public void eliminarPedido(NodoPedido pedido){
        if (pedido != null){
            if (tamano == 1 ){
                this.vaciar();
            }else{
                if(primero == pedido){
                    primero = primero.getSiguiente();
                    primero.setAnterior(null);
                }else if(ultimo == pedido){
                    ultimo = ultimo.getAnterior();
                    ultimo.setSiguiente(null);
                }else{
                    pedido.getAnterior().setSiguiente(pedido.getSiguiente());
                    pedido.getSiguiente().setAnterior(pedido.getAnterior());
                }
                tamano --;
            }
        }
        
    }
    

    /**
     * @return the primero
     */
    public NodoPedido getPrimero() {
        return primero;
    }

    /**
     * @param primero the primero to set
     */
    public void setPrimero(NodoPedido primero) {
        this.primero = primero;
    }

    /**
     * @return the ultimo
     */
    public NodoPedido getUltimo() {
        return ultimo;
    }

    /**
     * @param ultimo the ultimo to set
     */
    public void setUltimo(NodoPedido ultimo) {
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
