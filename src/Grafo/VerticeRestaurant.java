/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import Clases.NodoRestaurant;
import java.awt.Color;

/**
 *
 * @author s_ant
 */
public class VerticeRestaurant extends Vertice {
    
    private NodoRestaurant restaurant;
    
    public VerticeRestaurant(String etiqueta) {
        super(etiqueta);
    }

    public VerticeRestaurant(NodoRestaurant restaurant) {
        super(restaurant.getLetra(), restaurant.getNombre());
        this.restaurant = restaurant;
    }

    public NodoRestaurant restaurant() {
        return restaurant;
    }

    /**
     * Método que define la información de los restaurantes
     */
    public void setRestaurante(NodoRestaurant restaurant) {
        this.restaurant = restaurant;
    }

    /**
     * Método que obtiene la información de los restaurantes
     */
    public NodoRestaurant getRestaurant() {
        return restaurant;
    }
    
    @Override
    public Color getColorPreferencia() {
        return new Color(143, 220, 180);
    }
}
