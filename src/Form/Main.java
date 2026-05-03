package Form;

import Pantalles.Pantalla_Inici;
import Pantalles.Pantalla_Joc;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static final String INICI = "inici";
    public static final String JOC = "joc";

    public static void main(String[] args) {

        JFrame frame = new JFrame("Memory");

        JPanel pantalles = new JPanel(new CardLayout());

        Pantalla_Inici inici = new Pantalla_Inici(pantalles);
        Pantalla_Joc joc = new Pantalla_Joc(pantalles);

        pantalles.add(inici,INICI);
        pantalles.add(joc,JOC);

        frame.setContentPane(pantalles);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}