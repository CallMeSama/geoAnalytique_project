package model;

import controlleur.GeoAnalytiqueControleur;
import exception.VisiteurException;
import graphique.Graphique;
import util.Dessinateur;
import util.GeoObjectVisitor;

/**
 * Classe abstraite représentant un objet géométrique.
 */
public abstract class GeoObject {
    private GeoAnalytiqueControleur controleur;

    /**
     * Définit le contrôleur principal pour cet objet géométrique.
     * 
     * @param controleur Le contrôleur principal à définir.
     */
    public void setControleur(GeoAnalytiqueControleur controleur) {
        this.controleur = controleur;
    }

    /**
     * Méthode pour notifier le contrôleur principal d'une modification de l'objet géométrique.
     */
    protected void notifierModification() {
        if (controleur != null) {
            controleur.geometrieModifiee(this);
        }
    }
    public abstract Graphique accept(Dessinateur dessinateur) throws VisiteurException;
}
