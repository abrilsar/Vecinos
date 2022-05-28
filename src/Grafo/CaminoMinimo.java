/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import java.util.Arrays;

/**
 *
 * @author Jose
 */
public class CaminoMinimo {
    private int [][] Pesos;
    private int [] ultimo;
    private int [] D;
    private boolean [] F;
    private int s, n; // vértice origen y número de vértices
    
    /**
     * Constructor de la clase CaminoMinimo
     * @param gp El parámetro gp llama a la clase GrafMatPeso
     * @param origen El parámetro origen define el punto de partida del grafo
     */
    public CaminoMinimo(GrafMatPeso gp, int origen){
        n = gp.numeroDeVertice();
        s = origen;
        Pesos = gp.matPeso;
        ultimo = new int [n];
        D = new int [n];
        F = new boolean [n];
    }
    
    /**
    *Método que determina el camino más corto para el recorrido del grafo
    */
    public void caminoMinimos(){
        // valores iniciales
        for (int i = 0; i < n; i++){
            F[i] = false;
            D[i] = Pesos[s][i];
            ultimo[i] = s;
        }
        F[s] = true; D[s] = 0;
        // Pasos para marcar los n-1 vértices 
        for (int i = 1; i < n; i++){
            int v = minimo(); /* selecciona vértice no marcado de menor distancia */
            F[v] = true;
            // actualiza distancia de vértices no marcados 
            for (int w = 1; w < n; w++){
                if (!F[w]){
                    if ((D[v] + Pesos[v][w]) < D[w]){
                        D[w] = D[v] + Pesos[v][w];
                        ultimo[w] = v;
                    }
                }
            }
        }
    }
    
    /**
    *Método que determina eñ camino más corto del grafo
    *@return retorna de distancia minima del recorrido
    */
    private int minimo(){
        int mx = GrafMatPeso.INFINITO;
        int v = 1;
        for (int j = 1; j < n; j++){
            if (!F[j] && (D[j]<= mx)){
                mx = D[j];
                v = j;
            }
        }
        return v;
    }
    
//    public int[] recuperaCamino(int v) {
//        int anterior = ultimo[v];
//        if (v != s) {
//            int[] pasos = recuperaCamino(anterior); // vuelve al último del último
//            int i = 0;
//            for(; i < pasos.length;) {
//                if (pasos[i++] == -1) break;
//            }
//            pasos[i] = v;
//            System.out.print(" -> V" + v);
//            return pasos;
//        }
//        else {
//            System.out.print("V" + s);
//            int[] pasos = new int[n];
//            Arrays.fill(pasos, -1);
//            pasos[0] = s;
//            return pasos;
//        }
//    }
    
    /**
     * Método que permite volver hacia atrás y reconstruir un camino a través de la recursividad
     * @param v El parámetro v define
     */
    public void recuperaCamino(int v)
    {
        int anterior = ultimo[v];
        if (v != s)
        {
            recuperaCamino(anterior); // vuelve al último del último

            System.out.print(" -> V" + v);
        }
        else {
            
            System.out.print("V" + s);
        }
    }
}
