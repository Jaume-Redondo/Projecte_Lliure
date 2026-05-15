package Pantalles;

import Main.Main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PantallaDificultat extends JPanel {

    static int dificultat;

    public PantallaDificultat(JPanel pantalles) {

        setLayout(new BorderLayout());
        Color fons = Color.decode("#1B1B2F");
        setBackground(fons);

        JPanel panelCentre = new JPanel();
        panelCentre.setLayout(new BoxLayout(panelCentre, BoxLayout.Y_AXIS));
        panelCentre.setBackground(fons);
        panelCentre.setBorder(new EmptyBorder(60, 100, 60, 100));

        JLabel titol = new JLabel("SELECCIONA DIFICULTAT");
        titol.setAlignmentX(Component.CENTER_ALIGNMENT);
        titol.setFont(new Font("Poppins", Font.BOLD, 38));
        titol.setForeground(Color.white);
        panelCentre.add(titol);

        panelCentre.add(Box.createVerticalStrut(50));


        JButton botFacil = new JButton("FÀCIL");
        Color verd = Color.decode("#4CAF50");
        estilBoto(botFacil, verd);
        botFacil.addActionListener(e -> {
            dificultat = 1;
            PantallaJoc joc = new PantallaJoc(pantalles);
            pantalles.add(joc, Main.JOC);
            CardLayout cl = (CardLayout) pantalles.getLayout();
            cl.show(pantalles, Main.JOC);
        });
        panelCentre.add(botFacil);

        panelCentre.add(Box.createVerticalStrut(20));

        JButton botNormal = new JButton("NORMAL");
        Color groc = Color.decode("#FFC857");
        estilBoto(botNormal, groc);
        botNormal.addActionListener(e -> {
            dificultat = 2;
            PantallaJoc joc = new PantallaJoc(pantalles);
            pantalles.add(joc, Main.JOC);
            CardLayout cl = (CardLayout) pantalles.getLayout();
            cl.show(pantalles, Main.JOC);
        });
        panelCentre.add(botNormal);

        panelCentre.add(Box.createVerticalStrut(20));

        JButton botDificil = new JButton("DIFÍCIL");
        Color vermell = Color.decode("#D7263D");
        estilBoto(botDificil, vermell);
        botDificil.addActionListener(e -> {
            dificultat = 3;
            PantallaJoc joc = new PantallaJoc(pantalles);
            pantalles.add(joc, Main.JOC);
            CardLayout cl = (CardLayout) pantalles.getLayout();
            cl.show(pantalles, Main.JOC);
        });
        panelCentre.add(botDificil);

        panelCentre.add(Box.createVerticalStrut(40));


        JButton botMenu = new JButton("TORNAR AL MENÚ");
        Color blanc = Color.decode("#EAEAEA");
        estilBoto(botMenu, blanc);
        botMenu.setForeground(Color.black);
        botMenu.addActionListener(e -> {
            CardLayout cl = (CardLayout) pantalles.getLayout();
            cl.show(pantalles, Main.INICI);
        });

        panelCentre.add(botMenu);

        add(panelCentre, BorderLayout.CENTER);
    }

    private void estilBoto(JButton boto, Color color) {
        boto.setAlignmentX(Component.CENTER_ALIGNMENT);
        boto.setMaximumSize(new Dimension(320, 65));
        boto.setBackground(color);
        boto.setForeground(Color.WHITE);
        boto.setFont(new Font("Quicksand", Font.BOLD, 24));
        boto.setFocusPainted(false);
        boto.setBorderPainted(false);
        boto.setFocusable(false);
        boto.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}

