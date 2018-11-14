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

/**
 *
 * @author luis.guerrerog
 */
public class  Llave extends JPanel {
    int x, y, ancho, alto,i=0;
    Image image;
    boolean visible=true;
    public Llave(int x, int y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.image= new ImageIcon(getClass().getClassLoader().getResource("Imagenes/llave.png")).getImage();
        }
    
    
     public Rectangle getBounds() {
        return new Rectangle(x, y, ancho, alto);
    }
    
    public void paint(Graphics g2) {
        
        if(visible){
        super.paint(g2);
        Graphics2D g = (Graphics2D) g2;
      //  g2.drawRect(x, y, ancho, alto);
        g.drawImage(image, this.x, this.y, null);
        repaint();
        }
    }
    }
    
    
    

