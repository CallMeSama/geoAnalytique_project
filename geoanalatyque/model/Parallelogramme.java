package model;

/**
 * Classe Parallelogramme qui étend la classe Quadrilatere.
 * Un Parallelogramme est un quadrilatère dont les côtés opposés sont parallèles et de même longueur.
 */
public class Parallelogramme extends Quadrilatere {
    /**
     * Constructeur pour un Parallelogramme.
     *
     * @param s1 Premier sommet du parallélogramme.
     * @param s2 Deuxième sommet du parallélogramme.
     * @param s3 Troisième sommet du parallélogramme.
     * @param s4 Quatrième sommet du parallélogramme.
     */
    public Parallelogramme(Point s1, Point s2, Point s3, Point s4) {
        super(s1, s2, s3, s4);
    }

    /**
     * Accesseur pour la longueur du côté du parallélogramme.
     *
     * @return La longueur du côté du parallélogramme.
     */
    public double getLongueur() {
        return cote1; // La longueur est la longueur du premier côté dans notre cas.
    }

    /**
     * Mutateur pour définir la longueur du parallélogramme.
     *
     * @param longueur La nouvelle longueur du parallélogramme.
     */
    public void setLongueur(double longueur) {
        this.cote1 = longueur;
        this.cote3 = longueur;
    }

    /**
     * Accesseur pour la hauteur du parallélogramme.
     *
     * @return La hauteur du parallélogramme.
     */
    public double getHauteur() {
        // La hauteur d'un parallélogramme est la distance entre deux côtés parallèles, qui est la longueur du segment
        // perpendiculaire à ces côtés et passant par un sommet.
        // Dans notre cas, la hauteur est la distance entre le premier côté et le quatrième côté (ou entre le deuxième côté et le troisième côté).
        // On peut donc simplement utiliser la distance entre ces deux côtés.
        return sommets[0].calculerDistance(sommets[3]);
    }

}
