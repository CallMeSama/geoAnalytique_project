package model;

import graphique.Graphique;
import util.GeoObjectVisitor;

public class Carre extends GeoObject{

    private double cote;

    public Carre(double cote) {
        this.cote = cote;
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

 

  
}
