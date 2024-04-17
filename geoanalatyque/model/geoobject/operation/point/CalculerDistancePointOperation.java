package model.geoobject.operation.point;

import model.Point;
import util.Operation;

/**
 * Classe représentant une opération de calcul de distance entre deux points.
 */
public class CalculerDistancePointOperation implements Operation {
    private Point point;
    private Point autrePoint;

    /**
     * Constructeur de l'opération de calcul de distance entre deux points.
     * 
     * @param point Le premier point.
     * @param autrePoint Le deuxième point.
     */
    public CalculerDistancePointOperation(Point point, Point autrePoint) {
        this.point = point;
        this.autrePoint = autrePoint;
    }

    @Override
    public String getTitle() {
        return "Calculer distance entre deux points";
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
    public Double calculer() {
        double deltaX = autrePoint.getX() - point.getX();
        double deltaY = autrePoint.getY() - point.getY();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    @Override
    public String getDescriptionArgument(int num) {
        throw new UnsupportedOperationException("Cette opération ne prend pas d'arguments");
    }
}
