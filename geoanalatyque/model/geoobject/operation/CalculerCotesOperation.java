package model.geoobject.operation;

import model.Point;
import util.Operation;

/**
 * Classe représentant une opération de calcul des côtés d'un quadrilatère.
 */
public class CalculerCotesOperation implements Operation {
    private Point[] sommets;
    private double[] cotes;

    /**
     * Constructeur de la classe CalculerCotesOperation.
     *
     * @param sommets Les sommets du quadrilatère.
     */
    public CalculerCotesOperation(Point[] sommets) {
        this.sommets = sommets;
        this.cotes = new double[sommets.length];
    }

    @Override
    public String getTitle() {
        return "Calcul des côtés d'un quadrilatère";
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
        // Calcul des longueurs des côtés
        for (int i = 0; i < sommets.length; i++) {
            int j = (i + 1) % sommets.length; // Prochain sommet
            double deltaX = sommets[j].getX() - sommets[i].getX();
            double deltaY = sommets[j].getY() - sommets[i].getY();
            cotes[i] = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        }
        return cotes;
    }

    @Override
    public String getDescriptionArgument(int num) {
        throw new UnsupportedOperationException("Cette opération ne prend pas d'arguments");
    }
}
