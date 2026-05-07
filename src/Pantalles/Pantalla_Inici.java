package Pantalles;

import Form.Main;

import javax.swing.*;
import java.awt.*;

public class Pantalla_Inici extends JPanel {

    public Pantalla_Inici(JPanel pantalles) {

        setLayout(null);
        setBackground(Color.gray);

        JButton botIniciar = new JButton("Iniciar");
        botIniciar.setBounds(300, 200, 200, 50);
        botIniciar.setBackground(Color.red);
        botIniciar.setFont(new Font("Arial", Font.PLAIN, 20));
        add(botIniciar);

        JButton botSalir = new JButton("Sortir");
        botSalir.setBounds(300, 300, 200, 50);
        botSalir.setBackground(Color.blue);
        botSalir.setFont(new Font("Arial", Font.BOLD, 20));
        add(botSalir);

        botIniciar.addActionListener(e -> {
            CardLayout cl = (CardLayout) (pantalles.getLayout());
            cl.show(pantalles, Main.JOC);
        });

        botSalir.addActionListener(e -> { System.exit(0); });

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        GradientPaint gp = new GradientPaint(
                0, 0, new Color(26, 155, 142),
                0, getHeight(), new Color(21, 128, 115)
        );
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }
}
