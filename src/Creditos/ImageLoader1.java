/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Creditos;

import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author Yeltsin
 */
public class ImageLoader1 {
       private static ImageLoader1 instance=null;

    
    private ImageIcon images;

    private ImageLoader1(){
       
        images = new ImageIcon();
       
            URL url = getClass().getClassLoader().getResource("Imagenes/creditos.png");
         
            images = new ImageIcon(url);
        
    }

    public static ImageLoader1 getInstance(){
        if(instance==null)
            instance = new ImageLoader1();

        return instance;
    
    }

    public ImageIcon getImage(){
        return images;
    }
}
