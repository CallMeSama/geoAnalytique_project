package model;

import exception.VisiteurException;
import graphique.Graphique;
import util.GeoObjectVisitor;

/**
 * Classe représentant un point géométrique.
 */
public class Point extends GeoObject {
    private double x;
    private double y;

    /**
     * Constructeur d'un point avec les coordonnées spécifiées.
     * 
     * @param x La coordonnée x du point.
     * @param y La coordonnée y du point.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Getters et setters
    /**
     * Obtient la coordonnée x du point.
     * 
     * @return La coordonnée x du point.
     */
    public double getX() {
        return x;
    }

    /**
     * Définit la coordonnée x du point.
     * 
     * @param x La nouvelle coordonnée x du point.
     */
    public void setX(double x) {
        this.x = x;
        notifierModification();
    }

    /**
     * Obtient la coordonnée y du point.
     * 
     * @return La coordonnée y du point.
     */
    public double getY() {
        return y;
    }

    /**
     * Définit la coordonnée y du point.
     * 
     * @param y La nouvelle coordonnée y du point.
     */
    public void setY(double y) {
        this.y = y;
        notifierModification();
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
