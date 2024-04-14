package model;

import graphique.Graphique;
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

    // ...

    /**
     * Calcule et retourne l'aire du TriangleIsocele.
     *
     * @return L'aire du TriangleIsocele.
     */
    @Override
    public double calculAire() {
        return super.calculAire();
    }

    /**
     * Calcule et retourne le périmètre du TriangleIsocele.
     *
     * @return Le périmètre du TriangleIsocele.
     */
    @Override
    public double calculPerimetre() {
        return super.calculPerimetre();
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
