package model;

/**
 * Classe abstraite Triangle qui étend la classe Polygone.
 * Un Triangle est défini par trois côtés et trois sommets.
 */
public abstract class Triangle extends Polygone {
    /**
     * Longueur du premier côté du triangle.
     */
    protected double coteA;

    /**
     * Longueur du deuxième côté du triangle.
     */
    protected double coteB;

    /**
     * Longueur du troisième côté du triangle.
     */
    protected double coteC;

    /**
     * Constructeur pour un Triangle.
     *
     * @param s1 Premier sommet du triangle.
     * @param s2 Deuxième sommet du triangle.
     * @param s3 Troisième sommet du triangle.
     */
    public Triangle(Point s1, Point s2, Point s3) {
        super(new Point[]{s1, s2, s3});
        calculDesCotes();
    }

    /**
     * Définit les longueurs des côtés du triangle en calculant la distance entre chaque paire de points.
     */
    private void calculDesCotes() {
        coteA = sommets[0].calculerDistance(sommets[1]);
        coteB = sommets[1].calculerDistance(sommets[2]);
        coteC = sommets[2].calculerDistance(sommets[0]);
    }

    /**
     * Méthode abstraite qui calcule l'aire du triangle connaissant la longueur de ses côté avec la methode de Heron.
     *
     * @return l'aire du triangle.
     */
    public double calculAire(){
        // Calculer le demi-périmètre
        double s = (coteA + coteB + coteC) / 2;

        // Calculer l'aire en utilisant la formule de Heron
        return Math.sqrt(s * (s - coteA) * (s - coteB) * (s - coteC));
    };
}