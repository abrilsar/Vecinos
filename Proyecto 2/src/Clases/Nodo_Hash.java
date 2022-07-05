/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;


public class Nodo_Hash {
    Nodo_Hash next;
    Nodo_Resumen documento;
    
    public Nodo_Hash (Nodo_Resumen documento){
        this.next = null;
        this.documento = documento;
        
    }

    public Nodo_Hash getNext() {
        return next;
    }

    public void setNext(Nodo_Hash next) {
        this.next = next;
    }

    public Nodo_Resumen getDocumento() {
        return documento;
    }

    public void setDocumento(Nodo_Resumen documento) {
        this.documento = documento;
    }
    
}
