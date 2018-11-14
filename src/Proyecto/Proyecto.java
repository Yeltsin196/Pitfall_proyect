/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import Inicio.Inicio;
import java.awt.AWTEventMulticaster;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JTextField;
/**
 * Clase principal donde se cargan el metodo fondo que contiene las variables principales
 * 
 * @author Yeltsin
 */
public class Proyecto extends JFrame {

    public void ventana(String Nom,int Xo,int Yo,double SaludI,int VidasI,int PuntI,int mapaI,boolean mundo1,boolean mundo2,boolean level2) throws InterruptedException {
        setSize(1218, 800);
        setLocationRelativeTo(null);
        Fondo f = new Fondo(Nom,Xo,Yo,SaludI,VidasI,PuntI,mapaI,mundo1,mundo2,level2);
        add(f);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }

    public Proyecto(){
    }
    

    public static void main(String[] args) throws InterruptedException {
 
        Inicio inicio = new Inicio();
        inicio.setVisible(true);
    }

}
