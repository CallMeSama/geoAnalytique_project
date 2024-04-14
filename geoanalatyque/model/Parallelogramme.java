package model;

import graphique.Graphique;
import util.GeoObjectVisitor;

public class Parallelogramme extends GeoObject  {
    private double base;
    private double hauteur;
    private double cote;

    public Parallelogramme(double base, double hauteur, double cote) {
        this.base = base;
        this.hauteur = hauteur;
        this.cote = cote;
    }

    public double calculerPerimetre() {
        return 2 * (base + cote);
    }

    public double calculerAire() {
        return base * hauteur;
    }


    // Getters et Setters
    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHauteur() {
        return hauteur;
    }

    public void setHauteur(double hauteur) {
        this.hauteur = hauteur;
    }

    public double getcote() {
        return cote;
    }

    public void setcote(double cote) {
        this.cote = cote;
    }

    /**
     * Accepte un visiteur géométrique pour appliquer une opération sur cet objet.
     * Cette méthode invoque la méthode correspondante du visiteur avec cet objet en tant que paramètre.
     *
     * @param visitor Le visiteur géométrique à accepter.
     */

    public void accept(GeoObjectVisitor<Graphique> visitor) {
        visitor.visit(this);
    }
}