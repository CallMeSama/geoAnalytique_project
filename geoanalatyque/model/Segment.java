package model;

//import java.util.List;

import exception.VisiteurException;
import graphique.Graphique;
import util.GeoObjectVisitor;

/**
 * Classe représentant un segment de droite géométrique défini par deux points.
 */
public class Segment extends Droite {

    /**
     * Constructeur d'un segment à partir de deux points.
     * 
     * @param point1 Le premier point du segment.
     * @param point2 Le deuxième point du segment.
     */
    public Segment(Point point1, Point point2) {
        super(point1, point2);
    }

    /**
     * Calcule le point d'intersection avec un autre segment donné.
     * 
     * @param autreDroite L'autre segment avec lequel calculer l'intersection.
     * @return Le point d'intersection, ou null s'il n'y a pas d'intersection.
     */
    //@Override
    /*public Point calculerIntersection(Droite autreDroite) {
        if (super.intersecteAvec(autreDroite)) {
            Point intersection = super.calculerIntersection(autreDroite);
            if (intersection != null) {
                double minX = Math.min(this.getPoint1().getX(), this.getPoint2().getX());
                double maxX = Math.max(this.getPoint1().getX(), this.getPoint2().getX());
                double minY = Math.min(this.getPoint1().getY(), this.getPoint2().getY());
                double maxY = Math.max(this.getPoint1().getY(), this.getPoint2().getY());
                if (intersection.getX() >= minX && intersection.getX() <= maxX &&
                    intersection.getY() >= minY && intersection.getY() <= maxY) {
                    return intersection;
                }
            }
        }
        return null; // Pas d'intersection ou intersection hors des segments
    }*/

    /**
     * Vérifie si le segment appartient à une droite donnée.
     * 
     * @param droite La droite à vérifier.
     * @return true si le segment appartient à la droite, sinon false.
     */
    /*public boolean appartientALaDroite(Droite droite) {
        // Un segment appartient à une droite si ses extrémités appartiennent à la droite
        return droite.contient(this.getPoint1()) && droite.contient(this.getPoint2());
    }*/

    /**
     * Vérifie si le segment appartient à une surface délimitée par des droites données.
     * 
     * @param limites Les limites de la surface.
     * @return true si le segment appartient à la surface, sinon false.
     */
    /*public boolean appartientALaSurface(List<Droite> limites) {
        // Un segment appartient à une surface si toutes ses extrémités appartiennent aux limites de la surface
        for (Droite limite : limites) {
            if (!limite.contient(this.getPoint1()) || !limite.contient(this.getPoint2())) {
                return false;
            }
        }
        return true;
    }*/
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
