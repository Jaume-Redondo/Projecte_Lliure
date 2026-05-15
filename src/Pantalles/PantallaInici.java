package Pantalles;

import Main.Main;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class PantallaInici extends JPanel {

    private final Color teal = Color.decode("#1A9B8E");
    private final Color coral = Color.decode("#E8764D");
    private final Color textFosc = Color.decode("#1E293B");

    public static String nomUsuari = "";

    public PantallaInici(JPanel pantalles) {

        setLayout(new BorderLayout());
        setBackground(Color.white);

        JPanel panelCentre = new JPanel();

        panelCentre.setLayout(new BoxLayout(panelCentre, BoxLayout.Y_AXIS));
        panelCentre.setBorder(new EmptyBorder(40, 100, 40, 100));

        ImageIcon logo = new ImageIcon("src/Fotos/logo.png");
        Image imagen = logo.getImage();
        Image imagenEscalada = imagen.getScaledInstance(200,200,Image.SCALE_REPLICATE);
        logo = new ImageIcon(imagenEscalada);
        JLabel titol = new JLabel(logo);
        titol.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitol = new JLabel("Juga i aprèn amb Pair Up!");
        subtitol.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitol.setFont(new Font("Quicksand", Font.BOLD, 22));
        subtitol.setForeground(textFosc);

        panelCentre.add(titol);
        panelCentre.add(Box.createVerticalStrut(15));
        panelCentre.add(subtitol);
        panelCentre.add(Box.createVerticalStrut(60));


        JLabel textNom = new JLabel("Introdueix el teu nom:");
        textNom.setAlignmentX(Component.CENTER_ALIGNMENT);
        textNom.setFont(new Font("Quicksand", Font.BOLD, 18));
        textNom.setForeground(textFosc);

        panelCentre.add(textNom);
        panelCentre.add(Box.createVerticalStrut(10));

        JTextField campNom = new JTextField();
        campNom.setMaximumSize(new Dimension(260, 40));
        campNom.setFont(new Font("Quicksand", Font.PLAIN, 18));
        campNom.setHorizontalAlignment(JTextField.CENTER);

        panelCentre.add(campNom);
        panelCentre.add(Box.createVerticalStrut(40));


        JButton botIniciar = new JButton("INICIAR");
        estilBotoPrincipal(botIniciar);
        botIniciar.addActionListener(e -> {
            String nom = campNom.getText().trim();
            if (nom.isEmpty()) {
                JOptionPane.showMessageDialog(null,"Has d'introduir un nom");
                return;
            }
            nomUsuari = nom;
            CardLayout cl = (CardLayout) (pantalles.getLayout());
            cl.show(pantalles, Main.DIFICULTAT);
        });
        panelCentre.add(botIniciar);
        panelCentre.add(Box.createVerticalStrut(30));


        JButton botSortir = new JButton("SORTIR");
        estilBotoSecundari(botSortir);
        botSortir.addActionListener(e -> {
            System.exit(0);
        });
        panelCentre.add(botSortir);

        add(panelCentre, BorderLayout.CENTER);
    }


    private void estilBaseBoto(JButton boto) {
        boto.setAlignmentX(Component.CENTER_ALIGNMENT);
        boto.setMaximumSize(new Dimension(260, 60));
        boto.setForeground(Color.WHITE);
        boto.setFont(new Font("Quicksand", Font.BOLD, 22));
        boto.setFocusPainted(false);
        boto.setBorderPainted(false);
        boto.setFocusable(false);
        boto.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void estilBotoPrincipal(JButton boto) {
        estilBaseBoto(boto);
        boto.setBackground(teal);
    }

    private void estilBotoSecundari(JButton boto) {
        estilBaseBoto(boto);
        boto.setBackground(coral);
    }

}
