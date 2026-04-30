package Form;

import javax.swing.*;
import java.awt.*;

public class PantallaInici extends JPanel {

    public PantallaInici() {
        setPreferredSize(new Dimension(800, 800));
        setLayout(null);
        setBackground(Color.gray);

        JButton botIniciar = new JButton("Iniciar");
        botIniciar.setBounds(300, 200, 200, 50);
        botIniciar.setBackground(Color.red);
        botIniciar.setFont(new Font("Arial", Font.PLAIN, 20));
        add(botIniciar);

        JButton botSalir = new JButton("Salir");
        botSalir.setBounds(300, 300, 200, 50);
        botSalir.setBackground(Color.blue);
        botSalir.setFont(new Font("Arial", Font.BOLD, 20));
        add(botSalir);
    }
}
