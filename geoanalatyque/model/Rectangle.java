package model;

import exception.VisiteurException;
import graphique.Graphique;
import util.GeoObjectVisitor;

public class Rectangle extends GeoObject {
    private double longueur;
    private double largeur;

    public Rectangle(double longueur, double largeur) {
        this.longueur = longueur;
        this.largeur = largeur;
    }

    public double calculerPerimetre() {
        return 2 * (longueur + largeur);
    }

    public double calculerAire() {
        return longueur * largeur;
    }

    // Getters et Setters
    public double getLongueur() {
        return longueur;
    }

    public void setLongueur(double longueur) {
        this.longueur = longueur;
    }

    public double getLargeur() {
        return largeur;
    }

    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    /**
     * Accepte un visiteur géométrique pour appliquer une opération sur cet objet.
     * Cette méthode invoque la méthode correspondante du visiteur avec cet objet en tant que paramètre.
     *
     * @param visitor Le visiteur géométrique à accepter.
     */

    public void accept(GeoObjectVisitor<Graphique, VisiteurException> visitor) throws VisiteurException {
        visitor.visit(this);
    }
}
