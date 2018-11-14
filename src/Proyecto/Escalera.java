/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Escalera para bajar al segundo piso o piso subterraneo 
 * Y tambien para subir al primer piso o piso inicial
 * @author Yeltsin y Luis
 */
public class Escalera extends JPanel {

    Image Imagen;

    int x, y, ancho, alto;

    public Escalera(int x, int y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
    }
    public void SetX(int x){
    this.x=x;
    }
    public void SetY(int y){
    this.y=y;
    }
    @Override
    public int getX(){
    return this.x;
    }
    @Override
    public int getY(){
    return this.y;
    }
    public void paint(Graphics g2) {
        super.paint(g2);
        Graphics2D g = (Graphics2D) g2;
      
        g.drawImage(Imagen, this.x, this.y, null);
          //g2.drawRect(x + 40, y - 2, ancho - 64, alto + 10);
        repaint();
    }

    public void generarescaleras() {
        this.Imagen = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/escalera3.png")).getImage();

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x + 40, y - 2, ancho - 68, alto + 10);

    }

}
