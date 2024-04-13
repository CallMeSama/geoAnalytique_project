package model.geoobject.operation.point;

import model.Point;
import model.geoobject.operation.Operation;

/**
 * Classe représentant une opération de déplacement d'un point selon un certain delta en abscisse et en ordonnée.
 */
public class DeplacerPointOperation implements Operation {
    private double deltaX;
    private double deltaY;
    private Point point;

    /**
     * Constructeur de l'opération de déplacement.
     * 
     * @param deltaX Le déplacement en abscisse.
     * @param deltaY Le déplacement en ordonnée.
     * @param point Le point à déplacer.
     */
    public DeplacerPointOperation(double deltaX, double deltaY, Point point) {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
        this.point = point;
    }

    @Override
    public String getTitle() {
        return "Déplacer le point";
    }

    @Override
    public int getArite() {
        return 2;
    }

    @Override
    public void setArgument(int num, Object o) {
        if (num == 0) {
            deltaX = (double) o;
        } else if (num == 1) {
            deltaY = (double) o;
        } else {
            throw new IllegalArgumentException("Numéro d'argument invalide");
        }
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Class getClassArgument(int num) {
        return Double.class;
    }

    @Override
    public Object calculer() {
        double newX = point.getX() + deltaX;
        double newY = point.getY() + deltaY;
        return new Point(newX, newY);
    }

    @Override
    public String getDescriptionArgument(int num) {
        if (num == 0) {
            return "Déplacement en abscisse";
        } else if (num == 1) {
            return "Déplacement en ordonnée";
        } else {
            throw new IllegalArgumentException("Numéro d'argument invalide");
        }
    }
}
