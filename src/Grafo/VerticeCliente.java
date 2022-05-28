/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import Clases.NodoCliente;
import java.awt.Color;

/**
 *
 * @author s_ant
 */
public class VerticeCliente extends Vertice {   
    
    private NodoCliente cliente;
    
    /**
     * 
     */
    public VerticeCliente(String etiqueta) {
        super(etiqueta);
    }

    /**
     * 
     */
    public VerticeCliente(NodoCliente cliente) {
        super(String.valueOf(cliente.getIdentificador()), cliente.getNombre() + " " + cliente.getApellido());
        this.cliente = cliente;
    }

    /**
     * Método que obtiene la información del cliente
     */
    public NodoCliente getCliente() {
        return cliente;
    }

    /**
     * Método que define la información del cliente
     */
    public void setCliente(NodoCliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public Color getColorPreferencia() {
        return new Color(96, 148, 254);
    }
}
