package view;

import javax.swing.JPanel;

import controlleur.GeoAnalytiqueControleur;

import java.awt.Graphics;
import java.util.ArrayList;

import exception.VisiteurException;
import graphique.Graphique;
import model.GeoObject;
import model.ViewPort;
import util.Dessinateur;

public class GeoAnalytiqueView extends JPanel {
    private ArrayList<Graphique> graphiques;
    private ViewPort viewport;
    private GeoObject selectedObject;

    private GeoAnalytiqueControleur controleur;

    public GeoAnalytiqueView() {
        super();
        int largeurEcran = 1366;
        int hauteurEcran = 768;
        this.viewport = new ViewPort(largeurEcran, hauteurEcran, 30);
        this.graphiques = new ArrayList<>();
    }

    public void setControleur(GeoAnalytiqueControleur controleur) {
        this.controleur = controleur;
    }

    public void addGraphique(Graphique g) {
        this.graphiques.add(g);
    }

    public void removeGraphique(Graphique g) {
        this.graphiques.remove(g);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (controleur != null) {
            try {
                controleur.recalculPoints(g, getWidth(), getHeight());
            } catch (VisiteurException e) {
                throw new RuntimeException(e);
            }
        }
        for (Graphique graphique : graphiques) {
            graphique.paint(g);
        }

    }

    public void updateSelectedObject(GeoObject objet) {
        this.selectedObject = objet;
        this.repaint();
    }

}