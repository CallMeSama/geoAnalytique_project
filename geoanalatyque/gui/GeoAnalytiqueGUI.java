package gui;

import javax.swing.*;
import java.awt.*;
import controlleur.GeoAnalytiqueControleur;
import exception.VisiteurException;
import graphique.GLigne;
import model.Cercle;
import model.Droite;
import model.GeoObject;
import model.Segment;
import model.TriangleEquilateral;
import model.TriangleIsocele;
import model.TriangleRectangle;
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
        JButton boutonLigne = new JButton("Droite");
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

        JButton boutonCercle = new JButton("Cercle");
        boutonCercle.addActionListener(e -> {
            // Demander à l'utilisateur de renseigner les coordonnées du centre et le rayon
            String coordonnees = JOptionPane
                    .showInputDialog("Veuillez entrer les coordonnées du centre et le rayon sous la forme x,y,r");

            // Parser les coordonnées
            String[] parties = coordonnees.split(",");
            int x = Integer.parseInt(parties[0]);
            int y = Integer.parseInt(parties[1]);
            int r = Integer.parseInt(parties[2]);

            // Créer un point pour le centre
            model.Point centre = new model.Point(x, y);

            // Créer un segment pour le rayon
            model.Point point1 = new model.Point(0, 0);
            model.Point point2 = new model.Point(r, 0);
            model.Segment rayon = new model.Segment(point1, point2);

            // Créer un cercle avec ces coordonnées et ce rayon
            GeoObject objet = new Cercle(centre, rayon);

            // Ajouter le cercle à la vue
            try {
                ajouterObjet(objet);
            } catch (VisiteurException ex) {
                ex.printStackTrace();
            }
        });
        barreOutils.add(boutonCercle);

        // Ajout d'un bouton pour le Triangle Isocèle
        JButton boutonTriangleIsocele = new JButton("Triangle Isocèle");
        boutonTriangleIsocele.addActionListener(e -> {
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

                // Calculer le troisième point pour rendre le triangle isocèle
                int x3 = x1;
                int y3 = y2;

                GeoObject objet = new TriangleIsocele(new model.Point(x1, y1), new model.Point(x2, y2),
                        new model.Point(x3, y3));
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
        barreOutils.add(boutonTriangleIsocele);
        barreOutils.add(boutonTriangleIsocele);

        // Ajout d'un bouton pour le Triangle Équilatéral
        JButton boutonTriangleEquilateral = new JButton("Triangle Équilatéral");
        boutonTriangleEquilateral.addActionListener(e -> {
            // Créer une boîte de dialogue personnalisée
            JTextField champX1 = new JTextField();
            JTextField champY1 = new JTextField();
            JTextField champX2 = new JTextField();
            JTextField champY2 = new JTextField();
            JTextField champX3 = new JTextField();
            JTextField champY3 = new JTextField();
            Object[] message = {
                    "x1:", champX1,
                    "y1:", champY1,
                    "x2:", champX2,
                    "y2:", champY2,
                    "x3:", champX3,
                    "y3:", champY3
            };
            int option = JOptionPane.showConfirmDialog(null, message,
                    "Veuillez entrer les coordonnées des trois points",
                    JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                // Parser les coordonnées
                int x1 = Integer.parseInt(champX1.getText());
                int y1 = Integer.parseInt(champY1.getText());
                int x2 = Integer.parseInt(champX2.getText());
                int y2 = Integer.parseInt(champY2.getText());
                int x3 = Integer.parseInt(champX3.getText());
                int y3 = Integer.parseInt(champY3.getText());
                GeoObject objet = new TriangleEquilateral(new model.Point(x1, y1), new model.Point(x2, y2),
                        new model.Point(x3, y3));
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
        barreOutils.add(boutonTriangleEquilateral);

        // Ajout d'un bouton pour le Triangle Rectangle
        JButton boutonTriangleRectangle = new JButton("Triangle Rectangle");
        boutonTriangleRectangle.addActionListener(e -> {
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

                // Calculer le troisième point pour rendre le triangle rectangle
                int x3 = x1;
                int y3 = y2;

                GeoObject objet = new TriangleRectangle(new model.Point(x1, y1), new model.Point(x2, y2),
                        new model.Point(x3, y3));
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
        barreOutils.add(boutonTriangleRectangle);

        // Ajout d'un bouton pour le Rectangle
        JButton boutonRectangle = new JButton("Rectangle");
        boutonRectangle.addActionListener(e -> {
            // Créer une boîte de dialogue personnalisée
            JTextField champX1 = new JTextField();
            JTextField champY1 = new JTextField();
            JTextField champX2 = new JTextField();
            JTextField champY2 = new JTextField();
            JTextField champX3 = new JTextField();
            JTextField champY3 = new JTextField();
            JTextField champX4 = new JTextField();
            JTextField champY4 = new JTextField();
            Object[] message = {
                    "x1:", champX1,
                    "y1:", champY1,
                    "x2:", champX2,
                    "y2:", champY2,
                    "x3:", champX3,
                    "y3:", champY3,
                    "x4:", champX4,
                    "y4:", champY4
            };
            int option = JOptionPane.showConfirmDialog(null, message,
                    "Veuillez entrer les coordonnées des quatre points",
                    JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                // Parser les coordonnées
                int x1 = Integer.parseInt(champX1.getText());
                int y1 = Integer.parseInt(champY1.getText());
                int x2 = Integer.parseInt(champX2.getText());
                int y2 = Integer.parseInt(champY2.getText());
                int x3 = Integer.parseInt(champX3.getText());
                int y3 = Integer.parseInt(champY3.getText());
                int x4 = Integer.parseInt(champX4.getText());
                int y4 = Integer.parseInt(champY4.getText());

                GeoObject objet = new model.Rectangle(new model.Point(x1, y1), new model.Point(x2, y2),
                        new model.Point(x3, y3), new model.Point(x4, y4));
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
        barreOutils.add(boutonRectangle);

        // Ajout d'un bouton pour le Carré
        JButton boutonCarre = new JButton("Carré");
        boutonCarre.addActionListener(e -> {
            // Créer une boîte de dialogue personnalisée
            JTextField champX1 = new JTextField();
            JTextField champY1 = new JTextField();
            JTextField champX2 = new JTextField();
            JTextField champY2 = new JTextField();
            JTextField champX3 = new JTextField();
            JTextField champY3 = new JTextField();
            JTextField champX4 = new JTextField();
            JTextField champY4 = new JTextField();
            Object[] message = {
                    "x1:", champX1,
                    "y1:", champY1,
                    "x2:", champX2,
                    "y2:", champY2,
                    "x3:", champX3,
                    "y3:", champY3,
                    "x4:", champX4,
                    "y4:", champY4
            };
            int option = JOptionPane.showConfirmDialog(null, message,
                    "Veuillez entrer les coordonnées des quatre points",
                    JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                // Parser les coordonnées
                int x1 = Integer.parseInt(champX1.getText());
                int y1 = Integer.parseInt(champY1.getText());
                int x2 = Integer.parseInt(champX2.getText());
                int y2 = Integer.parseInt(champY2.getText());
                int x3 = Integer.parseInt(champX3.getText());
                int y3 = Integer.parseInt(champY3.getText());
                int x4 = Integer.parseInt(champX4.getText());
                int y4 = Integer.parseInt(champY4.getText());

                GeoObject objet = new model.Carre(new model.Point(x1, y1), new model.Point(x2, y2),
                        new model.Point(x3, y3), new model.Point(x4, y4));
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
        barreOutils.add(boutonCarre);

        // Ajout d'un bouton pour le Segment
        JButton boutonSegment = new JButton("Segment");
        boutonSegment.addActionListener(e -> {
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
            int option = JOptionPane.showConfirmDialog(null, message,
                    "Veuillez entrer les coordonnées des deux points",
                    JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                // Parser les coordonnées
                int x1 = Integer.parseInt(champX1.getText());
                int y1 = Integer.parseInt(champY1.getText());
                int x2 = Integer.parseInt(champX2.getText());
                int y2 = Integer.parseInt(champY2.getText());

                GeoObject objet = new Segment(new model.Point(x1, y1), new model.Point(x2, y2));
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
        barreOutils.add(boutonSegment);
    }

    public void ajouterObjet(GeoObject objet) throws VisiteurException {
        controleur.addObjet(objet);
        view.repaint();
    }

    public void setVisible(boolean visible) {
        fenetre.setVisible(visible);
    }
}