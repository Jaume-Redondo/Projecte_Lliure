package Cartes;


import javax.swing.*;

public class Carta {

    private String id;
    private ImageIcon imatge;

    public Carta(String id, ImageIcon imatge) {

        this.id = id;
        this.imatge = imatge;
    }
    public String getId() {
        return id;
    }
    public ImageIcon getImatge() {
        return imatge;
    }
}