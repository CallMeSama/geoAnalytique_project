package model;

/**
 * La classe Polygone est une classe abstraite qui représente un polygone dans un espace bidimensionnel.
 * Elle étend la classe abstraite Surface.
 */
public abstract class Polygone extends Surface {

    protected Point[] sommets;    // tableau de points représentant les sommets du polygone

    protected Polygone(Point[] points) {
        this.sommets = points;
    }

    /**
     * Calcule et retourne le périmètre du polygone.
     * @return Le périmètre du polygone.
     */

    /*
    public double calculPerimetre() {
        double perimetre = 0.0;
        for (int i = 0; i < sommets.length - 1; i++)
            perimetre = perimetre + sommets[i].calculerDistance(sommets[i+1]);
        perimetre = perimetre + sommets[sommets.length - 1].calculerDistance(sommets[0]); // Ajouter la distance entre le dernier et le premier point
        return perimetre;
    }

     */
}
