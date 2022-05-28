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
public class Funciones {
    
    /**
     * Constructor de la clase Funciones
     */
    public Funciones(){
    
    }
    
    /**
     * Método que comprueba que solo hayan letras en una cadena
     * @param cadena El parámetro cadena define una cadena ingresada por el usuario
     * @return Retorna true si la cadena solo contiene letras
     */
    public boolean esSoloLetras(String cadena){
        for (int i = 0; i < cadena.length(); i++){
            char caracter = cadena.toUpperCase().charAt(i);
            int valorASCII = (int)caracter;
            if (valorASCII != 165 && (valorASCII < 65 || valorASCII > 90))
		return false; 
            }
	return true;
    }
}
