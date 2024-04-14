package model;

/**
 * La classe Polygone est une classe abstraite qui représente un polygone dans un espace bidimensionnel.
 * Elle étend la classe abstraite Surface.
 */
public abstract class Polygone extends Surface {

    public Point[] sommets;    // tableau de points représentant les sommets du polygone

    protected Polygone(Point[] points) {
        this.sommets = points;
    }

    /**
     * Calcule et retourne le périmètre du polygone.
     * @return Le périmètre du polygone.
     */

}
