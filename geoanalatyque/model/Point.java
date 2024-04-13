package model;

/**
 * Classe représentant un point géométrique.
 */
public class Point extends GeoObject {
    private double x;
    private double y;

    /**
     * Constructeur d'un point avec les coordonnées spécifiées.
     * 
     * @param x La coordonnée x du point.
     * @param y La coordonnée y du point.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Getters et setters
    /**
     * Obtient la coordonnée x du point.
     * 
     * @return La coordonnée x du point.
     */
    public double getX() {
        return x;
    }

    /**
     * Définit la coordonnée x du point.
     * 
     * @param x La nouvelle coordonnée x du point.
     */
    public void setX(double x) {
        this.x = x;
        notifierModification();
    }

    /**
     * Obtient la coordonnée y du point.
     * 
     * @return La coordonnée y du point.
     */
    public double getY() {
        return y;
    }

    /**
     * Définit la coordonnée y du point.
     * 
     * @param y La nouvelle coordonnée y du point.
     */
    public void setY(double y) {
        this.y = y;
        notifierModification();
    }

}
