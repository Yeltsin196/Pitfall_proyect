
package Proyecto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 * Peligro , avisos generados en el mapa donde la informacion proporcionada es util para el usuario
 * @author Yeltsin  y Luis
 */

public class Danger extends JPanel {
    
      int x, y, ancho, alto;
      Image image;
      boolean visible=false;
    public Danger(int x, int y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
       this.image= new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Danger.png")).getImage();
        
    }
    
    public Rectangle getBounds() {
        return new Rectangle(x+12, y+55, ancho-140, alto-125);
    }
    
    public void paint(Graphics g2) {
        //g2.drawRect(x+12, y+55, ancho-140, alto-125);
        super.paint(g2);
        if(visible){
        Graphics2D g = (Graphics2D) g2;
        g2.setColor(Color.red);
        g.drawImage(image, this.x, this.y-100, null);
        repaint();
        }
    }
    
      
      
}
