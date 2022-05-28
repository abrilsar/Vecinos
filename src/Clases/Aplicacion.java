/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Grafo.GrafMatPeso;
import Grafo.Vertice;
import Grafo.VerticeCliente;
import Grafo.VerticeRestaurant;
import Interfaces.VentanaInicial;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author SebasBD
 */
public class Aplicacion {
    private static GrupoListas grupoListas;
    private static ManejoDeData mdd;
    private static GrafMatPeso grafo;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Inicialización de la data contenida en el txt.
        File masterdata = cargarMasterdata();
        if (masterdata != null) {
            mdd = new ManejoDeData(masterdata);
            grupoListas = mdd.leer_txt();
            // Ahora todas las clases pueden acceder a las listas con Aplicacion.getGrupoListas()
            // Inicializamos grafo
            grafo = GrafMatPeso.desdeListas(grupoListas.getClientes(), grupoListas.getRestaurantes(), grupoListas.getRutas());
            // Inicializamos ventana inicial
            VentanaInicial ventanaInicial = new VentanaInicial();
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    ventanaInicial.setVisible(true);
                    ventanaInicial.addWindowListener(new AdaptadorVentanaInicial());
                }
            });
        }
    }

    public static GrupoListas getGrupoListas() {
        return grupoListas;
    }

    public static GrafMatPeso getGrafo() {
        return grafo;
    }

    private static File cargarMasterdata() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos de texto (TXT)", "txt"));
        fileChooser.showOpenDialog(null);
        File archivo = fileChooser.getSelectedFile();
        if (archivo != null) {
            return archivo;
        }
    
        JOptionPane.showMessageDialog(null, "Asegúrese de seleccionar un archivo");
        return null;
    }
    
    
 
    private static class AdaptadorVentanaInicial extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            mdd.guardar_txt(grupoListas.getRestaurantes(), grupoListas.getClientes(), grupoListas.getPedidos(), grupoListas.getRutas());   
        }
        
    }
  
    /**
     * Método que agrega un restaurante tanto al grafo como a la lista de restaurantes
     * @param nodoRestaurant El parámetro nodoRestaurant define el elemento que se desea agregar
     * @return Reotrna el vertice del restaurante agregado
     */
    public static Vertice agregarVerticeRestaurant(NodoRestaurant nodoRestaurant) {
        Vertice verticeRestaurant = new VerticeRestaurant(nodoRestaurant);
        grafo.nuevoVertice(verticeRestaurant);
        grupoListas.getRestaurantes().agregar_al_final(nodoRestaurant);
        return verticeRestaurant;
    }
    
    /**
     * Método que agrega una ruta al grafo y a la lista de rutas
     * @param a El parámetro a define el punto de partida del grafo
     * @param b El parámero b define el punto de llegada del grafo
     * @param distancia El parámetro distancia define la distancia entre los puntos a y b
     * @return Retorna la ruta agregada
     */
    public static NodoRuta agregarRuta(Vertice a, Vertice b, int distancia) {
        NodoRuta nodoRuta = new NodoRuta(a.getEtiqueta(), b.getEtiqueta(), String.valueOf(distancia));
        grafo.nuevoArco(a, b, distancia);
        grupoListas.getRutas().agregar_al_final(nodoRuta);
        return nodoRuta;
    }
    
    public static Vertice agregarVerticeCliente(NodoCliente nodoCliente) {
        Vertice verticeCliente = new VerticeCliente(nodoCliente);
        grafo.nuevoVertice(verticeCliente);
        grupoListas.getClientes().agregar_al_final(nodoCliente);
        return verticeCliente;
    }
}
