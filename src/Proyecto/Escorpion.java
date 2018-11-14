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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Escorpion movible que impide el paso del personaje
 * 
 * @author Yeltsin
 */
public class Escorpion extends JPanel{
    int TAM=4;
        Image Imagen[]= new Image[TAM];
        int x,y,ancho,alto, i=0;
        Timer t;
    public Escorpion(int x, int y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
    }
      public void cargarimagenes() {
        
        Imagen[3] = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/esc4.png")).getImage();
        Imagen[2] = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/esc3.png")).getImage();
        Imagen[1] = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/esc2.png")).getImage();
        Imagen[0] = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/esc1.png")).getImage();
 
    }
        public void moverescorpion(){
             t = new Timer(120, new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     if (i == TAM-1) {
                         i = 0;
                     }
                      x+=10;  
                     i++;
                     if(x>=1160){
                     x=2;
                     }
                 }
             
             });
             t.start();  
            
        }
        
        
     public void paint(Graphics g2) {
        super.paint(g2);
        Graphics2D g = (Graphics2D) g2;
       // g2.drawRect(x+12, y, ancho-20, alto);
        g.drawImage(Imagen[i], this.x, this.y, null);
        repaint();
    }
    public Rectangle getBounds() {

        return new Rectangle(x, y, ancho, alto);

    }
}
