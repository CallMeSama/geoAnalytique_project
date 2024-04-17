package controlleur;

import exception.VisiteurException;
import graphique.*;
import model.*;
import util.*;
import view.GeoAnalytiqueView;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 * Le contrôleur de l'application GeoAnalytique.
 */
public class GeoAnalytiqueControleur {

    private GeoAnalytiqueView view;
    private Dessinateur dessinateur;
    private GeoObject selectedObject;

    private ArrayList<GeoObject> vueObjets = new ArrayList<GeoObject>();

    /**
     * Constructeur de la classe GeoAnalytiqueControleur.
     * @param dessinateur Le dessinateur utilisé pour convertir les objets géométriques en objets graphiques.
     */
    public GeoAnalytiqueControleur(Dessinateur dessinateur) {
        this.dessinateur = dessinateur;
    }

    /**
     * Définit la vue associée à ce contrôleur.
     * @param view La vue GeoAnalytiqueView associée à ce contrôleur.
     */
    public void setView(GeoAnalytiqueView view) {
        this.view = view;
    }

    /**
     * Recalculer les points des objets géométriques et les dessiner.
     * @param g Le contexte graphique utilisé pour dessiner.
     * @param width La largeur de la zone de dessin.
     * @param height La hauteur de la zone de dessin.
     * @throws VisiteurException Si une erreur survient lors de la visite des objets géométriques.
     */
    public void recalculPoints(Graphics g, int width, int height) throws VisiteurException {
        // Dessiner les axes x et y

        g.drawLine(0, height / 2, width, height / 2);
        for (int i = -10; i <= 10; i++) {
            int x = width / 2 + i * 50;
            g.drawLine(x, height / 2 - 5, x, height / 2 + 5);
            g.drawString(String.valueOf(i), x - 10, height / 2 + 20);
        }

        g.drawLine(width / 2, 0, width / 2, height);
        for (int i = -10; i <= 10; i++) {
            int y = height / 2 - i * 50;
            g.drawLine(width / 2 - 5, y, width / 2 + 5, y);
            g.drawString(String.valueOf(i), width / 2 - 20, y + 10);
        }

        g.translate(200/2, -600/2);
        // Dessiner les objets géométriques
        if (this.getObjets() != null) {
            for (GeoObject objet : this.getObjets()) {
                Graphique graphique = objet.accept(dessinateur);
                graphique.paint(g);
            }
        }
    }

    /**
     * Récupère la liste des objets géométriques.
     * @return La liste des objets géométriques à dessiner.
     */
    public ArrayList<GeoObject> getObjets() {
        return this.vueObjets;
    }

    /**
     * Ajoute un nouvel objet géométrique à la liste.
     * @param objet L'objet géométrique à ajouter.
     * @throws VisiteurException Si une erreur survient lors de la conversion de l'objet géométrique en objet graphique.
     */
    public void addObjet(GeoObject objet) throws VisiteurException {
        vueObjets.add(objet);
    }

    /**
     * Désélectionne l'objet actuellement sélectionné.
     */
    public void deselectionner() {
        selectedObject = null;
        view.updateSelectedObject(null);
    }

    /**
     * Notifie le contrôleur qu'une géométrie a été modifiée.
     * @param geoObject L'objet géométrique modifié.
     */
    public void geometrieModifiee(GeoObject geoObject) {
        // Non implémenté
        throw new UnsupportedOperationException("Méthode non implémentée 'geometrieModifiee'");
    }
}
