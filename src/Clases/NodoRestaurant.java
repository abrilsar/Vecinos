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
public class NodoRestaurant {
    private NodoRestaurant siguiente;
    private String letra;
    private String nombre;
    private ListaMenu menu;
    
    /**
     * Constructor de la clase NodoRestaurant
     * @param letra El parámetro letra define el identificardor del restaurante 
     * escogido por el usuario
     * @param nombre El parámetro nombre define el nombre del restaurante escogido
     * por el usuario
     * @param menu El parámetro menu define el platillo que ofrece el restaurante
     */
    public NodoRestaurant(String letra, String nombre, ListaMenu menu){
        this.siguiente = null;
        this.letra = letra;
        this.nombre = nombre;
        this.menu = menu;
    }

    /**
     * @return the siguiente
     */
    public NodoRestaurant getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(NodoRestaurant siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * @return the letra
     */
    public String getLetra() {
        return letra;
    }

    /**
     * @param letra the letra to set
     */
    public void setLetra(String letra) {
        this.letra = letra;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the menu
     */
    public ListaMenu getMenu() {
        return menu;
    }

    /**
     * @param menu the menu to set
     */
    public void setMenu(ListaMenu menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
