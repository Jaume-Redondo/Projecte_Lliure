package Main;

import Pantalles.PantallaDificultat;
import Pantalles.PantallaInici;
import Pantalles.PantallaJoc;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static final String INICI = "inici";
    public static final String DIFICULTAT = "dificultat";
    public static final String JOC = "joc";

    public static void main(String[] args) {

        JFrame frame = new JFrame("Memory");

        JPanel pantalles = new JPanel(new CardLayout());

        PantallaInici inici = new PantallaInici(pantalles);
        PantallaDificultat dificultat = new PantallaDificultat(pantalles);
        PantallaJoc joc = new PantallaJoc(pantalles);

        pantalles.add(inici,INICI);
        pantalles.add(dificultat,DIFICULTAT);
        pantalles.add(joc,JOC);

        frame.setContentPane(pantalles);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}