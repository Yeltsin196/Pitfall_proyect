package Proyecto;

import Inicio.Inicio;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.lang.Thread.sleep;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
/**
 * Personaje utilizado el cual ejerce acciones de movimiento
 * Saltos, caminata izquierda, derecha , choques con otros objetos
 * Atributos como Salud
 * @author Yeltsin y Luis
 */
public class Muñeco extends JPanel {

    Image imagenD[] = new Image[3];
    Image imagenI[] = new Image[3];
    Timer t;
    int x, y, ancho, alto, altura, i, tamano = 2;
    int piso2 = 550, bajada = 180, piso1 = 370, piso = 0, vuelo = 55, caida = 40, desplazamientox = 35;
    boolean muriendo = false;
    boolean derecha = true, izquierda = true,caminarDere=false,caminarIzq=false;
           
    boolean Conllave=false,saltando = false, enEscalera = false, escaBaja = false, escaSube = false, enLiana = false, bajandoLiana = false;
    int auxiliarvuelo;
    Timer salto;
    double Salud = 3000;
    int vidas = 3;
    int puntaje = 0;

    public Muñeco(int x, int y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void cargar() {

        imagenD[0] = new ImageIcon(getClass().getResource("/Imagenes/ironman.png")).getImage();
        imagenD[1] = new ImageIcon(getClass().getResource("/Imagenes/ironman1.png")).getImage();
        imagenD[2] = new ImageIcon(getClass().getResource("/Imagenes/ironman2.png")).getImage();

        imagenI[0] = new ImageIcon(getClass().getResource("/Imagenes/ironmann.png")).getImage();
        imagenI[1] = new ImageIcon(getClass().getResource("/Imagenes/ironmann1.png")).getImage();
        imagenI[2] = new ImageIcon(getClass().getResource("/Imagenes/ironmann2.png")).getImage();
    }

    public void mover(KeyEvent e) throws InterruptedException {

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (enEscalera == true) {
                y += 20;
                if (y >= piso2) {
                    y = piso2;
                }
                escaBaja = true;
                escaSube = false;

            }
            if (enLiana == true) {
                y = piso1;
            }

        }

        if (e.getKeyCode() == KeyEvent.VK_UP && enEscalera == true) {
            y -= 20;
            if (y <= piso1) {
                y = piso1;
            }

            escaSube = true;
            escaBaja = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT && izquierda == true && (y == piso1 || y == piso2 || saltando == true)) {
            enEscalera = false;
            if (i == tamano) {
                i = 0;
            }
            i++;

            this.x -= desplazamientox;
            if (enLiana == true) {
                this.x -= 15;
            }
            caminarDere=false;
            caminarIzq=true;
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT && derecha == true && (y == piso1 || y == piso2 || saltando == true)) {
            enEscalera = false;
            if (i == tamano) {
                i = 0;
            }
            i++;

            x += desplazamientox;
            if (enLiana == true) {
                this.x += 15;
            }
            caminarDere=true;
            caminarIzq=false;
        }

        if (e.getKeyCode() == KeyEvent.VK_SPACE && saltando == false) {
            saltando = true;
            salto();
        }
        enLiana = false;
    }
    boolean alPiso = false;

