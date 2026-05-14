package Pantalles;

import Cartes.Carta;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PantallaJoc extends JPanel {

    private JButton primeraCarta = null;
    private JButton segonaCarta = null;

    private boolean bloqueig = false;

    private int parellesTrobades = 0;
    private int moviments = 0;
    private int segons = 0;

    int dificultat = PantallaDificultat.dificultat;

    private ImageIcon revers;

    private JLabel labelTemps;
    private JLabel labelPunts;
    private JLabel labelMoviments;
    private Timer timerTemps;


    public PantallaJoc(JPanel contenedor) {
        setLayout(new BorderLayout());

        dificultat = 1;

        JPanel panelSuperior = new JPanel();

        panelSuperior.setPreferredSize(new Dimension(0, 80));

        labelTemps = new JLabel("Temps: 0");
        labelPunts = new JLabel("Parelles: 0");
        labelMoviments = new JLabel("Moviments: 0");

        labelTemps.setFont(new Font("Arial", Font.BOLD, 20));
        labelPunts.setFont(new Font("Arial", Font.BOLD, 20));
        labelMoviments.setFont(new Font("Arial", Font.BOLD, 20));


        panelSuperior.add(labelTemps);
        panelSuperior.add(Box.createHorizontalStrut(50));
        panelSuperior.add(labelPunts);
        panelSuperior.add(Box.createHorizontalStrut(50));
        panelSuperior.add(labelMoviments);

        add(panelSuperior, BorderLayout.NORTH);

        JPanel tauler = new JPanel();

        if (dificultat == 1) {
            tauler.setLayout(new GridLayout(4, 4, 15, 15));
        } else if (dificultat ==2 ) {
            tauler.setLayout(new GridLayout(4, 5, 10, 10));
        } else if (dificultat ==3) {
            tauler.setLayout(new GridLayout(4, 6, 5, 5));
        }

        tauler.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));


        List<Carta> baralla = donarCartes();

        for (Carta carta : baralla) {

            JButton fruita = new JButton();

            fruita.setBackground(Color.WHITE);
            fruita.setFocusPainted(false);
            fruita.setBorder(
                    BorderFactory.createLineBorder(Color.BLACK, 2)
            );
            fruita.setFocusable(false);

            fruita.setIcon(revers);

            fruita.putClientProperty("carta", carta);

            fruita.addActionListener(e -> {

                if (bloqueig) return;

                if (fruita == primeraCarta) return;

                Carta c = (Carta) fruita.getClientProperty("carta");

                fruita.setIcon(c.getImatge());


                if (primeraCarta == null) {

                    primeraCarta = fruita;

                } else {

                    segonaCarta = fruita;


                    bloqueig = true;

                    Carta c1 = (Carta) primeraCarta.getClientProperty("carta");
                    Carta c2 = (Carta) segonaCarta.getClientProperty("carta");

                    if (c1.getId().equals(c2.getId())) {

                        parellesCorrectes();
                        comprovarVictoria();

                    } else {

                        parrellesIncorrectes();
                    }
                }
            });

            tauler.add(fruita);
        }

        add(tauler, BorderLayout.CENTER);
    }


    private ImageIcon escalarImatge(String ruta_imatge) {

        ImageIcon imatge = new ImageIcon(ruta_imatge);
        Image imagen = imatge.getImage();
        Image imagenEscalada = imagen.getScaledInstance(128, 128,Image.SCALE_SMOOTH);
        return new ImageIcon(imagenEscalada);
    }

    private List<Carta> totesLesCartes() {

        List<Carta> cartes = new ArrayList<>();

        cartes.add(new Carta("cirera",escalarImatge("src/Fotos/cirera.png")));

        cartes.add(new Carta("maduixa", escalarImatge("src/Fotos/maduixa.png")));

        cartes.add(new Carta("pera", escalarImatge("src/Fotos/pera.png")));

        cartes.add(new Carta("poma", escalarImatge("src/Fotos/poma.png")));

        cartes.add(new Carta("platan", escalarImatge("src/Fotos/platan.png")));

        cartes.add(new Carta("pressec", escalarImatge("src/Fotos/pressec.png")));

        cartes.add(new Carta("raim", escalarImatge("src/Fotos/raim.png")));

        cartes.add(new Carta("taronja", escalarImatge("src/Fotos/taronja.png")));

        cartes.add(new Carta("coco", escalarImatge("src/Fotos/coco.png")));

        cartes.add(new Carta("llimona", escalarImatge("src/Fotos/llimona.png")));

        cartes.add(new Carta("pinya", escalarImatge("src/Fotos/pinya.png")));

        cartes.add(new Carta("pitaia", escalarImatge("src/Fotos/pitaia.png")));

        cartes.add(new Carta("pruna", escalarImatge("src/Fotos/pruna.png")));

        return cartes;
    }

    private List<Carta> donarCartes() {
        int parellesNecessaries = 0;
        revers = escalarImatge("src/Fotos/logo.png");

        List<Carta> totes = totesLesCartes();

        Collections.shuffle(totes);

        List<Carta> baralla = new ArrayList<>();
        if (dificultat == 1) {
            parellesNecessaries = 8;
        }else if (dificultat ==2) {
            parellesNecessaries = 10;
        } else if (dificultat ==3) {
            parellesNecessaries = 12;
        }

        for (int i = 0; i < parellesNecessaries; i++) {

            Carta carta = totes.get(i);

            baralla.add(carta);

            baralla.add(new Carta(carta.getId(),carta.getImatge()));
        }

        Collections.shuffle(baralla);

        return baralla;
    }

    private void iniciarTemps() {

        timerTemps = new Timer(1000, e -> {

            segons++;

            labelTemps.setText("Temps: " + segons + "s");
        });

        timerTemps.start();
    }

    private void sumarMoviments() {
        moviments++;
        labelMoviments.setText("Moviments: " + moviments);
    }

    private void parellesCorrectes() {
        sumarMoviments();

        primeraCarta.setEnabled(false);
        segonaCarta.setEnabled(false);

        parellesTrobades++;

        primeraCarta = null;
        segonaCarta = null;

        labelPunts.setText("Parelles: " + parellesTrobades);


        bloqueig = false;

    }

    private void parrellesIncorrectes() {
        sumarMoviments();
        Timer timer = new Timer(1000, evt -> {

            primeraCarta.setIcon(revers);
            segonaCarta.setIcon(revers);

            primeraCarta = null;
            segonaCarta = null;

            bloqueig = false;
        });

        timer.setRepeats(false);
        timer.start();
    }

    private void comprovarVictoria() {
        if (parellesTrobades == 8) {
            JOptionPane.showMessageDialog(this,"HAS GUANYAT!");
        }
    }
}