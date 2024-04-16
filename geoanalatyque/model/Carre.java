package model;
import exception.VisiteurException;
import graphique.Graphique;
import util.GeoObjectVisitor;
import util.Dessinateur;


public class Carre extends Quadrilatere{
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
    /**
     * Accepte un visiteur géométrique pour appliquer une opération sur cet objet.
     * Cette méthode invoque la méthode correspondante du visiteur avec cet objet en tant que paramètre.
     *
     * @param dessinateur Le visiteur géométrique à accepter.
     */

    public Graphique accept(Dessinateur dessinateur) throws VisiteurException {
        return dessinateur.visit(this);
    }
}
