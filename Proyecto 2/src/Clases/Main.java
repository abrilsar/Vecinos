/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Martin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashTable tabla = new HashTable();
        Lista<String> lista_todo = new Lista();
        Lista<String> lista_guardar = new Lista();
        
        Global.setLista_guardar(lista_guardar);
        Global.setTable(tabla);
        Global.setLista_guardar(lista_todo);
        
        Txt txt = new Txt("Resumenes.txt");
        txt.start();

        
        
    }
    
}
