package Proyecto;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 * Fuego que al igual que las sierras o los troncos ayuda a disminuir la vida del personaje
 * @author Yeltsin
 */
public class Fuego extends JPanel {

    int TAM = 4;
    Image Imagen[] = new Image[TAM];
    int x, y, ancho, alto, i = 0;
    public Fuego(int x, int y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        for (int j = 0; j < Imagen.length; j++) {
            Imagen[j] = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Fire" + j + ".png")).getImage();
        }
    }

    @Override
    public void paint(Graphics g2) {
        super.paint(g2);
        Graphics2D g = (Graphics2D) g2;
        g.drawImage(Imagen[i], this.x, this.y, null);
   //     g2.drawRect(x, y, ancho, alto);
        i++;
        if (i == TAM) {
            i = 0;
        }
        repaint();
    }

}
