/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import javax.swing.JOptionPane;


public class Resumen {
    String titulo;
    String resumen;
    String[] autores;
    String[] palabras_clave;
    
    public Resumen(String titulo, String resumen, String[] autores, String[] palabras_clave) {
        this.titulo = titulo;
        this.resumen = resumen;
        this.autores = autores;
        this.palabras_clave = palabras_clave;
        
        
    }
    

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String[] getAutores() {
        return autores;
    }

    public void setAutores(String[] autores) {
        this.autores = autores;
    }

    public String[] getPalabras_clave() {
        return palabras_clave;
    }

    public void setPalabras_clave(String[] palabras_clave) {
        this.palabras_clave = palabras_clave;
    }
    
    public String printDocument() {
        String str = "";
        str+= titulo + ".\n";
        str+= "Autores: ";
        for (int i = 0; i<autores.length;i++){
            str += autores[i];
        }
        str += "\n";
        for(int i = 0; i<palabras_clave.length;i++){
            str += palabras_clave[i]+": "+Integer.toString(contarPalabra(palabras_clave[i]))+"\n";
        }
        return str;
    }
    
    public int contarPalabra(String palabra){
        return resumen.split(palabra).length-1;
    }
    
}
