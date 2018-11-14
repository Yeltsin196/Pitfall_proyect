/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ayuda;

import java.net.URL;
import javax.swing.ImageIcon;

/**
 * Donde se cargar el fondo de la ventana de ayuda
 * @author Yeltsin y Luis
 */
public class ImageLoader {
    private static ImageLoader instance=null;

    
    private ImageIcon images;

    public ImageLoader(){
       
        images = new ImageIcon();
       
            URL url = getClass().getClassLoader().getResource("Imagenes/Instrucciones.png");
         
            images = new ImageIcon(url);
        
    }

    public static ImageLoader getInstance(){
        if(instance==null)
          instance = new ImageLoader();

        return instance;
    
    }

    public ImageIcon getImage(){
        return images;
    }
}