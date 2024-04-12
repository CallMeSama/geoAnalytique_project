package model;

/**
 * Classe TriangleEquilateral qui étend la classe Triangle.
 * Un TriangleEquilateral est un triangle dont tous les côtés ont la même longueur.
 */
public class TriangleEquilateral extends Triangle{
    /**
     * Constructeur pour un TriangleEquilateral.
     *
     * @param s1 Premier sommet du triangle.
     * @param s2 Deuxième sommet du triangle.
     * @param s3 Troisième sommet du triangle.
     */
    public TriangleEquilateral(Point s1, Point s2, Point s3) {
        super(s1, s2, s3);
    }

    /**
     * Méthode pour afficher l'objet TriangleEquilateral.
     */
    @Override
    public void afficher() {
        // Implémentez la logique pour afficher le triangle ici
    }

    /**
     * Méthode pour cacher l'objet TriangleEquilateral.
     */
    @Override
    public void cacher() {
        // Implémentez la logique pour cacher le triangle ici
    }

    /**
     * Calcule et retourne l'aire du TriangleEquilateral.
     *
     * @return L'aire du TriangleEquilateral.
     */
    @Override
    public double calculAire() {
        // Utilisez la formule de Heron pour calculer l'aire
        return super.calculAire();
    }

    /**
     * Calcule et retourne le périmètre de la surface.
     *
     * @return Le périmètre de la surface.
     */
    @Override
    public double calculPerimetre() {
        return super.calculPerimetre();
    }

}