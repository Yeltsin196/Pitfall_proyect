
package Proyecto;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 * Hoyo donde puede caer el personaje
 * @author Yeltsin y Luis
 */
public class Hoyo extends JPanel{
     int x, y, ancho, alto;
     
    Image imagen;

    public Hoyo(int x, int y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.imagen= new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Hoyo.png")).getImage();
        
    }

    @Override
    public void paint(Graphics g2) {
        super.paint(g2);
        Graphics2D g = (Graphics2D) g2;
       
        g.drawImage(imagen, this.x, this.y, null);
       //g2.fillRect(x+12 , y-2, ancho -30, alto - 5);
    }
    
    public Rectangle getBounds() {

        return new Rectangle(x+12, y-2, ancho-30, alto-5);

    }
    
    
    

}
