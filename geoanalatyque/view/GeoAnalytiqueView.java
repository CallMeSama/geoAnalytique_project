package view;

import javax.swing.JPanel;

import controlleur.GeoAnalytiqueControleur;

import java.awt.Graphics;
import java.util.ArrayList;
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
        double largeurMonde = largeurEcran / 30.0;
        double hauteurMonde = hauteurEcran / 30.0;
        this.viewport = new ViewPort(largeurMonde, hauteurMonde, largeurEcran, hauteurEcran);
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
            controleur.drawAbscisses(g, viewport, getWidth(), getHeight());
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