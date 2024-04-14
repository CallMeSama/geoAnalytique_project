package model;

import graphique.Graphique;
import util.Dessinateur;
import util.GeoObjectVisitor;

/**
 * Classe TriangleIsocele qui étend la classe Triangle.
 * Un TriangleIsocele est un triangle avec deux côtés de même longueur.
 */
public class TriangleIsocele extends Triangle {
    /**
     * Constructeur pour un TriangleIsocele.
     *
     * @param s1 Premier sommet du triangle.
     * @param s2 Deuxième sommet du triangle.
     * @param s3 Troisième sommet du triangle.
     */
    public TriangleIsocele(Point s1, Point s2, Point s3) {
        super(s1, s2, s3);
    }
    @Override
    public Graphique accept(Dessinateur dessinateur) {
        return dessinateur.visit(this);
    }

}
