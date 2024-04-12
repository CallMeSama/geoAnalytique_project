package model;

import java.util.List;

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
     * Calcule la longueur du segment.
     * 
     * @return La longueur du segment.
     */
    public double calculerLongueur() {
        double dx = getPoint2().getX() - getPoint1().getX();
        double dy = getPoint2().getY() - getPoint1().getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Vérifie si le segment s'intersecte avec un autre segment donné.
     * 
     * @param autreSegment L'autre segment à vérifier l'intersection.
     * @return true si les segments s'intersectent, sinon false.
     */
    public boolean intersecteAvec(Segment autreSegment) {
        Point intersection = this.calculerIntersection(autreSegment);
        if (intersection != null) {
            double minX = Math.min(this.getPoint1().getX(), this.getPoint2().getX());
            double maxX = Math.max(this.getPoint1().getX(), this.getPoint2().getX());
            double minY = Math.min(this.getPoint1().getY(), this.getPoint2().getY());
            double maxY = Math.max(this.getPoint1().getY(), this.getPoint2().getY());
            return intersection.getX() >= minX && intersection.getX() <= maxX &&
                   intersection.getY() >= minY && intersection.getY() <= maxY;
        }
        return false;
    }

    /**
     * Calcule le point d'intersection avec un autre segment donné.
     * 
     * @param autreDroite L'autre segment avec lequel calculer l'intersection.
     * @return Le point d'intersection, ou null s'il n'y a pas d'intersection.
     */
    @Override
    public Point calculerIntersection(Droite autreDroite) {
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
    }

    /**
     * Vérifie si le segment appartient à une droite donnée.
     * 
     * @param droite La droite à vérifier.
     * @return true si le segment appartient à la droite, sinon false.
     */
    public boolean appartientALaDroite(Droite droite) {
        // Un segment appartient à une droite si ses extrémités appartiennent à la droite
        return droite.contient(this.getPoint1()) && droite.contient(this.getPoint2());
    }

    /**
     * Vérifie si le segment appartient à une surface délimitée par des droites données.
     * 
     * @param limites Les limites de la surface.
     * @return true si le segment appartient à la surface, sinon false.
     */
    public boolean appartientALaSurface(List<Droite> limites) {
        // Un segment appartient à une surface si toutes ses extrémités appartiennent aux limites de la surface
        for (Droite limite : limites) {
            if (!limite.contient(this.getPoint1()) || !limite.contient(this.getPoint2())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Calcule la médiatrice du segment.
     * 
     * @return La droite représentant la médiatrice du segment.
     */
    public Droite calculerMediatrice() {
        // Calcul du milieu du segment
        Point milieu = Point.calculerMilieu(this.getPoint1(), this.getPoint2());

        // Calcul de la pente de la médiatrice (perpendiculaire au segment)
        double penteMediatrice;
        if (this.getPoint1().getX() == this.getPoint2().getX()) {
            // La médiatrice est une droite verticale, sa pente est 0
            penteMediatrice = 0;
        } else {
            penteMediatrice = -1 / this.calculerPente(); // La pente de la médiatrice est l'opposé de l'inverse de la pente du segment
        }

        // Calcul du point d'intersection de la médiatrice avec l'axe des ordonnées
        // (le point est sur la médiatrice et a la même ordonnée que le milieu du segment)
        double xIntersect = milieu.getX() + 1; // Choix arbitraire pour x (pour éviter la division par zéro)
        double yIntersect = milieu.getY() + penteMediatrice * (xIntersect - milieu.getX());

        // Construction de la droite représentant la médiatrice
        Point pointMediatrice1 = new Point(milieu.getX(), milieu.getY());
        Point pointMediatrice2 = new Point(xIntersect, yIntersect);
        return new Droite(pointMediatrice1, pointMediatrice2);
    }

}
