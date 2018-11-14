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
 * Panel de ayuda donde la informacion proporcioanda es util para el usuario en su tiempo de juego
 *
 * @author Yeltsin y Luis
 */
public class panelAyuda extends JPanel {

    int x, y, ancho, alto,i=0;

    Image imagen[] = new Image[2];
    boolean visible=false;
    public panelAyuda(int x, int y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        for (int i = 0; i < imagen.length; i++) {
            imagen[i] = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/ayuda" + i + ".png")).getImage();
        }

    }

    public void paint(Graphics g2) {
        super.paint(g2);
        Graphics2D g = (Graphics2D) g2;
       // g.drawRect(x+12, y+15, ancho-140, alto-125);
        if(visible==false){
        g.drawImage(imagen[0], this.x, this.y, null);
        }else{
        g.drawImage(imagen[0], this.x, this.y, null);
        g.drawImage(imagen[1], this.x-18, this.y-160, null);
        }
    }
    public Rectangle getBounds() {
        return new Rectangle(x+12, y+15, ancho-140, alto-125);
    }
}
