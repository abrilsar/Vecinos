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
public class NodoCliente {
    private NodoCliente siguiente;
    private int identificador;
    private String nombre;
    private String apellido;
    private int cedula;
    
    /**
     * Constructor de la clase NodoCliente
     * @param identificador El parámetro identificador defina el ID del usuario 
     * @param nombre El parámetro nombre define el nombre del usuario
     * @param apellidoEl parámetro nombre define el apellido del usuario
     * @param cedula El parámetro cedula define el número de cédula del usuario
     */
    public NodoCliente(int identificador, String nombre, String apellido, int cedula){
        this.identificador = identificador;
        this.siguiente = null;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
    }

    /**
     * @return the siguiente
     */
    public NodoCliente getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(NodoCliente siguiente) {
        this.siguiente = siguiente;
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
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the cedula
     */
    public int getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(int cedula) {
        this.cedula = cedula;
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
        return nombre + " " + apellido;
    }
    
    
}
