package model;

import exception.VisiteurException;
import graphique.Graphique;
import util.GeoObjectVisitor;

/**
 * La classe Cercle représente un cercle dans un espace bidimensionnel.
 * Elle étend la classe Ellipse.
 */
public class Cercle extends Ellipse {

    /**
     * Constructeur de la classe Cercle.
     * @param centre Le centre du cercle.
     * @param rayon Le rayon du cercle.
     */
    public Cercle(Point centre, Segment rayon) {
        super(centre, centre, centre, rayon, rayon);
    }
    /*
    /**
     * Calcule les coordonnées des points de tangence à un cercle à partir d'un point donné.
     
     * @param pointX Coordonnée X du point donné.
     * @param pointY Coordonnée Y du point donné.
     * @return Droite correspondant à.
     */
    /*
    public Droite calculerPointsTangence(double pointX, double pointY) {
        double distanceCentrePoint = Math.sqrt(Math.pow(pointX - this.getCentre().getX(), 2) + Math.pow(pointY - this.getCentre().getY(), 2));
        double angleDegTheta = Math.toDegrees(Math.acos(this.getGrandAxe().calculerLongueur() / distanceCentrePoint));

        Point pointTangence1 = calculerCoordonneesPoint(angleDegTheta);
        Point pointTangence2 = calculerCoordonneesPoint(-angleDegTheta);

        return new Droite(pointTangence1, pointTangence2);
    }
    */


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
