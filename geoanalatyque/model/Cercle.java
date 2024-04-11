/**
 * La classe Cercle représente un cercle dans un espace bidimensionnel.
 * Elle étend la classe Ellipse.
 */
public class Cercle extends Ellipse {

    /**
     * Constructeur de la classe Cercle.
     * @param centre Le centre du cercle.
     * @param rayon Le rayon du cercle.
     */
    public Cercle(Point centre, Segment rayon) {
        super(centre, centre, centre, rayon, rayon);
    }

    /**
     * Calcule les coordonnées des points de tangence à un cercle à partir d'un point donné.
     
     * @param pointX Coordonnée X du point donné.
     * @param pointY Coordonnée Y du point donné.
     * @return Droite correspondant à.
     */
    public Droite calculerPointsTangence(double pointX, double pointY) {
        double distanceCentrePoint = Math.sqrt(Math.pow(pointX - this.centre.x, 2) + Math.pow(pointY - this.centre.y, 2));
        double angleDegTheta = Math.toDegrees(Math.acos(this.grandAxe.calculerLongueur() / distanceCentrePoint));

        Point pointTangence1 = calculerCoordonneesPoint(angleDegTheta);
        Point pointTangence2 = calculerCoordonneesPoint(-angleDegTheta);

        return new Droite(pointTangence1, pointTangence2);
    }

}
