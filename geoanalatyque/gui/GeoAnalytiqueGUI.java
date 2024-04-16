package gui;

import javax.swing.*;
import java.awt.*;
import controlleur.GeoAnalytiqueControleur;
import exception.VisiteurException;
import graphique.GLigne;
import model.Droite;
import model.GeoObject;
import view.GeoAnalytiqueView;
import java.awt.event.ActionListener;

public class GeoAnalytiqueGUI {
    private GeoAnalytiqueControleur controleur;
    private GeoAnalytiqueView view;
    private JFrame fenetre;

    public GeoAnalytiqueGUI(GeoAnalytiqueControleur controleur) {
        this.controleur = controleur;
        this.view = new GeoAnalytiqueView();
        view.setControleur(controleur);
        controleur.setView(view);

        // Afficher le message de bienvenue
        JOptionPane.showMessageDialog(null, "Bienvenue dans votre logiciel de dessin", "Bienvenue",
                JOptionPane.PLAIN_MESSAGE);

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
        JButton boutonLigne = new JButton("Ligne");
        boutonLigne.addActionListener(e -> {
            // Créer une boîte de dialogue personnalisée
            JTextField champX1 = new JTextField();
            JTextField champY1 = new JTextField();
            JTextField champX2 = new JTextField();
            JTextField champY2 = new JTextField();
            Object[] message = {
                    "x1:", champX1,
                    "y1:", champY1,
                    "x2:", champX2,
                    "y2:", champY2
            };
            int option = JOptionPane.showConfirmDialog(null, message, "Veuillez entrer les coordonnées des deux points",
                    JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                // Parser les coordonnées
                int x1 = Integer.parseInt(champX1.getText());
                int y1 = Integer.parseInt(champY1.getText());
                int x2 = Integer.parseInt(champX2.getText());
                int y2 = Integer.parseInt(champY2.getText());
                GeoObject objet = new Droite(new model.Point(0, 0), new model.Point(100, 100));
                // Ajouter l'objet à la vue
                try {
                    ajouterObjet(objet);
                } catch (VisiteurException ex) {
                    throw new RuntimeException(ex);
                }
                // Redessiner la vue
                view.repaint();
            }
        });
        barreOutils.add(boutonLigne);
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

    public void ajouterObjet(GeoObject objet) throws VisiteurException {
        controleur.addObjet(objet);
        view.repaint();
    }

    public void setVisible(boolean visible) {
        fenetre.setVisible(visible);
    }
}