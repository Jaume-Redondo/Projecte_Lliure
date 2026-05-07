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

public class Pantalla_Joc extends JPanel {

    private JButton primeraCarta = null;
    private JButton segonaCarta = null;

    private boolean bloqueig = false;

    private int parellesTrobades = 0;

    private ImageIcon revers;


    public Pantalla_Joc(JPanel contenedor) {

        setLayout(new GridLayout(4, 4));

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

        for (Carta carta : baralla) {

            JButton fruita = new JButton();


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

                        parellesTrobades++;

                        primeraCarta = null;
                        segonaCarta = null;

                        bloqueig = false;

                        if (parellesTrobades == 8) {

                            JOptionPane.showMessageDialog(
                                    this,
                                    "HAS GUANYAT!"
                            );
                        }

                    } else {

                        Timer timer = new javax.swing.Timer(1000, evt -> {

                            primeraCarta.setIcon(revers);
                            segonaCarta.setIcon(revers);

                            primeraCarta = null;
                            segonaCarta = null;

                            bloqueig = false;
                        });

                        timer.setRepeats(false);
                        timer.start();
                    }
                }
            });

            add(fruita);
        }
    }



    private ImageIcon escalarImatge(String ruta_imatge) {

        ImageIcon imatge = new ImageIcon(ruta_imatge);
        Image imagen = imatge.getImage();
        Image imagenEscalada = imagen.getScaledInstance(128, 128,Image.SCALE_SMOOTH);
        return new ImageIcon(imagenEscalada);
    }
}