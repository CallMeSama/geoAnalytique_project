package controlleur;

import graphique.*;
import model.*;
import util.*;
import view.GeoAnalytiqueView;

import java.util.List;

public class GeoAnalytiqueControleur {

    private GeoAnalytiqueView view;
    private ViewPort viewport;
    private Dessinateur dessinateur;
    private GeoObject selectedObject;

    private List<GeoObject> geoObjects;

    public GeoAnalytiqueControleur(GeoAnalytiqueView view, ViewPort viewport, Dessinateur dessinateur) {
        this.view = view;
        this.viewport = viewport;
        this.dessinateur = dessinateur;
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
}
