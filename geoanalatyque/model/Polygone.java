package model;


/**
 * La classe Polygone est une classe abstraite qui représente un polygone dans un espace bidimensionnel.
 * Elle étend la classe abstraite Surface.
 */
public abstract class Polygone extends Surface {
   
    private int N;        // nombre de points du polygone, également le nombre de côtés
    private Point[] a;    // tableau de points représentant les sommets du polygone

    /**
     * Calcule et retourne le périmètre du polygone.
     * @return Le périmètre du polygone.
     */
    public double perimeter() {
        double perimetre = 0.0;
        for (int i = 0; i < N; i++)
            perimetre = perimetre + a[i].calculerDistance(a[i+1]);
        return perimetre;
    }
}
