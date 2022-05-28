/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author SebasBD
 */
public class NodoPedido {
    private NodoPedido siguiente;
    private NodoPedido anterior;
    private String cliente;
    private String restaurant;
    private String orden;
    
    /**
     * Constructor de la clase NodoPedido
     * @param cliente El parámetro cliente define el cliente que ha realizado el pedido
     * @param restaurant El parámetro restaurant define el restaurante escogido por 
     * el usuario 
     * @param orden El parámetro orden define el plato escogido por el usuario
     */
    public NodoPedido(String cliente, String restaurant, String orden){
        this.siguiente = null;
        this.cliente = cliente;
        this.restaurant = restaurant;
        this.orden = orden;
        
    }

    /**
     * @return the siguiente
     */
    public NodoPedido getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(NodoPedido siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * @return the cliente
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the restaurant
     */
    public String getRestaurant() {
        return restaurant;
    }

    /**
     * @param restaurant the restaurant to set
     */
    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    /**
     * @return the orden
     */
    public String getOrden() {
        return orden;
    }

    /**
     * @param orden the orden to set
     */
    public void setOrden(String orden) {
        this.orden = orden;
    }

    /**
     * @return the anterior
     */
    public NodoPedido getAnterior() {
        return anterior;
    }

    /**
     * @param anterior the anterior to set
     */
    public void setAnterior(NodoPedido anterior) {
        this.anterior = anterior;
    }
    
}
