package Inicio;

import java.net.URL;
import javax.swing.ImageIcon;
/**
 * Donde se genera el fondo de inicio como url para poder cargarla como JLabel en el inicio.
 * @author Yeltsin
 */
public class ImageLoader {

    private static ImageLoader instance = null;

    private ImageIcon[] images = new ImageIcon[2];

    private ImageLoader() {

        images[0] = new ImageIcon();
        images[1]= new ImageIcon();
        URL url1 = getClass().getClassLoader().getResource("Imagenes/FondoInicio2.png");
        URL url2 = getClass().getClassLoader().getResource("Imagenes/ironVidas.png");
        images[0] = new ImageIcon(url1);
        images[1]= new ImageIcon(url2);
    }

    public static ImageLoader getInstance() {
        if (instance == null) {
            instance = new ImageLoader();
        }

        return instance;

    }

    public ImageIcon getImage(int pos) {
        return images[pos];
    }
}
