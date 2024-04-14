package model.geoobject.operation.quadrilatere;

import model.Carre;
import model.geoobject.operation.Operation;

/**
 * Classe représentant l'opération de calcul de l'aire d'un carré.
 */
public class AirCarre implements Operation {
    private Carre carre;

    /**
     * Constructeur de la classe AirCarre.
     *
     * @param carre Le carré pour lequel on souhaite calculer l'aire.
     */
    public AirCarre(Carre carre) {
        this.carre = carre;
    }

    @Override
    public String getTitle() {
        return "Aire du carré";
    }

    @Override
    public int getArite() {
        return 1; // Un seul argument, le carré
    }

    @Override
    public void setArgument(int num, Object o) {
        if (o instanceof Carre) {
            carre = (Carre) o;
        } else {
            throw new IllegalArgumentException("Argument doit être de type Carre");
        }
    }

    @Override
    public Class<?> getClassArgument(int num) {
        return Carre.class;
    }

    @Override
    public Object calculer() {
        return carre.getCote() * carre.getCote(); // Calcul de l'aire du carré
    }

    @Override
    public String getDescriptionArgument(int num) {
        return "Carré";
    }
}
