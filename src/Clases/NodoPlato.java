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
public class NodoPlato {
    private NodoPlato siguiente;
    private NodoPlato anterior;
    private String platillo;
    private int identificador;
    
    /**
     * Constructor de la clase NodoPlato
     * @param platillo El parámetro platillo define la comida escogida por el usuario
     */
    public NodoPlato(String platillo){
        this.siguiente = null;
        this.platillo = platillo;
    }

    /**
     * @return the siguiente
     */
    public NodoPlato getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(NodoPlato siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * @return the platillo
     */
    public String getPlatillo() {
        return platillo;
    }

    /**
     * @param platillo the platillo to set
     */
    public void setPlatillo(String platillo) {
        this.platillo = platillo;
    }

    /**
     * @return the anterior
     */
    public NodoPlato getAnterior() {
        return anterior;
    }

    /**
     * @param anterior the anterior to set
     */
    public void setAnterior(NodoPlato anterior) {
        this.anterior = anterior;
    }

    /**
     * @return the identificador
     */
    public int getIdentificador() {
        return identificador;
    }

    /**
     * @param identificador the identificador to set
     */
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    @Override
    public String toString() {
        return platillo;
    }
}
