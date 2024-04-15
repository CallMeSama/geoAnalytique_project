package controlleur;

import graphique.*;
import model.*;
import util.*;
import view.GeoAnalytiqueView;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class GeoAnalytiqueControleur {

    private GeoAnalytiqueView view;
    private ViewPort viewport;
    private Dessinateur dessinateur;
    private GeoObject selectedObject;

    private List<GeoObject> geoObjects;

    public GeoAnalytiqueControleur(ViewPort viewport, Dessinateur dessinateur) {
        this.viewport = viewport;
        this.dessinateur = dessinateur;
    }

    public void setView(GeoAnalytiqueView view) {
        this.view = view;
    }

    public void recalculPoints() {
        // Créer les droites des abscisses (Ox) et des ordonnées (Oy)
        Droite ox = new Droite(new Point(0, 0), new Point(1, 0));
        Droite oy = new Droite(new Point(0, 0), new Point(0, 1));

        // Convertir les droites en objets graphiques
        Graphique gOx = dessinateur.visit(ox);
        Graphique gOy = dessinateur.visit(oy);

        // Ajouter les objets graphiques à la vue
        view.addGraphique(gOx);
        view.addGraphique(gOy);
    }

    public void addObjet(GeoObject objet) {
        // Ajouter l'objet à la liste
        geoObjects.add(objet);

        // Utiliser le visiteur pour convertir l'objet en un objet graphique
        Graphique g = objet.accept(dessinateur);
        view.addGraphique(g);
    }

    public void selectionner(GeoObject objet) {
        // Vérifier si l'objet est dans la liste
        if (geoObjects.contains(objet)) {
            // Mettre à jour l'objet sélectionné
            selectedObject = objet;

            // Informer la vue de l'objet sélectionné
            view.updateSelectedObject(objet);
        }
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

    public void drawAbscisses(Graphics g, ViewPort viewport, int width, int height) {
        // Dessiner l'axe des abscisses et des graduations
        g.drawLine(0, height / 2, width, height / 2);
        for (int i = -(int) (viewport.largeurMonde / 2); i <= viewport.largeurMonde /
                2; i++) {
            if (i == 0)
                continue; // Ne pas afficher le 0
            int x = viewport.mondeVersEcranX(i) + width / 2;
            g.drawLine(x, height / 2, x, height / 2 - 5);
            g.drawString(Integer.toString(i), x, height / 2 + 20); // Déplacer les numérotations aux côtés opposés
            // des graduations
        }
        // Dessiner l'axe des ordonnées et des graduations
        g.drawLine(width / 2, 0, width / 2, height);
        for (int i = -(int) (viewport.hauteurMonde / 2); i <= viewport.hauteurMonde /
                2; i++) {
            if (i == 0)
                continue; // Ne pas afficher le 0
            int y = height / 2 - viewport.mondeVersEcranY(i);
            g.drawLine(width / 2, y, width / 2 + 5, y);
            g.drawString(Integer.toString(i), width / 2 - 20, i < 0 ? y + 5 : y);
        }
    }
}
