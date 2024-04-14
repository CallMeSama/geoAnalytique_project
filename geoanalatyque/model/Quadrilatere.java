package model;

import model.geoobject.operation.CalculerCotesOperation;
import model.geoobject.operation.Operation;

/**
 * Classe abstraite Quadrilatere qui étend la classe Polygone.
 * Un Quadrilatère est défini par quatre côtés et quatre sommets.
 */
public abstract class Quadrilatere extends Polygone {
    protected double cote1;
    protected double cote2;
    protected double cote3;
    protected double cote4;

    public Quadrilatere(Point s1, Point s2, Point s3, Point s4) {
        super(new Point[]{s1, s2, s3, s4});
        calculDesCotes();
    }

    private void calculDesCotes() {
        // Utilisation de l'opération CalculerCotesOperation pour calculer les longueurs des côtés
        Operation calculerCotes = new CalculerCotesOperation(sommets);
        double[] cotes = (double[]) calculerCotes.calculer();
        
        cote1 = cotes[0];
        cote2 = cotes[1];
        cote3 = cotes[2];
        cote4 = cotes[3];
    }

    /**
     * Méthode pour obtenir la longueur du premier côté du quadrilatère.
     *
     * @return La longueur du premier côté.
     */
    public double getCote1() {
        return cote1;
    }

    /**
     * Méthode pour obtenir la longueur du deuxième côté du quadrilatère.
     *
     * @return La longueur du deuxième côté.
     */
    public double getCote2() {
        return cote2;
    }

    /**
     * Méthode pour obtenir la longueur du troisième côté du quadrilatère.
     *
     * @return La longueur du troisième côté.
     */
    public double getCote3() {
        return cote3;
    }

    /**
     * Méthode pour obtenir la longueur du quatrième côté du quadrilatère.
     *
     * @return La longueur du quatrième côté.
     */
    public double getCote4() {
        return cote4;
    }
}
