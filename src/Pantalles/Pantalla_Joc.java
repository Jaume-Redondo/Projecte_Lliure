package Pantalles;

import javax.swing.*;
import java.awt.*;
import java.util.*;
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

    public Pantalla_Joc(JPanel contenedor) {

        setLayout(new GridLayout(4, 4));

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



            fruita.putClientProperty("carta", carta);

            fruita.addActionListener(e -> {
                Carta c = (Carta) fruita.getClientProperty("carta");
                fruita.setIcon(c.imatge);
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