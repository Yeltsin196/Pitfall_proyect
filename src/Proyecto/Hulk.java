package Proyecto;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 * Hulk creado para impedir que atrape monedas
 * 
 * @author Yeltsin
 */

public class Hulk extends JPanel {

    int TAM = 2;
    Image Imagen[] = new Image[2];

    int x, y, ancho, alto, i = 0, cont = 0;

    public Hulk(int x, int y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        for (int j = 0; j < Imagen.length; j++) {
            Imagen[j] = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Hulk" +j+ ".png")).getImage();
        }
    }

    public void paint(Graphics g2) {
        super.paint(g2);

        Graphics2D g = (Graphics2D) g2;
        //g2.drawRect(x-2, y+30, ancho-90, alto-80);
        cont++;
       g.drawImage(Imagen[i], this.x, this.y, null);
        if (cont == 200) {
            i=1;
            
            
        }
        if(cont==290){
            i=0;
            cont=0;
        }
        repaint();
    }
    
    public Rectangle getBounds() {

        return new Rectangle(x-2, y+30, ancho-90, alto-80);

    }

}
