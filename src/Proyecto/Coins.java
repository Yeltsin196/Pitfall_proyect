
package Proyecto;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Monedas , diseñadas con el fin de aumentar el puntaje
 * Y ademas poder subir de nivel 
 * @author Yeltsin y Luis
 */
public class Coins extends JPanel {
    
    int TAM=5;
    Image Imagen[]= new Image[TAM];

    int x, y, ancho, alto,i=0,cont=0;
    boolean visible=true;
    public Coins(int x, int y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        for (int j = 0; j < Imagen.length; j++) {
            Imagen[j] = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/coin" + j + ".png")).getImage();
        }
    }

    @Override
    public void paint(Graphics g2) {
     
      if(visible){
     super.paint(g2);
     Graphics2D g = (Graphics2D) g2;
     cont++;   
      g.drawImage(Imagen[i], this.x, this.y, null);
     
      if(cont==40){
      i++;
      cont=0;
      }
      if(i==TAM){
      i=0;
      }
      
       //g2.drawRect(x+12 , y , ancho-30, alto);
        repaint();
    }
    }
    public Rectangle getBounds() {
        return new Rectangle(x, y, ancho, alto);
    }
    public void cambiarEstado(boolean estado){
    this.visible=estado;
    }
    
    
    
    
    
    
}
