package model;

import graphique.Graphique;
import util.GeoObjectVisitor;

public class Segment extends GeoObject{
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
