/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Creditos;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;

/**
 *
 * @author Yeltsin
 */
public class Creditos extends JFrame{
     public JLabel fondo;
    public Creditos(){
    
    setSize(600, 320);
        setLocationRelativeTo(null);  
        setResizable(false);
        setFocusable(true);
        setVisible(true);
   ImageLoader1 loader = ImageLoader1.getInstance();
        ImageIcon icon = loader.getImage();
        fondo = new JLabel(icon);
        fondo.setBounds(0, 0, 1000, 546);
       add(fondo);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
            

}
