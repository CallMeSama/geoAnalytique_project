package model;

public class Segment extends Droite{
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
}
