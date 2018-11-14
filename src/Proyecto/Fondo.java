package Proyecto;

import Inicio.Guardar;
import Inicio.ImageLoader;
import Inicio.Inicio;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import static java.lang.Math.random;
import java.net.URL;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
/**
 * Fondo donde se pintan Timer, personaje, troncos, sierras, Modenas o coins , fuego, hulk.
 * Se encuentra el boton guardar partida
 * Forma el cronometro
 * genera llaves y tambien muros
 * Intercambio de mapas principalmente
 * @author Yeltsin y Luis 
 */
public class Fondo extends JPanel implements KeyListener {

    AudioClip menu;

    Inicio n = new Inicio();
    Proyecto p = new Proyecto();
    Timer tmrTiempo;
    Image mapa[] = new Image[4];
    Muñeco per;
    Troncos tr;
    Escalera es;
    Hulk hulk;
    panelAyuda panelayuda;
    Coins[] monedas = new Coins[4];
    Escorpion escorpion;
    Fuego[] fuego = new Fuego[20];
    Paneldatos paneldatos;
    Liana liana;
    Muro muro;
    Llave llave;
    Danger danger;
    Hueco[] hueco = new Hueco[3];
    Hoyo hoyo;
    Sierra[] sierra = new Sierra[3];
    int contLevel = 0;
    int i = 0, number = 0, minut = 3, seg, h = 3;
    String Nom, auxSalud, auxVidas, auxPuntaje;
    JLabel Nombre = new JLabel();
    JLabel Salud = new JLabel();
    JLabel Nivel2 = new JLabel();

    JButton guardar = new JButton("Guardar Partida");
    public int tiempo = 60;
    public JLabel minutos = new JLabel("3");
    public JLabel segundos = new JLabel("60");
    int posxSierra = 150, contHoyo = 0;
    boolean gameOver = false, Level2 = false, mundo1 = true, mundo2 = false, LevelFinal = false, mapas2 = false;
    JLabel Ividas, vidas, Ipuntaje, puntaje;
    ImageIcon images;
    int posX, posY, VidasC, PuntajesC, mapaC;
    double SaludC;

    public Fondo(String Nom, int Xo, int Yo, double SaludI, int VidasI, int PuntI, int mapaI, boolean mundo1, boolean mundo2, boolean level2) throws InterruptedException {
        System.out.println(VidasI);
        this.mundo1 = mundo1;
        this.mundo2 = mundo2;
        this.mapas2 = level2;
        this.posX = Xo;
        this.posY = Yo;
        per = new Muñeco(posX, posY, 47, 85);
        per.vidas = VidasI;
        // System.out.println(getClass().getClassLoader().getResource("Imagenes/men.wav"));
        menu = java.applet.Applet.newAudioClip(getClass().getClassLoader().getResource("Imagenes/men.wav"));
        menu.play();
        per.puntaje = PuntI;
        this.i = mapaI;
        per.Salud = SaludI;
        tmrTiempo = new Timer(1000, new Fondo.ContadorTiempo());
        cargar();
        setFocusable(true);
        addKeyListener(this);
        this.Nom = Nom;
        Nombre.setText(Nom);
        Nombre.setForeground(Color.white);
        Salud.setForeground(Color.white);
        Font fuente = new Font("Calibri", 20, 20);
        Font fuente2 = new Font("Calibri", 18, 18);
        Font fuenteVidas = new Font("Calibri", 30, 30);
        Nombre.setFont(fuente);
        Salud.setFont(fuente2);
        Nombre.setBounds(320, 650, 100, 100);
        Salud.setBounds(400, 680, 100, 100);
        guardar.setBounds(800, 700, 200, 50);
        add(Nombre);
        add(Salud);
        ImageLoader loader = ImageLoader.getInstance();
        ImageIcon icon = loader.getImage(1);
        Ividas = new JLabel(icon);
        Ividas.setBounds(250, 680, 50, 75);
        vidas = new JLabel();
        vidas.setBounds(315, 680, 100, 100);
        vidas.setFont(fuenteVidas);
        vidas.setForeground(Color.WHITE);
        puntaje = new JLabel();
        puntaje.setBounds(570, 680, 500, 100);
        puntaje.setFont(fuente2);
        puntaje.setForeground(Color.WHITE);
        add(Ividas);
        add(vidas);
        add(puntaje);
        for (int j = 0; j < mapa.length; j++) {
            mapa[j] = new ImageIcon(getClass().getResource("/Imagenes/mapa" + j + ".png")).getImage();
        }
    }

