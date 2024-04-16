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
        // Dessiner l'axe des abscisses et des graduations
        g.drawLine(0, height / 2, width, height / 2);
        for (int i = -(int) (dessinateur.viewport.getLargeur() / 2); i <= dessinateur.viewport.getLargeur() /
                2; i++) {
            if (i == 0)
                continue; // Ne pas afficher le 0
            int x = dessinateur.viewport.convertirCoordonnees(i, 0).getX() + width / 2;
            g.drawLine(x, height / 2, x, height / 2 - 5);
            g.drawString(Integer.toString(i), x, height / 2 + 20); // Déplacer les numérotations aux côtés opposés
            // des graduations
        }

        // Dessiner l'axe des ordonnées et des graduations
        g.drawLine(width / 2, 0, width / 2, height);
        for (int i = -(int) (dessinateur.viewport.getHauteur() / 2); i <= dessinateur.viewport.getHauteur() /
                2; i++) {
            if (i == 0)
                continue; // Ne pas afficher le 0
            int y = height / 2 - dessinateur.viewport.convertirCoordonnees(0.0, (double)i).getY();
            g.drawLine(width / 2, y, width / 2 + 5, y);
            g.drawString(Integer.toString(i), width / 2 - 20, i < 0 ? y + 5 : y);
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
