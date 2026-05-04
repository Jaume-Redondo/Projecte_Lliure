package Pantalles;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

class Carta {
    String id;
    ImageIcon imagen;

    public Carta(String id, ImageIcon imagen) {
        this.id = id;
        this.imagen = imagen;
    }
}

public class Pantalla_Joc extends JPanel {

    public Pantalla_Joc(JPanel contenedor) {

        setLayout(new GridLayout(4, 4));

        List<Carta> baralla = new ArrayList<>();


        baralla.add(new Carta("manzana", new ImageIcon("src/Fotos/manzana.png")));
        baralla.add(new Carta("manzana", new ImageIcon("src/Fotos/manzana.png")));

        baralla.add(new Carta("limon", new ImageIcon("src/Fotos/limon.png")));
        baralla.add(new Carta("limon", new ImageIcon("src/Fotos/limon.png")));

        baralla.add(new Carta("platano", new ImageIcon("src/Fotos/platano.png")));
        baralla.add(new Carta("platano", new ImageIcon("src/Fotos/platano.png")));

        baralla.add(new Carta("uva", new ImageIcon("src/Fotos/uva.png")));
        baralla.add(new Carta("uva", new ImageIcon("src/Fotos/uva.png")));

        baralla.add(new Carta("sandia", new ImageIcon("src/Fotos/sandia.png")));
        baralla.add(new Carta("sandia", new ImageIcon("src/Fotos/sandia.png")));

        baralla.add(new Carta("pera", new ImageIcon("src/Fotos/pera.png")));
        baralla.add(new Carta("pera", new ImageIcon("src/Fotos/pera.png")));

        baralla.add(new Carta("cereza", new ImageIcon("src/Fotos/cereza.png")));
        baralla.add(new Carta("cereza", new ImageIcon("src/Fotos/cereza.png")));

        baralla.add(new Carta("piña", new ImageIcon("src/Fotos/piña.png")));
        baralla.add(new Carta("piña", new ImageIcon("src/Fotos/piña.png")));

        Collections.shuffle(baralla);

        for (Carta carta : baralla) {

            JButton fruita = new JButton();


            fruita.setBackground(Color.WHITE);
            fruita.setFocusPainted(false);


            fruita.putClientProperty("carta", carta);

            fruita.addActionListener(e -> {
                Carta c = (Carta) fruita.getClientProperty("carta");
                fruita.setIcon(c.imagen);
            });

            add(fruita);
        }
    }
}