/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inicio;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *Cargar la partida a traves de un archivo de texto linea por linea 
 * donde se encuentran almacenados los diferentes atributos necesarios para continuar la partida
 * @author Yeltsin y Luis
 */
public class CargarPartida extends JFrame {

    private ArrayList<String> nombres = new ArrayList<>();
    private int x, y, vida, puntaje, mapa, cont = 0;
    private double Salud;
    private String nombre;
    private boolean mundo1,mundo2,level2;
    private JComboBox nComboBox;

    public void cargarpartida() throws IOException {
        setLayout(null);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setFocusable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BufferedReader archivo = new BufferedReader(new FileReader("Guardar/Jugadores.txt"));
        String auxiliar = archivo.readLine();

        while (auxiliar != null) {
            nombres.add(auxiliar);

            auxiliar = archivo.readLine();

        }
        archivo.close();
        String[] nombres2 = new String[nombres.size()];
        for (int i = 0; i < nombres.size(); i++) {

            nombres2[i] = nombres.get(i);
        }
        String resp = (String) JOptionPane.showInputDialog(null, "Ingrese Nombre del Jugador");
        Cargando(resp);
        setVisible(true);

    }

    public void Cargando(String nomb) throws FileNotFoundException, IOException {
      //  BufferedReader archivo = new BufferedReader(new FileReader("Guardar/" + nomb + ".txt"));
        BufferedReader archivo = new BufferedReader(new FileReader(nomb+".txt"));
        String auxiliar = archivo.readLine();

        while (auxiliar != null) {
         
            String[] auxiliar2 = auxiliar.split(",");
            x = Integer.parseInt(auxiliar2[0]);
            y = Integer.parseInt(auxiliar2[1]);
            Salud = Double.parseDouble(auxiliar2[2]);
            vida = Integer.parseInt(auxiliar2[3]);
            puntaje = Integer.parseInt(auxiliar2[4]);
            mapa = Integer.parseInt(auxiliar2[5]);
            nombre= auxiliar2[6];
            mundo1=Boolean.parseBoolean(auxiliar2[7]);
            mundo2=Boolean.parseBoolean(auxiliar2[8]);
            level2=Boolean.parseBoolean(auxiliar2[9]);
            auxiliar = archivo.readLine();

        }
        archivo.close();

    }
    
    public int ObtX() {
        return this.x;
    }

    public boolean isLevel2() {
        return level2;
    }

    public int ObtY() {
        return this.y;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public int getMapa() {
        return mapa;
    }

    public double getSalud() {
        return Salud;
    }

    public boolean isMundo1() {
        return mundo1;
    }

    public boolean isMundo2() {
        return mundo2;
    }
    
    
    public boolean validando(String Nom) throws FileNotFoundException, IOException {
        BufferedReader archivo = new BufferedReader(new FileReader("Guardar/Jugadores.txt"));
        String auxiliar = archivo.readLine();
        boolean bandera = false;
        while (auxiliar != null) {

            if (Nom.equalsIgnoreCase(auxiliar)) {
                bandera = true;
                auxiliar = null;
            } else {
                bandera = false;
                auxiliar = archivo.readLine();
            }

        }
        archivo.close();
        return bandera;
    }

}
