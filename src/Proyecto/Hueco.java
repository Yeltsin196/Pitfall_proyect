package Proyecto;

import java.awt.*;
import javax.swing.*;
/**
 * Hueco o agujero que acciona la caida del personaje al siguiente piso
 * @author Yeltsin y Luis
 */
public class Hueco extends JPanel {

    int x, y, ancho, alto;
    Image imagen;

    public Hueco(int x, int y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
    }

    public void cargar() {
        imagen = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Hueco.png")).getImage();
    }

    @Override
    public void paint(Graphics g2) {
        super.paint(g2);
        Graphics2D g = (Graphics2D) g2;
       
        g.drawImage(imagen, this.x, this.y, null);
        //g2.fillRect(x+12 , y, ancho -30, alto - 9);
    }

    public Rectangle getBounds() {

        return new Rectangle(x+12, y, ancho-30, alto - 9);

    }

}
