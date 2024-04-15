package model;

//import java.util.List;

import exception.VisiteurException;
import graphique.Graphique;
import util.Dessinateur;
import util.GeoObjectVisitor;

/**
 * Classe représentant un segment de droite géométrique défini par deux points.
 */
public class Segment extends Droite {

    /**
     * Constructeur d'un segment à partir de deux points.
     * 
     * @param point1 Le premier point du segment.
     * @param point2 Le deuxième point du segment.
     */
    public Segment(Point point1, Point point2) {
        super(point1, point2);
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
