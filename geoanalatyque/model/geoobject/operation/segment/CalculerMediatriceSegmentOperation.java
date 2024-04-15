package model.geoobject.operation.segment;

import model.Point;
import util.Operation;
import model.Droite;

/**
 * Classe représentant l'opération de calcul de la médiatrice d'un segment.
 */
public class CalculerMediatriceSegmentOperation implements Operation {
    private Point point1;
    private Point point2;

    /**
     * Constructeur de l'opération de calcul de la médiatrice d'un segment.
     * 
     * @param point1 Le premier point du segment.
     * @param point2 Le deuxième point du segment.
     */
    public CalculerMediatriceSegmentOperation(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    @Override
    public String getTitle() {
        return "Calcul de la médiatrice d'un segment";
    }

    @Override
    public int getArite() {
        return 2;
    }

    @Override
    public void setArgument(int num, Object o) {
        if (num == 0) {
            point1 = (Point) o;
        } else if (num == 1) {
            point2 = (Point) o;
        } else {
            throw new IllegalArgumentException("Numéro d'argument invalide");
        }
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Class getClassArgument(int num) {
        return Point.class;
    }

    @Override
    public Object calculer() {
        // Calcul du milieu du segment
        double xMilieu = (point1.getX() + point2.getX()) / 2.0;
        double yMilieu = (point1.getY() + point2.getY()) / 2.0;
        Point milieu = new Point(xMilieu, yMilieu);

        // Calcul de la pente de la médiatrice (perpendiculaire au segment)
        double penteMediatrice;
        if (point1.getX() == point2.getX()) {
            penteMediatrice = 0;
        } else {
            penteMediatrice = -1 / ((point2.getY() - point1.getY()) / (point2.getX() - point1.getX()));
        }

        // Calcul du point d'intersection de la médiatrice avec l'axe des ordonnées
        double xIntersect = milieu.getX() + 1;
        double yIntersect = milieu.getY() + penteMediatrice * (xIntersect - milieu.getX());

        // Construction de la droite représentant la médiatrice
        Point pointMediatrice1 = new Point(milieu.getX(), milieu.getY());
        Point pointMediatrice2 = new Point(xIntersect, yIntersect);
        return new Droite(pointMediatrice1, pointMediatrice2);
    }

    @Override
    public String getDescriptionArgument(int num) {
        if (num == 0) {
            return "Le premier point du segment";
        } else if (num == 1) {
            return "Le deuxième point du segment";
        } else {
            throw new IllegalArgumentException("Numéro d'argument invalide");
        }
    }
}
