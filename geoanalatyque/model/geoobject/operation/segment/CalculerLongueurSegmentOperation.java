package model.geoobject.operation.segment;

import model.Segment;
import util.Operation;

/**
 * Classe représentant une opération de calcul de la longueur d'un segment.
 */
public class CalculerLongueurSegmentOperation implements Operation {
    private Segment segment;

    /**
     * Constructeur de l'opération de calcul de la longueur d'un segment.
     * 
     * @param segment Le segment dont on souhaite calculer la longueur.
     */
    public CalculerLongueurSegmentOperation(Segment segment) {
        this.segment = segment;
    }

    @Override
    public String getTitle() {
        return "Calculer la longueur du segment";
    }

    @Override
    public int getArite() {
        return 0;
    }

    @Override
    public void setArgument(int num, Object o) {
        // Cette opération n'a pas besoin d'arguments
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Class getClassArgument(int num) {
        return null; // Cette opération n'a pas d'arguments
    }

    @Override
    public Object calculer() {
        double dx = segment.getPoint2().getX() - segment.getPoint1().getX();
        double dy = segment.getPoint2().getY() - segment.getPoint1().getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public String getDescriptionArgument(int num) {
        return null; // Cette opération n'a pas d'arguments
    }
}
