
package Clases;

import java.util.Set;
import javax.swing.JOptionPane;


public class HashTable {
    Nodo[] table;
    Nodo[] words;
    Nodo[] authors;
    int tamaño;
    
    public HashTable(){
        this.tamaño = 1;
        this.table = new Nodo[tamaño];
        this.authors = new Nodo[1];
        this.words = new Nodo[1];
    }

    public Nodo[] gettable() {
        return table;
    }

    public void settable(Nodo[] table) {
        this.table = table;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }
    
    public boolean insertar(Nodo<Resumen> nodo, String palabra, String tipo, String titulo) {
        int position = hash(titulo);
        boolean exists = false;
        if(tipo.equals("titulo")){
            if(position > tamaño) {
                Nodo[] nuevo = new Nodo[position+1];
                for (int i = 0; i < tamaño; i++) {
                    nuevo[i] = table[i];
                }
                nuevo[position] = nodo;
                table = nuevo;
                tamaño = position+1;
            }else{
            if (table[position] == null) {
                table[position] = nodo;
            } else {
                Nodo<Resumen> temp = table[position];
                if (temp.getData().getTitulo().equals(nodo.getData().getTitulo())) {
                    JOptionPane.showMessageDialog(null, "Ese documento ya existe");
                    exists = true;
                } else {
                    while (temp.getNext() != null) {
                        temp = temp.getNext();
                        if (temp.getData().getTitulo().equals(nodo.getData().getTitulo())){
                            JOptionPane.showMessageDialog(null, "Ese documento ya existe");
                            exists = true;
                            break;

                    }
                    if (!exists) {
                    temp.setNext(nodo);              
                    }
                }
            }
            table[position] = nodo;
            }
            }
            
        } else{
            int pos = hash(palabra);
            int[] tabla;
            if(tipo.equals("autor")){
                tabla = authors;
            }else{
                tabla = words;
            }
            if(pos > tabla.length) {
                int[] nuevo = new int[pos+1];
                for (int i = 0; i < tabla.length; i++) {
                    nuevo[i] = tabla[i];
                }
                nuevo[pos] = position;
                if(tipo.equals("autor")){
                    this.authors = tabla;
                }else{
                    this.words = tabla;
                }
            }else{
                if (tabla[pos] == 0) {
                    tabla[pos] = position;
                } else {
                    Nodo<Resumen> temp = table[position];
                    if (temp.getData().getTitulo().equals(nodo.getData().getTitulo())) {
                        JOptionPane.showMessageDialog(null, "Ese documento ya existe");
                        exists = true;
                    } else {
                        while (temp.getNext() != null) {
                            temp = temp.getNext();
                            if (temp.getData().getTitulo().equals(nodo.getData().getTitulo())){
                                JOptionPane.showMessageDialog(null, "Ese documento ya existe");
                                exists = true;
                                break;

                        }
                        if (!exists) {
                        temp.setNext(nodo);              
                        }
                    }
                }
                table[position] = nodo;
                }
                }

        }
        return exists;
    }
    
    
    public int hash(String nombre) {
        int valor = 0;
        int position = 1;
        for (int i = 0; i < nombre.length() ; i++) {
                if (nombre.codePointAt (i) == 32) {
                    valor += 0;
                } else if (nombre.codePointAt (i) >= 48 && nombre.codePointAt (i) <= 57) {
                        valor += ((nombre.codePointAt (i) - 47) * position);
                } else if (nombre.codePointAt (i) >= 65 && nombre.codePointAt (i) <= 90) {
                        valor += ((nombre.codePointAt (i) - 54) * position);
                } else if (nombre.codePointAt (i) >= 97 && nombre.codePointAt (i) <= 122) {
                        valor += ((nombre.codePointAt (i) - 60) * position);
                }
                position++;
            }
            return (valor % tamaño);
    }
    
    public Lista buscarPorPalabra(String palabra) {
        int count = 0;
        Lista<String> lista = new Lista(); 
        for(int i = 0; i <Global.getLista_todo().getLen(); i++ ) {
            Nodo<String> nodo = Global.getLista_todo().buscarNodo(i);
            int position = hash(nodo.getData());
            Nodo<Resumen> nodoTable = table[position]; 
            for (int j = 0; j < nodoTable.getData().getPalabras_clave().length ; j++ ) {
                if (nodoTable.getData().getPalabras_clave()[j].equals(palabra)) {
                    lista.insertarFinal(nodoTable.getData().getTitulo());
                }
            }
        }
        return lista;
    }
    
}
