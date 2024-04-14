package gui;

import javax.swing.*;
import java.awt.*;
import controlleur.GeoAnalytiqueControleur;
import model.GeoObject;
import view.GeoAnalytiqueView;

public class GeoAnalytiqueGUI {
    private GeoAnalytiqueControleur controleur;
    private GeoAnalytiqueView view;
    private JFrame fenetre;

    public GeoAnalytiqueGUI(GeoAnalytiqueControleur controleur) {
        this.controleur = controleur;
        this.view = new GeoAnalytiqueView();

        // Afficher le message de bienvenue
        JOptionPane.showMessageDialog(null, "Bienvenue dans votre logiciel de dessin", "Bienvenue", JOptionPane.PLAIN_MESSAGE);

        fenetre = new JFrame("GéoAnalytique");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(800, 600);

        // Ajout de la vue à la fenêtre
        fenetre.add(view);

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
    }

    public void ajouterObjet(GeoObject objet) {
        controleur.addObjet(objet);
        view.repaint();
    }

    public void setVisible(boolean visible) {
        fenetre.setVisible(visible);
    }
}