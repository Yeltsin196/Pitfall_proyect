package Proyecto;

import java.awt.*;
import javax.swing.*;
/**
 * Muro que impide que pase al siguiente mapa
 * @author Yeltsin y Luis
 */
public class Muro extends JPanel {

    int x, y, ancho, alto;
    Image imagen;

    public Muro(int x, int y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.imagen = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/laser.png")).getImage();
    }

    @Override
    public void paint(Graphics g2) {
        super.paint(g2);
        Graphics2D g = (Graphics2D) g2;
       // g2.drawRect(x+20, y+5, ancho-30, alto-20);
        g.drawImage(imagen, this.x, this.y, null);

        repaint();
    }
    public Rectangle getBounds() {

        return new Rectangle(x+20, y+5, ancho-30, alto-20);

    }
}
