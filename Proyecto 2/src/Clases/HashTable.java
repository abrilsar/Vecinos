
package Clases;

import java.util.Set;
import javax.swing.JOptionPane;


public class HashTable {
    Nodo_Hash[] table;
    int tamaño;
    
    public HashTable(){
        this.tamaño = 0;
        this.table = new Nodo_Hash[tamaño];
    }

    public Nodo_Hash[] gettable() {
        return table;
    }

    public void settable(Nodo_Hash[] table) {
        this.table = table;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }
    
    public void insertar(Nodo_Hash nodo, String titulo) {
        int position = hash(titulo);
        if(position > tamaño) {
            Nodo_Hash[] nuevo = new Nodo_Hash[position+1];
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
            Nodo_Hash temp = table[position];
            if (temp.getDocumento().getTitulo().equals(nodo.getDocumento().getTitulo())) {
                JOptionPane.showMessageDialog(null, "Ese documento ya existe");
            } else {
                while (temp.getNext() != null) {
                    temp = temp.getNext();
                    if (temp.getDocumento().getTitulo().equals(nodo.getDocumento().getTitulo())){
                        JOptionPane.showMessageDialog(null, "Ese documento ya existe");
                        break;

                }
                temp.setNext(nodo);
            }
        }
        table[position] = nodo;
        }
        }
    }
    
    
    public int hash(String nombre) {
        int valor = 0;
        int posicion = 1;
        for (int i = 0; i < nombre.length() ; i++) {
                if (nombre.codePointAt (i) == 32) {
                    valor += 0;
                } else if (nombre.codePointAt (i) >= 48 && nombre.codePointAt (i) <= 57) {
                        valor += ((nombre.codePointAt (i) - 47) * posicion);
                } else if (nombre.codePointAt (i) >= 65 && nombre.codePointAt (i) <= 90) {
                        valor += ((nombre.codePointAt (i) - 54) * posicion);
                } else if (nombre.codePointAt (i) >= 97 && nombre.codePointAt (i) <= 122) {
                        valor += ((nombre.codePointAt (i) - 60) * posicion);
                }
                posicion++;
            }
            return (valor % tamaño);
    }
    
}
