package model;

/**
 * Classe représentant une droite géométrique définie par deux points.
 */
public class Droite extends GeoObject {
    private Point point1;
    private Point point2;

    /**
     * Constructeur d'une droite à partir de deux points.
     * 
     * @param point1 Le premier point de la droite.
     * @param point2 Le deuxième point de la droite.
     */
    public Droite(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    // Getters et setters
    /**
     * Obtient le premier point de la droite.
     * 
     * @return Le premier point de la droite.
     */
    public Point getPoint1() {
        return point1;
    }

    /**
     * Définit le premier point de la droite.
     * 
     * @param point1 Le nouveau premier point de la droite.
     */
    public void setPoint1(Point point1) {
        this.point1 = point1;
        notifierModification();
    }

    /**
     * Obtient le deuxième point de la droite.
     * 
     * @return Le deuxième point de la droite.
     */
    public Point getPoint2() {
        return point2;
    }

    /**
     * Définit le deuxième point de la droite.
     * 
     * @param point2 Le nouveau deuxième point de la droite.
     */
    public void setPoint2(Point point2) {
        this.point2 = point2;
        notifierModification();
    }

    /**
     * Calcule le point d'intersection avec une autre droite donnée.
     * 
     * @param autreDroite L'autre droite avec laquelle calculer l'intersection.
     * @return Le point d'intersection, ou null s'il n'y a pas d'intersection.
     */
    /*public Point calculerIntersection(Droite autreDroite) {
        double x1 = this.point1.getX();
        double y1 = this.point1.getY();
        double x2 = this.point2.getX();
        double y2 = this.point2.getY();
        double x3 = autreDroite.point1.getX();
        double y3 = autreDroite.point1.getY();
        double x4 = autreDroite.point2.getX();
        double y4 = autreDroite.point2.getY();

        double denominateur = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
        if (denominateur == 0) {
            return null; // Les droites sont parallèles ou confondues, pas d'intersection
        } else {
            double x = ((x1 * y2 - y1 * x2) * (x3 - x4) - (x1 - x2) * (x3 * y4 - y3 * x4)) / denominateur;
            double y = ((x1 * y2 - y1 * x2) * (y3 - y4) - (y1 - y2) * (x3 * y4 - y3 * x4)) / denominateur;
            return new Point(x, y);
        }
    } */

    /**
     * Vérifie si la droite est orthogonale à une autre droite donnée.
     * 
     * @param autreDroite L'autre droite à vérifier l'orthogonalité.
     * @return true si les droites sont orthogonales, sinon false.
     */
    /*public boolean estOrthogonaleAvec(Droite autreDroite) {
        double pente1 = this.calculerPente();
        double pente2 = autreDroite.calculerPente();
        return pente1 * pente2 == -1; // Les droites sont orthogonales si le produit de leurs pentes vaut -1
    }*/

}
