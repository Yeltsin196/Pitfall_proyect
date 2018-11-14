/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Donde se encuentra dibujado el Iron man , barra de fondo negra
 * @author Yeltsin y Luis
 */

/* panel de datos nombre  vida y asi*/
public class Paneldatos extends JPanel{
    int TAM=4;
    Image Imagen[]= new Image[TAM];
    Timer t;
    int i = 0, x, y, ancho, alto;

    public Paneldatos(int x, int y, int ancho, int largo) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
    }

    public void cargar() {
        Imagen[0] = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/irondatos1.png")).getImage();
        Imagen[1] = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/irondatos.png")).getImage();

    }

    public void mostrar() {

    }

    public void paint(Graphics g2) {
        super.paint(g2);
        Graphics2D g = (Graphics2D) g2;
        g2.fillRect(x, y, ancho, alto);
        for (int j = 0; j < 2; j++) {
            if (j != 0) {
                g.drawImage(Imagen[j], this.x, this.y+95, null);
            }
            if (j == 0) {
                g.drawImage(Imagen[0], this.x, 670, null); // posicion en y manual 
            }
        }

        repaint();

    }
    
    
}
