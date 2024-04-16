package model;

import exception.VisiteurException;
import graphique.Graphique;
import util.GeoObjectVisitor;
import util.Dessinateur;
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
     * Accepte un visiteur géométrique pour appliquer une opération sur cet objet.
     * Cette méthode invoque la méthode correspondante du visiteur avec cet objet en tant que paramètre.
     *
     * @param dessinateur Le visiteur géométrique à accepter.
     */

    @Override
    public Graphique accept(Dessinateur dessinateur) throws VisiteurException {
        return dessinateur.visit(this);
    }

}