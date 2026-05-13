package Pantalles;

import Main.Main;

import javax.swing.*;
import java.awt.*;

public class PantallaDificultat extends JPanel {

    static int dificultat;

    public PantallaDificultat(JPanel pantalles) {

        setLayout(null);
        setBackground(Color.gray);

        JButton botFacil = new JButton("Facil");
        botFacil.setBounds(300, 200, 200, 50);
        botFacil.setBackground(Color.red);
        botFacil.setFont(new Font("Arial", Font.PLAIN, 20));
        add(botFacil);

        JButton botNormal = new JButton("Sortir");
        botNormal.setBounds(300, 300, 200, 50);
        botNormal.setBackground(Color.blue);
        botNormal.setFont(new Font("Arial", Font.BOLD, 20));
        add(botNormal);

        JButton BotDificil = new JButton("Sortir");
        BotDificil.setBounds(300, 300, 200, 50);
        BotDificil.setBackground(Color.blue);
        BotDificil.setFont(new Font("Arial", Font.BOLD, 20));
        add(BotDificil);

        // MENU CAMBIAR
        botFacil.addActionListener(e -> {
            CardLayout cl = (CardLayout) (pantalles.getLayout());
            cl.show(pantalles, Main.DIFICULTAT);
            dificultat= 1;
        });

        botNormal.addActionListener(e -> {
            CardLayout cl = (CardLayout) (pantalles.getLayout());
            cl.show(pantalles, Main.DIFICULTAT);
            dificultat= 2;
        });

        BotDificil.addActionListener(e -> {
            CardLayout cl = (CardLayout) (pantalles.getLayout());
            cl.show(pantalles, Main.DIFICULTAT);
            dificultat= 3;
        });
    }
}
