/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Grafo.Vertice;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;

public class VerticeGrafico {
    public static final double DIAMETRO = 40d;
    private Vertice vertice;
    private Color color;
    private Color colorBorde;
    private boolean marcado;
    private Point puntoOrigen;

    public VerticeGrafico(int x, int y, Vertice vertice, Color color) {
        puntoOrigen = new Point(x, y);
        this.vertice = vertice;
        this.color = color;
        this.colorBorde = Color.WHITE;
        this.marcado = false;
    }
    
    public void renderizar(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(color);
        g2.fillOval((int) (puntoOrigen.x - DIAMETRO / 2), (int) (puntoOrigen.y - DIAMETRO / 2), (int)DIAMETRO, (int)DIAMETRO);
        if (marcado) {
            Stroke lastStroke = g2.getStroke();
            g2.setStroke(new BasicStroke(2.5f));
            g2.setPaint(colorBorde);
            g2.drawOval((int) (puntoOrigen.x - DIAMETRO / 2), (int) (puntoOrigen.y - DIAMETRO / 2), (int)DIAMETRO, (int)DIAMETRO);
            g2.setStroke(lastStroke);
        }
        String etiqueta = vertice.getNombre();
        // Imprimir la etiqueta centrada en el círculo
        FontMetrics fm = g2.getFontMetrics();
        double textWidth = fm.getStringBounds(etiqueta, g2).getWidth();
        int etiquetaX = (int) (puntoOrigen.x - textWidth / 2);
        int etiquetaY = (int) (puntoOrigen.y + fm.getAscent() / 2);
        g2.setPaint(Color.BLACK);
        g2.drawString(etiqueta, etiquetaX, etiquetaY);
    }
    
    public Vertice getVertice() {
        return vertice;
    }

    public void setVertice(Vertice vertice) {
        this.vertice = vertice;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Point getPuntoOrigen() {
        return puntoOrigen;
    }

    void setColorBorde(Color colorBorde) {
        this.colorBorde = colorBorde;
    }

    void setMarcado(boolean marcado) {
        this.marcado = marcado;
    }
}
