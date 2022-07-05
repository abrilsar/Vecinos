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


public class Txt {
    
    
    public void leer_archivo(){
        String str = "Resumenes.txt";
        String contenido = this.leer_archivo(str);
        String[] contenido_array = contenido.split("archivos::\n");
        for (int i = 1; i < contenido_array.length; i++) {
            this.crear_nodo(contenido_array[i]);
        }
        
    }
    
    public void crear_nodo(String contenido) {
        String nombre = contenido.split("Autores")[0];
        String[] autores = contenido.split("Resumen\n")[0].split("Autores\n")[1].split("\n");
        String resumen = contenido.split("Resumen\n")[1].split("Palabras Claves:")[0];
        String[] palabras_claves = contenido.split("Palabras Claves: ")[1].split(".")[0].split(", ");
        Nodo_Resumen nodo = new Nodo_Resumen(nombre, resumen, autores, palabras_claves);
        Nodo_Hash nodo2 = new Nodo_Hash(nodo);
        Global.getTable().insertar(nodo2, nombre);
        
    }
    
    public String leer_archivo(String path) {
        String contenido_txt = "";
        String line;
        File file = new File(path);
        try {
            if (!file.exists()){
                file.createNewFile();
            } else {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while ((line = br.readLine()) != null) {
                    if (!line.isEmpty()) {
                        contenido_txt += line + "\n";
                    }
                }
                br.close();
                JOptionPane.showMessageDialog(null, "Lectura exitosa");
              
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo");
        }
        return contenido_txt;
    }
    
}
