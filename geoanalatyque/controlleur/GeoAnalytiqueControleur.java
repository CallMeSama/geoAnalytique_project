package controlleur;

import exception.VisiteurException;
import graphique.*;
import model.*;
import util.*;
import view.GeoAnalytiqueView;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class GeoAnalytiqueControleur {

    private GeoAnalytiqueView view;
    private Dessinateur dessinateur;
    private GeoObject selectedObject;

    private List<GeoObject> geoObjects;

    public GeoAnalytiqueControleur(Dessinateur dessinateur) {
        this.dessinateur = dessinateur;
    }

    public void setView(GeoAnalytiqueView view) {
        this.view = view;
    }

    public void recalculPoints(Graphics g, int width, int height) throws VisiteurException {
        // Draw x-axis
        g.drawLine(0, height / 2, width, height / 2);
        for (int i = -10; i <= 10; i++) {
            int x = width / 2 + i * 50;
            g.drawLine(x, height / 2 - 5, x, height / 2 + 5);
            g.drawString(String.valueOf(i), x - 10, height / 2 + 20);
        }

        // Draw y-axis
        g.drawLine(width / 2, 0, width / 2, height);
        for (int i = -10; i <= 10; i++) {
            int y = height / 2 - i * 50;
            g.drawLine(width / 2 - 5, y, width / 2 + 5, y);
            g.drawString(String.valueOf(i), width / 2 - 20, y + 10);
        }
    }


    public void addObjet(GeoObject objet) throws VisiteurException {
        // Ajouter l'objet à la liste
        geoObjects.add(objet);

        // Utiliser le visiteur pour convertir l'objet en un objet graphique
        Graphique g = objet.accept(dessinateur);
        view.addGraphique(g);

        view.repaint();
    }

    public void deselectionner() {
        // Désélectionner l'objet
        selectedObject = null;

        // Informer la vue qu'aucun objet n'est sélectionné
        view.updateSelectedObject(null);
    }

    public void geometrieModifiee(GeoObject geoObject) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'geometrieModifiee'");
    }

}
