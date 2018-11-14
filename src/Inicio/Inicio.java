package Inicio;

import Ayuda.Ayuda;
import Creditos.Creditos;
import Proyecto.Proyecto;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.*;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import sun.applet.AppletAudioClip;

public class Inicio extends JFrame {
  /***
   * Ventana de inicio donde estan diferentes botones
   * Como Jugar cargar y ayuda.
   */
    ImageIcon inicio = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/FondoInicio2.png"));
    JLabel fondo;
    JButton Jugar, Cargar, Ayuda, Creditos1;
    boolean ent = false;
    AudioClip menu;
    public Inicio() {
        setLayout(null);
        setSize(682, 423);
        setLocationRelativeTo(null);
        setResizable(false);
        setFocusable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageLoader loader = ImageLoader.getInstance();
        ImageIcon icon = loader.getImage(0);
        fondo = new JLabel(icon);
        fondo.setBounds(0, 0, 682, 423);
        Jugar = new JButton("JUGAR");
        Jugar.setBounds(2, 5, 100, 40);
        Cargar = new JButton("CARGAR");
        Cargar.setBounds(2, 55, 100, 40);
        Ayuda = new JButton("AYUDA");
        Ayuda.setBounds(2, 105, 100, 40);
         Creditos1 = new JButton("CREDITOS");
        Creditos1.setBounds(2, 160, 100, 40);

        Jugar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ent = true;
                String resp = (String) JOptionPane.showInputDialog(null, "Ingrese Nombre del Jugador");

                if (resp != null && !resp.equalsIgnoreCase("")) {

                    Proyecto p = new Proyecto();
                    try {
                        setVisible(false);

                        p.ventana(resp, 160, 370, 2000, 3, 0, 0,true,false,false);
                    } catch (InterruptedException ex) {

                    }
                }

                  
            }
        });
       Ayuda.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
              Ayuda ayu= new Ayuda();
              
                
                
                
                
            }
        });
        add(Jugar);

        Cargar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Proyecto p = new Proyecto();
                CargarPartida c = new CargarPartida();

                try {
                    c.cargarpartida();
                  
                    p.ventana(c.getNombre(), c.ObtX(), c.ObtY(), c.getSalud(), c.getVida(), c.getPuntaje(), c.getMapa(),c.isMundo1(),c.isMundo2(),c.isLevel2());
                } catch (IOException ex) {
                   
                } catch (InterruptedException ex) {
                   
                }
            }

        });
        
        Creditos1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Creditos creditos= new Creditos();
            }

        });
        add(Cargar);
        add(Ayuda); 
        add(Creditos1);
        add(fondo);
      

    }

}