    public class ContadorTiempo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            tiempo--;

            //   int min = tiempo / 60;
            seg = tiempo % 60;
            if (seg == 0) {
                minut--;
                tiempo = 60;
            }
            minutos.setText(Integer.toString(minut));

            segundos.setText(Integer.toString(seg));
            repaint();
        }

    }

    public void cargar() throws InterruptedException {
        minutos.setText("3");
        segundos.setText("60");
        tiempo = 60;
        JLabel t = new JLabel("Tiempo:");
        //t.setFont(new Font("Brush Script MT", 0, 25));
        t.setForeground(Color.decode("#000000"));
        t.setBounds(0, 0, 200, 36);

        //minutos.setFont(new Font("Brush Script MT", 0, 30));
        minutos.setForeground(Color.decode("#000000"));
        minutos.setBounds(50, 0, 200, 36);

        JLabel dos_ptos = new JLabel(":");
        //dos_ptos.setFont(new Font("Brush Script MT", 0, 30));
        dos_ptos.setForeground(Color.decode("#000000"));
        dos_ptos.setBounds(58, -1, 200, 36);

        //segundos.setFont(new Font("Brush Script MT", 0, 30));
        segundos.setForeground(Color.decode("#000000"));
        segundos.setBounds(64, 0, 200, 36);

        tmrTiempo.start();

        add(t);
        add(minutos);
        add(dos_ptos);
        add(segundos);
        Random random = new Random();
        number = random.nextInt(100);

        tr = new Troncos(number + 900, 435, 33, 59);
        es = new Escalera(310, 460, 115, 179);
        escorpion = new Escorpion(2, 580, 40, 59);
        es.generarescaleras();
        paneldatos = new Paneldatos(0, 490, 1013, 96);
        posxSierra = 150;
        for (int j = 0; j < sierra.length; j++) {
            sierra[j] = new Sierra(300, 420, 70, 36);
            sierra[j].cargar();
            sierra[j].sierramover();
        }
        posxSierra = 5;

        hueco[0] = new Hueco(650, 455, 89, 49);
        hueco[1] = new Hueco(890, 455, 89, 49);
        hueco[2] = new Hueco(740, 455, 89, 49);
        for (int j = 0; j < hueco.length; j++) {
            hueco[j].cargar();

        }
        liana = new Liana(300, 50);
        int posxFuego = 40;
        for (int j = 0; j < fuego.length; j++) {
            fuego[j] = new Fuego(posxFuego, 607, 32, 38);
            posxFuego += 60;
        }
        muro = new Muro(2, 484, 37, 170);
        hoyo = new Hoyo(450, 460, 435, 49);
        for (int j = 0; j < monedas.length; j++) {
            monedas[j] = new Coins(40, 600, 42, 42);
        }
        hulk = new Hulk(1109, 535, 106, 94);
        panelayuda = new panelAyuda(250, 400, 160, 127);
        danger = new Danger(800, 500, 160, 127);
        llave = new Llave(1080, 600, 60, 34);

        per.cargar();

        tr.cargar();
        paneldatos.cargar();
        paneldatos.mostrar();
        escorpion.cargarimagenes();
        escorpion.moverescorpion();
        tr.troncosmover();
        guardar.setVisible(true);
        guardar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //     Logger.getLogger(Fondo.class.getName()).log(Level.SEVERE, null, ex);

                Guardar a = new Guardar();

                try {
                    a.Cargando(per.x, per.y, per.Salud, per.vidas, per.puntaje, i, Nom, mundo1, mundo2, mapas2);
                } catch (IOException ex) {
                    // Logger.getLogger(Fondo.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null, "Se ha guardado correctamente.");
                System.exit(0);

            }
        });
        add(guardar);
        setLayout(null);

    }

    @Override
    public void paintComponent(Graphics g) {
        if (gameOver == false) {
            Graphics2D g2 = (Graphics2D) g;
            if (mundo1 && mapas2 == false) {
                g2.drawImage(mapa[i], 0, 0, null);
                per.enEscalera(es);

                if (i == 0) {
                    muro.x = 2;
                    muro.paint(g2);
                    panelayuda.paint(g2);
                    per.ayuda(panelayuda);
                    per.choqueMuro(muro);
                    hulk.paint(g2);
                    per.golpeado(hulk);
                    monedas[0].x = 1080;
                    monedas[0].paint(g2);
                    per.agarrarCoint(monedas[0]);
                    per.choqueTronco(tr);
                    es.SetX(310);
                    es.SetY(460);
                    es.paint(g2);
                    hueco[0].x = 650;
                    hueco[0].y = 455;
                    hueco[1].x = 890;
                    hueco[1].y = 455;
                    hueco[0].paint(g2);
                    hueco[1].paint(g2);
                    per.enHueco(hueco[0]);
                    per.enHueco(hueco[1]);
                    tr.paint(g2);
                    escorpion.paint(g2);
                    per.picadaEscorpion(escorpion);
                }
                if (i == 1) {
                    muro.x = 25;
                    muro.paint(g2);
                    per.choqueMuro(muro);
                    monedas[1].x = 478;
                    monedas[1].y = 268;
                    monedas[1].paint(g2);
                    sierra[0].x = 300;
                    sierra[1].x = 450;
                    sierra[2].x = 600;
                    per.agarrarCoint(monedas[1]);
                    per.choqueTronco(tr);
                    for (int j = 0; j < sierra.length; j++) {
                        sierra[j].paint(g2);
                        per.choqueSierra(sierra[j]);
                    }
                    es.SetX(120);
                    es.SetY(460);
                    hueco[2].x = 740;
                    hueco[2].y = 455;
                    hueco[2].paint(g2);
                    per.enHueco(hueco[2]);
                    es.paint(g2);
                    tr.paint(g2);
                    escorpion.paint(g2);
                    per.picadaEscorpion(escorpion);
                }

                if (i == 2) {
                    sierra[0].x = 700;
                    sierra[1].x = 850;
                    sierra[2].x = 1000;
                    for (int j = 0; j < sierra.length; j++) {
                        sierra[j].paint(g2);
                        per.choqueSierra(sierra[j]);
                    }
                    contHoyo++;
                    hueco[2].x = 880;
                    hueco[2].y = 635;
                    if (contHoyo <= 300) {
                        hueco[2].paint(g2);
                        i = per.enHueco2(hueco[2], i);
                    }
                    if (contHoyo == 900) {
                        contHoyo = 0;
                    }
                    monedas[2].x = 1110;
                    monedas[2].y = 600;
                    monedas[2].paint(g2);
                    per.agarrarCoint(monedas[2]);
                    per.enHueco(hueco[0]);
                    per.enHueco(hueco[1]);
                    hueco[1].paint(g2);
                    hueco[1].x = 317;
                    hueco[0].paint(g2);
                    hueco[0].x = 510;
                    es.SetX(400);
                    es.paint(g2);
                    escorpion.paint(g2);
                    per.picadaEscorpion(escorpion);
                }

                if (i == 3) {
                    monedas[3].x = 1090;
                    monedas[3].y = 380;
                    monedas[3].paint(g2);
                    liana.paint(g2);
                    liana.des();
                    per.enLiana(liana);
                    hoyo.paint(g2);
                    i = per.caidaHoyo(hoyo, i);
                    for (int j = 0; j < fuego.length; j++) {
                        fuego[j].paint(g2);
                    }
                    per.agarrarCoint(monedas[3]);
                }
                per.paint(g2);

                paneldatos.paint(g2);
                auxSalud = String.valueOf((int) per.Salud);
                Salud.setText("SALUD: " + auxSalud);
                auxVidas = String.valueOf(per.vidas);
                vidas.setText("x" + auxVidas);
                auxPuntaje = String.valueOf((int) per.puntaje);
                puntaje.setText("PUNTAJE: " + auxPuntaje);

                repaint();

            } else {
                g2.drawImage(mapa[i], 0, 0, null);
                if (i == 0) {
                    muro.x = 1;
                    muro.paint(g2);
                    per.choqueMuro(muro);
                    escorpion.paint(g2);
                    per.picadaEscorpion(escorpion);
                    monedas[0].x = 712;
                    monedas[0].y = 350;
                    monedas[0].paint(g2);
                    per.agarrarCoint(monedas[0]);
                    hueco[0].x = 570;
                    hueco[0].paint(g2);
                    hueco[1].x = 800;
                    hueco[1].paint(g2);
                    per.enHueco(hueco[0]);
                    per.enHueco(hueco[1]);
                    tr.paint(g2);
                    per.choqueTronco(tr);
                }
                if (i == 1) {

                    es.x = 300;
                    es.paint(g2);
                    per.enEscalera(es);
                    per.enEscalera(es);
                    escorpion.paint(g2);
                    sierra[0].x = 420;
                    sierra[0].y = 423;
                    sierra[0].paint(g2);
                    per.choqueSierra(sierra[0]);
                    monedas[1].paint(g2);
                    hulk.paint(g2);
                    per.golpeado2(hulk);
                    danger.paint(g2);
                    per.Danger(danger);
                    tr.paint(g2);
                    per.choqueTronco(tr);
                    per.golpeado(hulk);
                    llave.paint(g2);
                    per.agarrarLlave(llave);
                    per.agarrarCoint(monedas[1]);
                }
                if (i == 2) {
                    tr.paint(g2);
                    per.choqueTronco(tr);
                    hueco[0].x = 300;
                    hueco[0].paint(g2);
                    escorpion.paint(g2);
                    per.enHueco(hueco[0]);
                    per.picadaEscorpion(escorpion);
                    monedas[2].y = 380;
                    monedas[2].x = 350;
                    monedas[2].paint(g2);
                    per.agarrarCoint(monedas[2]);
                    sierra[1].x = 700;
                    sierra[1].y = 423;
                    sierra[2].x = 852;
                    sierra[2].y = 423;
                    sierra[1].paint(g2);
                    sierra[2].paint(g2);
                    per.choqueSierra(sierra[1]);

                }
                if (i == 3) {

                    monedas[3].x = 600;
                    monedas[3].y = 320;
                    monedas[3].paint(g2);
                    per.agarrarCoint(monedas[3]);
                    liana.paint(g2);
                    per.enLiana(liana);
                    hoyo.paint(g2);
                    per.caidaHoyo2(hoyo);
                }
                per.paint(g2);
                repaint();
                paneldatos.paint(g2);
                auxSalud = String.valueOf((int) per.Salud);
                Salud.setText("SALUD: " + auxSalud);
                auxVidas = String.valueOf(per.vidas);
                vidas.setText("x" + auxVidas);
                auxPuntaje = String.valueOf((int) per.puntaje);
                puntaje.setText("PUNTAJE: " + auxPuntaje);
            }
            if (minut == -1 || per.vidas == -1 || per.Salud <= 0) {
                gameOver = true;
            }
        } else {
            g.setColor(Color.black);
            g.fillRect(0, 0, 1218, 800);
            Font fuente2 = new Font("Calibri", 18, 18);
            g.setFont(fuente2);
            g.setColor(Color.white);
            g.drawString("GAME OVER", 500, 300);

        }
        if (LevelFinal == true) {
            g.setColor(Color.black);
            g.fillRect(0, 0, 1218, 800);
            Font fuente2 = new Font("Calibri", 30, 30);
            Nombre.setBounds(540, 200, 100, 100);
            Nombre.setFont(fuente2);
            g.setFont(fuente2);
            g.setColor(Color.white);
            g.drawString("VICTORIA", 500, 300);
            vidas.setLocation(570, 320);
            Ividas.setLocation(510, 320);
            Salud.setLocation(510, 365);
            puntaje.setLocation(510, 390);
        }

        if (Level2 == true) {
            contLevel++;
            g.setColor(Color.black);
            g.fillRect(0, 0, 1218, 800);
            Font fuente2 = new Font("Calibri", 30, 30);
            g.setFont(fuente2);
            g.setColor(Color.white);
            g.drawString("NIVEL 2", 500, 300);
            for (int j = 0; j < monedas.length; j++) {
                monedas[j].visible = true;

            }

            if (contLevel == 400) {
                Level2 = false;
                mundo1 = false;
                mundo2 = true;
                per.x = 160;
                per.y = 370;
                i = 0;
                for (int j = 0; j < mapa.length; j++) {

                    mapa[j] = new ImageIcon(getClass().getResource("/Imagenes/mapa" + h + ".png")).getImage();
                    h--;
                    mapas2 = true;
                }
            }

        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            n.setVisible(true);
        }
        try {
            per.mover(e);

            if (per.getX() >= 1175) {
                if (i != 3) {
                    i++;
                    per.setX(100);
                    per.setY(per.getY());
                    tr.setX(1200);
                }

            } else if (per.getX() < 10 && i != 0) {
                i--;
                per.setX(1140);
                per.setY(per.getY());

            }
            if (per.getX() < 10 && i == 0) {
                per.setX(10);
            }
            if (i == 3 && per.x >= 1140 && mundo1 == true && per.puntaje == 4) {
                Level2 = true;
            }
            if (i == 3 && per.x >= 1140 && per.puntaje < 4) {
                per.x = 1110;
            }
            if (i == 3 && per.x >= 1140 && mundo2 == true && per.puntaje == 8 && per.Conllave == true) {
                LevelFinal = true;
            }

        } catch (InterruptedException ex) {
            //  Logger.getLogger(F
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
