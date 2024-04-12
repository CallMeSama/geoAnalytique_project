package model.geoobject.operation;

import model.Point;

/**
 * Classe représentant une opération pour calculer le milieu de deux points.
 */
public class CalculerMilieuPointOperation implements Operation {
    private Point point1;
    private Point point2;

    /**
     * Constructeur de l'opération pour calculer le milieu de deux points.
     * 
     * @param point1 Le premier point.
     * @param point2 Le deuxième point.
     */
    public CalculerMilieuPointOperation(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    @Override
    public String getTitle() {
        return "Calculer le milieu de deux points";
    }

    @Override
    public int getArite() {
        return 0; // Cette opération ne prend pas d'arguments supplémentaires
    }

    @Override
    public void setArgument(int num, Object o) {
        throw new UnsupportedOperationException("Cette opération ne prend pas d'arguments");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Class getClassArgument(int num) {
        throw new UnsupportedOperationException("Cette opération ne prend pas d'arguments");
    }

    @Override
    public Object calculer() {
        double xMilieu = (point1.getX() + point2.getX()) / 2.0;
        double yMilieu = (point1.getY() + point2.getY()) / 2.0;
        return new Point(xMilieu, yMilieu);
    }

    @Override
    public String getDescriptionArgument(int num) {
        throw new UnsupportedOperationException("Cette opération ne prend pas d'arguments");
    }
}
