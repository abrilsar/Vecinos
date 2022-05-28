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
public class GrupoListas {
    private ListaCliente clientes;
    private ListaRestaurant restaurantes;
    private ListaPedidos pedidos;
    private ListaRutas rutas;
    
    /**
     * Constructor de la clase GrupoListas
     * @param clientes El parámetro clientes define el listado de clientes
     * @param restaurantes El parámetro restaurantes define el lista de restaurantes
     * @param pedidos El parámetro pedidos define el listado de pedidos
     * @param rutas El parámetro rutas define el listado de rutas
     */
    
    public GrupoListas(ListaCliente clientes, ListaRestaurant restaurantes, ListaPedidos pedidos, ListaRutas rutas){
        this.clientes = clientes;
        this.restaurantes = restaurantes;
        this.pedidos = pedidos;
        this.rutas = rutas;
        
    }

    /**
     * @return the restaurantes
     */
    public ListaRestaurant getRestaurantes() {
        return restaurantes;
    }

    /**
     * @param restaurantes the restaurantes to set
     */
    public void setRestaurantes(ListaRestaurant restaurantes) {
        this.restaurantes = restaurantes;
    }

    /**
     * @return the pedidos
     */
    public ListaPedidos getPedidos() {
        return pedidos;
    }

    /**
     * @param pedidos the pedidos to set
     */
    public void setPedidos(ListaPedidos pedidos) {
        this.pedidos = pedidos;
    }


    /**
     * @return the clientes
     */
    public ListaCliente getClientes() {
        return clientes;
    }

    /**
     * @param clientes the clientes to set
     */
    public void setClientes(ListaCliente clientes) {
        this.clientes = clientes;
    }

    /**
     * @return the rutas
     */
    public ListaRutas getRutas() {
        return rutas;
    }

    /**
     * @param rutas the rutas to set
     */
    public void setRutas(ListaRutas rutas) {
        this.rutas = rutas;
    }
}
