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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *Genera sierras girando cada 3s con un timer 
 * @author Yeltsin y Luis
 */
public class Sierra extends JPanel {

    int tam = 5;
    Image Imagen[] = new Image[tam];
    boolean girando=false;
    Timer t, ini;
    int x, y, ancho, alto, altura, i, cont = 0;

    public Sierra(int x, int y, int alto, int altura) {
        this.x = x;
        this.y = y;
        this.alto = alto;
        this.altura = altura;
    }

    public void cargar() {
        Imagen[0] = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/sierra3.png")).getImage();
        Imagen[1] = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/sierra4.png")).getImage();
        Imagen[2] = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/sierra5.png")).getImage();
        Imagen[3] = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/sierra6.png")).getImage();
        Imagen[4] = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/sierra4.png")).getImage();
    }

    public void sierramover() throws InterruptedException {
        
        t = new Timer(20, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (i == 4) {
                    i = 0;
                }
                cont++;
                i++;
                  girando=true;
                if (cont == 200) {
                    t.stop();
                    girando=false;
                    pararSierra();
                    
                }
            }

        });
        t.start();
    }

    public void pararSierra() {
        i = 0;
        //t.stop();
        cont = 0;
        ini = new Timer(3000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    sierramover();
                    t.restart();
                    ini.stop();
                } catch (InterruptedException ex) {
                    //Logger.getLogger(Sierra.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        ini.start();

    }

    public void paint(Graphics g2) {
        super.paint(g2);
        Graphics2D g = (Graphics2D) g2;
     // g2.drawRect(x+10, y+25, ancho+50, alto-40);
        g.drawImage(Imagen[i], this.x, this.y, null);
   
        repaint();

    }

    public Rectangle getBounds() {

        return new Rectangle(x+10, y+25, ancho+50, alto-40);

    }

}
