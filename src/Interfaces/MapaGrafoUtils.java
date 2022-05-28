/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Grafo.GrafMatPeso;
import Grafo.Vertice;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapaGrafoUtils {
    private MapaGrafoUtils() {}
    
    public static MapaGrafo construirMapa(GrafMatPeso grafMatPeso) {
        Vertice[] vertices = grafMatPeso.vertices();
        int[][] pesos = grafMatPeso.getMatPeso();
        List<VerticeGrafico> verticesGraficos = new ArrayList<>(vertices.length);
        List<AristaGrafica> aristasGraficas = new ArrayList<>(vertices.length * vertices.length);
        Random random = new Random();
        // Primero llenamos la lista de vertices graficos
        for (int v = 0; v < grafMatPeso.numeroDeVertice(); v++) {
            Vertice vertice = vertices[v];
            int x = random.nextInt(700);
            int y = random.nextInt(500);
            VerticeGrafico vGrafico = new VerticeGrafico(x, y, vertice, vertice.getColorPreferencia());
            verticesGraficos.add(vGrafico);
        }
        
        // llenamos lista de aristas graficas
        // iteramos luego de llenar la lista de vertices y no durante, 
        // para asegurar que existan todas las referencias de los objetos de VerticeGrafico
        for (int i = 0; i < grafMatPeso.numeroDeVertice(); i++) {
            for (int j = 0; j < grafMatPeso.numeroDeVertice(); j++) {
                VerticeGrafico origen = verticesGraficos.get(i);
                VerticeGrafico destino = verticesGraficos.get(j);
                int peso = pesos[i][j];
                if (peso != GrafMatPeso.INFINITO) {
                    aristasGraficas.add(new AristaGrafica(peso, origen, destino));
                }
            }
        }
        
        return new MapaGrafo(verticesGraficos, aristasGraficas);
    }
}
