package gui;

import javax.swing.*;
import java.awt.*;

public class GeoAnalytiqueGUI {
    public static void main(String[] args) {
        JFrame fenetre = new JFrame("GéoAnalytique");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(800, 600);

        // Création de la zone de dessin
        JPanel zoneDessin = new JPanel();
        fenetre.add(zoneDessin);

        // Création de la barre d'outils
        JToolBar barreOutils = new JToolBar();
        fenetre.add(barreOutils, BorderLayout.NORTH);

        // Ajout de boutons pour chaque type de forme
        barreOutils.add(new JButton("Point"));
        barreOutils.add(new JButton("Ligne"));
        barreOutils.add(new JButton("Cercle"));
        barreOutils.add(new JButton("Triangle Isocèle"));
        barreOutils.add(new JButton("Triangle Équilatéral"));
        barreOutils.add(new JButton("Triangle Rectangle"));
        barreOutils.add(new JButton("Ellipse"));
        barreOutils.add(new JButton("Rectangle"));
        barreOutils.add(new JButton("Carré"));
        barreOutils.add(new JButton("Droite"));
        barreOutils.add(new JButton("Segment"));

        fenetre.setVisible(true);
    }
}