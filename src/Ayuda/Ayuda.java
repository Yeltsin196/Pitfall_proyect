/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ayuda;

import Proyecto.Fondo;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;

/**
 *  Ayuda proporcionada al usuario para guiarlo o instruirlo sobre el juego.
 * @author Yeltsin y Luis
 */
public class Ayuda extends JFrame{

 public JLabel fondo;

   public Ayuda() {
       setSize(890, 506);
        setLocationRelativeTo(null);  
        setResizable(false);
        setFocusable(true);
        setVisible(true);
      ImageLoader loader = ImageLoader.getInstance();
        ImageIcon icon = loader.getImage();
        fondo = new JLabel(icon);
        fondo.setBounds(0, 0, 1000, 546);
       add(fondo);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
  
    
}
