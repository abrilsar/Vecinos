/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;


public class Global {
    private static Lista lista_todo;
    private static Lista lista_guardar;
    private static HashTable table;

    public static HashTable getTable() {
        return table;
    }

    public static void setTable(HashTable GlobalTable) {
        Global.table = GlobalTable;
    }

    public static Lista getLista_todo() {
        return lista_todo;
    }

    public static void setLista_todo(Lista lista_todo) {
        Global.lista_todo = lista_todo;
    }

    public static Lista getLista_guardar() {
        return lista_guardar;
    }

    public static void setLista_guardar(Lista lista_guardar) {
        Global.lista_guardar = lista_guardar;
    }


    
    
    
    
}
