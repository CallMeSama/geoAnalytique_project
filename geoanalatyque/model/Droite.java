package model;

import graphique.Graphique;
import util.GeoObjectVisitor;
import exception.VisiteurException;
import util.Dessinateur;

/**
 * Classe représentant une droite géométrique définie par deux points.
 */
public class Droite extends GeoObject {
    private Point point1;
    private Point point2;

    /**
     * Constructeur d'une droite à partir de deux points.
     * 
     * @param point1 Le premier point de la droite.
     * @param point2 Le deuxième point de la droite.
     */
    public Droite(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    // Getters et setters
    /**
     * Obtient le premier point de la droite.
     * 
     * @return Le premier point de la droite.
     */
    public Point getPoint1() {
        return point1;
    }

    /**
     * Définit le premier point de la droite.
     * 
     * @param point1 Le nouveau premier point de la droite.
     */
    public void setPoint1(Point point1) {
        this.point1 = point1;
        notifierModification();
    }

    /**
     * Obtient le deuxième point de la droite.
     * 
     * @return Le deuxième point de la droite.
     */
    public Point getPoint2() {
        return point2;
    }

    /**
     * Définit le deuxième point de la droite.
     * 
     * @param point2 Le nouveau deuxième point de la droite.
     */
    public void setPoint2(Point point2) {
        this.point2 = point2;
        notifierModification();
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
