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

    /**
     * Déplace le point selon les déplacements spécifiés en deltaX et deltaY.
     * 
     * @param deltaX La variation de la coordonnée x.
     * @param deltaY La variation de la coordonnée y.
     */
    public void deplacer(double deltaX, double deltaY) {
        this.x += deltaX;
        this.y += deltaY;
        notifierModification();
    }

    /**
     * Calcule la distance entre ce point et un autre point donné.
     * 
     * @param autrePoint Le point par rapport auquel calculer la distance.
     * @return La distance entre ce point et le point donné.
     */
    public double calculerDistance(Point autrePoint) {
        double deltaX = autrePoint.getX() - this.x;
        double deltaY = autrePoint.getY() - this.y;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    /**
     * Calcule le point milieu entre deux points donnés.
     * 
     * @param point1 Le premier point.
     * @param point2 Le deuxième point.
     * @return Le point milieu entre les deux points donnés.
     */
    public static Point calculerMilieu(Point point1, Point point2) {
        double xMilieu = (point1.getX() + point2.getX()) / 2.0;
        double yMilieu = (point1.getY() + point2.getY()) / 2.0;
        return new Point(xMilieu, yMilieu);
    }

    // Implémentation des méthodes abstraites
    @Override
    public void afficher() {
        // Implémentation de l'affichage d'un point
    }

    @Override
    public void cacher() {
        // Implémentation pour cacher un point
    }
}
