package Pantalles;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Carta {
    String id;
    ImageIcon imatge;

    public Carta(String id, ImageIcon imatge) {
        this.id = id;
        this.imatge = imatge;
    }
}

public class PantallaJoc extends JPanel {

    private JButton primeraCarta = null;
    private JButton segonaCarta = null;

    private boolean bloqueig = false;

    private int parellesTrobades = 0;
    int dificultat = PantallaDificultat.dificultat;

    private ImageIcon revers;

    private JLabel labelTemps;
    private JLabel labelPunts;


    public PantallaJoc(JPanel contenedor) {
        setLayout(new BorderLayout());

        JPanel panelSuperior = new JPanel();

        panelSuperior.setPreferredSize(new Dimension(0, 80));

        labelTemps = new JLabel("Temps: 0");
        labelPunts = new JLabel("Parelles: 0");

        labelTemps.setFont(new Font("Arial", Font.BOLD, 20));
        labelPunts.setFont(new Font("Arial", Font.BOLD, 20));

        panelSuperior.add(labelTemps);
        panelSuperior.add(Box.createHorizontalStrut(50));
        panelSuperior.add(labelPunts);

        add(panelSuperior, BorderLayout.NORTH);

        JPanel tauler = new JPanel();

        // 🔥 aquí luego cambiarás 4x4 / 6x6 / 8x8
        tauler.setLayout(new GridLayout(4, 4, 10, 10));

        tauler.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));


        List<Carta> baralla = donarCartes();

        for (Carta carta : baralla) {

            JButton fruita = new JButton();

            // SOLO VISUAL, HAY QUE CAMBIARLO
            fruita.setBackground(Color.WHITE);
            fruita.setFocusPainted(false);

            fruita.setIcon(revers);

            fruita.putClientProperty("carta", carta);

            fruita.addActionListener(e -> {

                if (bloqueig) return;

                if (fruita == primeraCarta) return;

                Carta c = (Carta) fruita.getClientProperty("carta");

                fruita.setIcon(c.imatge);

                if (primeraCarta == null) {

                    primeraCarta = fruita;

                } else {

                    segonaCarta = fruita;

                    bloqueig = true;

                    Carta c1 = (Carta) primeraCarta.getClientProperty("carta");
                    Carta c2 = (Carta) segonaCarta.getClientProperty("carta");

                    if (c1.id.equals(c2.id)) {

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

    private List<Carta> donarCartes() {
        revers = escalarImatge("src/Fotos/logo.png");

        List<Carta> baralla = new ArrayList<>();

        baralla.add(new Carta("cirera", escalarImatge("src/Fotos/cirera.png")));
        baralla.add(new Carta("cirera", escalarImatge("src/Fotos/cirera.png")));

        baralla.add(new Carta("maduixa", escalarImatge("src/Fotos/maduixa.png")));
        baralla.add(new Carta("maduixa", escalarImatge("src/Fotos/maduixa.png")));

        baralla.add(new Carta("pera", escalarImatge("src/Fotos/pera.png")));
        baralla.add(new Carta("pera", escalarImatge("src/Fotos/pera.png")));

        baralla.add(new Carta("poma", escalarImatge("src/Fotos/poma.png")));
        baralla.add(new Carta("poma", escalarImatge("src/Fotos/poma.png")));

        baralla.add(new Carta("platan", escalarImatge("src/Fotos/platan.png")));
        baralla.add(new Carta("platan", escalarImatge("src/Fotos/platan.png")));

        baralla.add(new Carta("pressec", escalarImatge("src/Fotos/pressec.png")));
        baralla.add(new Carta("pressec", escalarImatge("src/Fotos/pressec.png")));

        baralla.add(new Carta("raim", escalarImatge("src/Fotos/raim.png")));
        baralla.add(new Carta("raim", escalarImatge("src/Fotos/raim.png")));

        baralla.add(new Carta("taronja", escalarImatge("src/Fotos/taronja.png")));
        baralla.add(new Carta("taronja", escalarImatge("src/Fotos/taronja.png")));

        Collections.shuffle(baralla);
        return baralla;
    }

    private void parellesCorrectes() {
        primeraCarta.setEnabled(false);
        segonaCarta.setEnabled(false);

        parellesTrobades++;

        primeraCarta = null;
        segonaCarta = null;

        labelPunts.setText("Parelles: " + parellesTrobades);

        bloqueig = false;

    }

    private void parrellesIncorrectes() {
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