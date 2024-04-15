package model.geoobject.operation.droite;

import model.Droite;
import util.Operation;

/**
 * Opération pour calculer la pente d'une droite.
 */
public class CalculerPenteDroiteOperation implements Operation {
    private Droite droite;

    /**
     * Constructeur de l'opération de calcul de la pente.
     * 
     * @param droite La droite pour laquelle calculer la pente.
     */
    public CalculerPenteDroiteOperation(Droite droite) {
        this.droite = droite;
    }

    @Override
    public String getTitle() {
        return "Calculer la pente de la droite";
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
        if (droite.getPoint1().getX() == droite.getPoint2().getX()) {
            // La droite est verticale, la pente est infinie
            return Double.POSITIVE_INFINITY;
        } else {
            return (droite.getPoint2().getY() - droite.getPoint1().getY()) / (droite.getPoint2().getX() - droite.getPoint1().getX());
        }
    }

    @Override
    public String getDescriptionArgument(int num) {
        throw new UnsupportedOperationException("Cette opération ne prend pas d'arguments");
    }
}
