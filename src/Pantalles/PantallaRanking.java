package Pantalles;

import Main.Base_Dades;
import Main.Main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PantallaRanking extends JPanel {

    private final Color fons = Color.decode("#1B1B2F");
    private final Color textColor = Color.WHITE;

    public PantallaRanking(JPanel pantalles) {

        setLayout(new BorderLayout());
        setBackground(fons);

        JLabel titol = new JLabel("🏆 RANKING TOP 10");
        titol.setHorizontalAlignment(SwingConstants.CENTER);
        titol.setFont(new Font("Quicksand", Font.BOLD, 32));
        titol.setForeground(Color.WHITE);
        add(titol, BorderLayout.NORTH);

        JPanel centre = new JPanel();
        centre.setLayout(new BoxLayout(centre, BoxLayout.Y_AXIS));
        centre.setBackground(fons);

        ArrayList<String[]> ranking = Base_Dades.getRanking();

        int pos = 1;

        for (String[] fila : ranking) {

            String user = fila[0];
            String dif = convertirDificultat(Integer.parseInt(fila[1]));
            String mov = fila[2];
            String temps = fila[3];

            JLabel label = new JLabel(
                    pos + ". " + user +
                            " | Dificultat: " + dif +
                            " | Moviments: " + mov +
                            " | Temps: " + temps + "s"
            );

            label.setFont(new Font("Quicksand", Font.PLAIN, 18));
            label.setForeground(textColor);
            label.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));

            centre.add(label);
            pos++;
        }

        JScrollPane scroll = new JScrollPane(centre);
        scroll.setBorder(null);
        add(scroll, BorderLayout.CENTER);

        JButton tornar = new JButton("TORNAR");
        tornar.addActionListener(e -> {
            CardLayout cl = (CardLayout) pantalles.getLayout();
            cl.show(pantalles, Main.INICI);
        });

        add(tornar, BorderLayout.SOUTH);
    }

    private String convertirDificultat(int d) {
        return switch (d) {
            case 1 -> "Fàcil";
            case 2 -> "Normal";
            case 3 -> "Difícil";
            default -> "Desconegut";
        };
    }
}