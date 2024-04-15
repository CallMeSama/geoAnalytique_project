package model;

import graphique.Graphique;
import util.GeoObjectVisitor;

/**
 * Classe TriangleRectangle qui étend la classe Triangle.
 * Un TriangleRectangle est un triangle avec un angle droit.
 */
public class TriangleRectangle extends Triangle {
    /**
     * Constructeur pour un TriangleRectangle.
     *
     * @param s1 Premier sommet du triangle.
     * @param s2 Deuxième sommet du triangle.
     * @param s3 Troisième sommet du triangle.
     */
    public TriangleRectangle(Point s1, Point s2, Point s3) {
        super(s1, s2, s3);
    }

    /**
     * Accepte un visiteur géométrique pour appliquer une opération sur cet objet.
     * Cette méthode invoque la méthode correspondante du visiteur avec cet objet en tant que paramètre.
     *
     * @param visitor Le visiteur géométrique à accepter.
     */

    public void accept(GeoObjectVisitor<Graphique> visitor) {
        visitor.visit(this);
    }
}