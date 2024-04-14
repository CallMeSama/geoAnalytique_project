package model;

import graphique.Graphique;
import util.GeoObjectVisitor;

public class Carre extends GeoObject{

    private double cote;

    public Carre(double cote) {
        this.cote = cote;
    }

    public double calculerPerimetre() {
        return 4 * cote;
    }

    public double calculerAire() {
        return cote * cote;
    }


    // Getters et Setters
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
