package model;

import graphique.Graphique;
import util.GeoObjectVisitor;
import util.Dessinateur;
import exception.VisiteurException;
/**
 * Classe Rectangle qui étend la classe Quadrilatere.
 * Un Rectangle est un quadrilatère avec des angles droits opposés et des côtés de longueurs différentes.
 */
public class Rectangle extends GeoObject {
    /**
     * Constructeur pour un Rectangle.
     *
     * @param s1 Premier sommet du rectangle.
     * @param s2 Deuxième sommet du rectangle.
     * @param s3 Troisième sommet du rectangle.
     * @param s4 Quatrième sommet du rectangle.
     */
    public Rectangle(Point s1, Point s2, Point s3, Point s4) {
        super(s1, s2, s3, s4);
    }

    /**
     * Accesseur pour la longueur du rectangle.
     *
     * @return La longueur du rectangle.
     */
    public double getLongueur() {
        return cote1; // La longueur est la longueur du premier côté dans notre cas.
    }

    /**
     * Mutateur pour définir la longueur du rectangle.
     *
     * @param longueur La nouvelle longueur du rectangle.
     */
    public void setLongueur(double longueur) {
        this.cote1 = longueur;
        this.cote3 = longueur;
    }

    /**
     * Accesseur pour la largeur du rectangle.
     *
     * @return La largeur du rectangle.
     */
    public double getLargeur() {
        return cote2; // La largeur est la longueur du deuxième côté dans notre cas.
    }

    /**
     * Mutateur pour définir la largeur du rectangle.
     *
     * @param largeur La nouvelle largeur du rectangle.
     */
    public void setLargeur(double largeur) {
        this.cote2 = largeur;
        this.cote4 = largeur;
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