    public void salto() {

        salto = new Timer(25, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                if (y <= piso1) {
                    if (y <= 280) {
                        alPiso = true;
                    }

                    if (alPiso == false) {
                        y -= 7;
                    } else {
                        y += 7;
                        if (y >= piso1) {
                            salto.stop();
                            alPiso = false;
                            saltando = false;

                        }

                    }
                } else if (y > piso1 && y <= piso2) {
                    if (y <= piso2 - 50) {
                        alPiso = true;
                    }
                    if (alPiso == false) {
                        y -= 5;
                    } else {
                        y += 5;
                        if (y >= piso2) {
                            salto.stop();
                            alPiso = false;
                            saltando = false;
                        }
                    }

                }

            }
        });
        salto.start();

    }

    public void bajada() {
        y = piso2;

    }

    public void paint(Graphics g2) {
        super.paint(g2);
        Graphics2D g = (Graphics2D) g2;
        // g2.drawRect(x, y, ancho-5, alto + 5);
        if(caminarDere){
        g.drawImage(imagenD[i], this.x, this.y, null);
        }else{
        g.drawImage(imagenI[i], this.x, this.y, null);
        }
        repaint();
    }

    public Rectangle getBounds() {

        return new Rectangle(x, y, ancho - 5, alto + 5);
    }

    public void enHueco(Hueco hueco) {
        if (this.getBounds().intersects(hueco.getBounds())) {
            Salud -= 50;
            bajada();

        }

    }
    public int enHueco2(Hueco hueco, int i) {
        if (this.getBounds().intersects(hueco.getBounds())) {
           x=160;
           y=370;
           vidas-=1;
           return 0;
        }else{
        return i;
        }

    }

    public void enEscalera(Escalera escalera) {

        if (this.getBounds().intersects(escalera.getBounds()) && saltando == false) {
            enEscalera = true;
            if (escaBaja == true) {
                if (y >= piso2) {
                    y = piso2;

                }
            }
            if (escaSube == true) {
                if (y <= piso1) {
                    y = piso1;
                }
            }
        }

    }

    public void picadaEscorpion(Escorpion escorpion) {
        if (this.getBounds().intersects(escorpion.getBounds())) {
            Salud -= 0.2;
        }

    }

    public void choqueTronco(Troncos tronco) {

        if (this.getBounds().intersects(tronco.getBounds())) {
            Salud -= 0.2;
        }

    }

    public void choqueSierra(Sierra sierra) {

        if (this.getBounds().intersects(sierra.getBounds()) && sierra.girando == true) {
            vidas -= 1;
            this.setX(160);

        }
    }

    public void choqueMuro(Muro muro) {

        if (this.getBounds().intersects(muro.getBounds())) {
            x +=10;
        }

    }
    public void choqueMuro2(Muro muro){
    if (this.getBounds().intersects(muro.getBounds())) {
            x -=5;
        }
    }
    public void ayuda(panelAyuda panelayuda){
    
    if(this.getBounds().intersects(panelayuda.getBounds())){
        panelayuda.visible=true;
    }else{
        panelayuda.visible=false;
    }
    
    }
    public void enLiana(Liana liana) {

        if (this.getBounds().intersects(liana.getBounds())) {
            this.x = (int) liana.obtX();
            this.y = (int) liana.obtY();
            enLiana = true;
        }

    }

    public void agarrarCoint(Coins coin) {

        if (this.getBounds().intersects(coin.getBounds()) && coin.visible==true) {
            puntaje += 1;
            coin.cambiarEstado(false);
        }

    }

    public int caidaHoyo(Hoyo hoyo, int i) {

        if (this.getBounds().intersects(hoyo.getBounds())) {
            y = piso2;
            vidas -= 1;
            x = 160;
            y = 370;
            return 0;
        } else {
            return i;
        }

    }
    public void caidaHoyo2(Hoyo hoyo){
       if (this.getBounds().intersects(hoyo.getBounds())) {
       y=piso2;
       }
    
    }
    
    public void golpeado(Hulk hulk){
    
    if(this.getBounds().intersects(hulk.getBounds()) && hulk.i==1){
        Salud-=20;
        x-=15;
        
    }
    if(this.getBounds().intersects(hulk.getBounds()) && hulk.i==0){
        x-=2;
    }
    }
    
    public void golpeado2(Hulk hulk){
    
    if(this.getBounds().intersects(hulk.getBounds()) && hulk.i==1){
    vidas-=1;
    x=160;
    y=370;
    }
    }
    public void agarrarLlave(Llave llave){
    if(this.getBounds().intersects(llave.getBounds())){
    llave.visible=false;
    Conllave=true;
    }
    }
    public void Danger(Danger danger){
    
    if(this.getBounds().intersects(danger.getBounds())){
      danger.visible=true;  
    }else{
        danger.visible=false;
    }
    
    }
}
