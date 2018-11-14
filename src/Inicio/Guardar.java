/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inicio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *  Guarda la partida enviando por parametro las posiciones x,y del personaje
 * Ademas del puntaje vida y mapa que tiene el personaje 
 * Nombre del jugador
 * Mundo en el que se encuentra
 * Nivel que tiene desbloqueado
 * @author Yeltsin y Luis
 */
public class Guardar {

    ArrayList<String> Auxiliares = new ArrayList<>();

    public void Cargando(int x, int y, double salud, int vida, int puntaje, int mapa, String Nom,boolean mundo1,boolean mundo2,boolean level2) throws IOException {

        cargando2(Nom);
        File apuntador = new File(Nom+".txt");
        System.out.println("asd");
        FileWriter escritor = new FileWriter(apuntador, true);
        BufferedWriter esc = new BufferedWriter(escritor);
        if (Verificar(Nom) == true) {
            apuntador = new File(Nom+".txt");
            escritor = new FileWriter(apuntador, false);
            esc = new BufferedWriter(escritor);
        }
        //ESTO ES PARA PASAR DE INT A STRING YA QUE ÉL SOLO LEE STRING
        esc.write(Integer.toString(x) + "," + Integer.toString(y) + "," + String.valueOf(salud) + "," + String.valueOf(vida) + "," + Integer.toString(puntaje) + "," + Integer.toString(mapa) + "," + Nom+","+String.valueOf(mundo1)+","+String.valueOf(mundo2)+","+String.valueOf(level2));
        esc.flush();
        esc.close();

    }

    public void cargando2(String Nom) throws IOException {
        File apuntador2 = new File("Guardar/Jugadores.txt");

        FileWriter escritor = new FileWriter(apuntador2, true);
        BufferedWriter esc = new BufferedWriter(escritor);
        esc.write(Nom);
        esc.write("\r\n");
        esc.close();
    }

    public boolean Verificar(String Nom) throws FileNotFoundException, IOException {
        BufferedReader archivo = new BufferedReader(new FileReader("Guardar/Jugadores.txt"));
        String auxiliar = archivo.readLine();
        boolean bandera = false;
        while (auxiliar != null) {
            Auxiliares.add(auxiliar);
            auxiliar = archivo.readLine();

        }
        archivo.close();
        for (int i = 0; i < Auxiliares.size(); i++) {
            if (Auxiliares.get(i).equals(Nom)) {
                bandera = true;
            } else {
                bandera = false;
            }
        }
        return bandera;
    }


}
