package model;

import graphique.Graphique;
import util.Dessinateur;

/**
 * Classe Carre qui étend la classe Quadrilatere.
 * Un Carre est un quadrilatère dont les quatre côtés ont la même longueur.
 */
public class Carre extends Quadrilatere {
    /**
     * Constructeur pour un Carre.
     *
     * @param s1 Premier sommet du carré.
     * @param s2 Deuxième sommet du carré.
     * @param s3 Troisième sommet du carré.
     * @param s4 Quatrième sommet du carré.
     */
    public Carre(Point s1, Point s2, Point s3, Point s4) {
        super(s1, s2, s3, s4);
    }

    /**
     * Accesseur pour la longueur du côté du carré.
     *
     * @return La longueur du côté du carré.
     */
    public double getCote() {
        return cote1; // Un carré a tous ses côtés de même longueur, donc on peut retourner n'importe quel côté.
    }

    /**
     * Mutateur pour définir la longueur du côté du carré.
     *
     * @param cote La nouvelle longueur du côté du carré.
     */
    public void setCote(double cote) {
        this.cote1 = cote;
        this.cote2 = cote;
        this.cote3 = cote;
        this.cote4 = cote;
    }
    @Override
    public Graphique accept(Dessinateur dessinateur) {
        return dessinateur.visit(this);
    }


}