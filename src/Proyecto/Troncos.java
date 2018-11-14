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
import static java.lang.Thread.sleep;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Genera Troncos continuamente que reducen la vida del personaje 
 * @author Yeltsin y Luis
 */
public class Troncos extends JPanel {

    Image Imagen[] = new Image[4];
    int x, y, ancho, alto, i = 0;
    Timer t;

    public void setX(int x) {
        this.x = x;
    }
    
    public int getI() {
        return i;
    }

    public Troncos(int x, int y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
    }

    public void cargar() {
        Imagen[3] = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/tronco4.png")).getImage();
        Imagen[2] = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/tronco3.png")).getImage();
        Imagen[1] = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/tronco2.png")).getImage();
        Imagen[0] = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/tronco1.png")).getImage();
    }
    
    public void troncosmover() throws InterruptedException {

        t = new Timer(50, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (i == 3) {
                    i = 0;
                }

                i++;
             //   System.out.println("rosameltronco"+x);
                if (x > 3) {
                    x -= 5;
                }
                if (x <= 3) {
                    x = 1150;
                 
                }

            }

        });

        t.start();
    }

    public void paint(Graphics g2) {
        super.paint(g2);
        Graphics2D g = (Graphics2D) g2;
         //g2.fillRect(x, y, ancho-3, alto-30);
        g.drawImage(Imagen[i], this.x, this.y, null);
        repaint();

    }
    public Rectangle getBounds() {

        return new Rectangle(x, y, ancho-3, alto-30);

    }
}
