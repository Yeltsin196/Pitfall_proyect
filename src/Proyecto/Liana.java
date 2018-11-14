/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import java.awt.*;
import javax.swing.*;

/**
 * Liana que ayuda al personaje a transportarse de un lugar a otro
 * @author luis.guerrerog
 */
public class Liana extends JPanel {
    
    Image Imagen;

    int x, y;
    
    public double xLiana = 900, yLiana = 300;
    public double delta = 0;
    public boolean derecha = true;
    public int salida = 400;
    int llegada = 950;

    public Liana(int x, int y){
        this.x = x;
        this.y = y;

    }
    
    
    public void des() {

        if (derecha) {
            xLiana += 0.5;

            delta += 0.5;
            if (xLiana >= llegada) {
                derecha = false;
            }
        } else if (!derecha) {
            xLiana -= 0.5;

            delta -= 0.5;
            if (xLiana <= salida) {
                derecha = true;
            }

        }
    }



    public double obtX() { 
        return this.xLiana;
        
    }
    public double obtY()
    {
    return this.yLiana;
    }    
    

    @Override
      public void paint(Graphics g) {
        super.paint(g);
        
         Graphics2D g2 = (Graphics2D) g;
         //g2.fillRect(x, y, ancho-3, alto-30);  
        des();
        g2.setStroke(new BasicStroke(5));
        g2.setColor(Color.decode("#c6962f"));
        g2.drawRect((int)xLiana-3, (int)yLiana-10, 10,10);
        g2.drawLine(600, 150, (int) xLiana, (int) yLiana);
     
        repaint();

    }
      
    public Rectangle getBounds() {

        return new Rectangle((int)xLiana-3, (int)yLiana-5,10,10);

    }  
    
    
    
    
}
