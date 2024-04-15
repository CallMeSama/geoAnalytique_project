package model.geoobject.operation.droite;

import model.Droite;
import model.Point;
import util.Operation;

/**
 * Classe représentant une opération pour vérifier si un point appartient à une droite.
 */
public class ContientPointDroiteOperation implements Operation {
    private Droite droite;
    private Point point;

    /**
     * Constructeur de l'opération pour vérifier si un point appartient à une droite.
     * 
     * @param droite La droite à tester.
     * @param point Le point à vérifier.
     */
    public ContientPointDroiteOperation(Droite droite, Point point) {
        this.droite = droite;
        this.point = point;
    }

    @Override
    public String getTitle() {
        return "Vérifier si un point appartient à la droite";
    }

    @Override
    public int getArite() {
        return 1;
    }

    @Override
    public void setArgument(int num, Object o) {
        if (num == 0) {
            point = (Point) o;
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
        CalculerPenteDroiteOperation penteOperation = new CalculerPenteDroiteOperation(droite);
        double m = (double) penteOperation.calculer();
        double b = droite.getPoint1().getY() - m * droite.getPoint1().getX();

        // Vérification si le point satisfait l'équation de la droite (avec une marge d'erreur de 1e-6)
        return Math.abs(point.getY() - (m * point.getX() + b)) < 1e-6;
    }

    @Override
    public String getDescriptionArgument(int num) {
        if (num == 0) {
            return "Le point à vérifier";
        } else {
            throw new IllegalArgumentException("Numéro d'argument invalide");
        }
    }
}
