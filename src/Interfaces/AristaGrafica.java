/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;

public class AristaGrafica {
    private int peso;
    private VerticeGrafico origen;
    private VerticeGrafico destino;
    AffineTransform tx = new AffineTransform();
    Polygon arrowHead = new Polygon();
    
    public AristaGrafica(int peso, VerticeGrafico origen, VerticeGrafico destino) {
        this.peso = peso;
        this.origen = origen;
        this.destino = destino;
        // https://stackoverflow.com/a/3094933
        arrowHead.addPoint( 0,5);
        arrowHead.addPoint( -5, -5);
        arrowHead.addPoint( 5,-5);
    }

    public void renderizar(Graphics g) {
        Point p1 = origen.getPuntoOrigen();
        Point p2 = destino.getPuntoOrigen();
        
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(Color.darkGray);
        
        // dibujo del peso de la arista
        String etiquetaPeso = String.valueOf(peso);
        double pesoX = p1.getX() + ((p2.getX() - p1.getX()) / 2);
        double pesoY = p2.getY() - ((p2.getY() - p1.getY()) / 2);
        g2.drawString(etiquetaPeso, (int) pesoX, (int) pesoY);

        // https://stackoverflow.com/a/47371140 -- dibujo de recta de la arista.
        double from = anguloEntre(p1, p2);
        double to = anguloEntre(p2, p1);
        Point.Double pointFrom = getPuntoEnCirculo(p1, from, VerticeGrafico.DIAMETRO / 2);
        Point.Double pointTo = getPuntoEnCirculo(p2, to, VerticeGrafico.DIAMETRO / 2);

        Line2D line = new Line2D.Double(pointFrom, pointTo);
        g2.draw(line);
        tx.setToIdentity();
        double angle = Math.atan2(line.getY2()-line.getY1(), line.getX2()-line.getX1());
        tx.translate(pointTo.x, pointTo.y);
        
        // https://stackoverflow.com/a/3094933 -- dibujo de la punta de la flecha
        tx.rotate((angle-Math.PI/2d));  
        g2.setTransform(tx);
        g2.fill(arrowHead);
        
        
        g2.dispose();
    }
    
    // https://stackoverflow.com/a/47371140
    protected double anguloEntre(Point from, Point to) {
        double x = from.getX();
        double y = from.getY();
        
        double deltaX = to.getX() - x;
        double deltaY = to.getY() - y;

        double rotation = -Math.atan2(deltaX, deltaY);
        rotation = Math.toRadians(Math.toDegrees(rotation) + 180);

        return rotation;
    }
    
    // https://stackoverflow.com/a/47371140
    protected Point.Double getPuntoEnCirculo(Point center, double radians, double radius) {

    double x = center.getX();
    double y = center.getY();

    radians = radians - Math.toRadians(90.0); // 0 becomes the top
    // Calculate the outter point of the line
    double xPosy = Math.round((float) (x + Math.cos(radians) * radius));
    double yPosy = Math.round((float) (y + Math.sin(radians) * radius));

    return new Point.Double(xPosy, yPosy);

}

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    
    
}
