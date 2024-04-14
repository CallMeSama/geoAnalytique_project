package model.geoobject.operation.quadrilatere;

import model.Quadrilatere;
import model.geoobject.operation.Operation;

/**
 * Classe représentant l'opération de calcul du périmètre d'un quadrilatère.
 */
public class CalculerPerimetre implements Operation {
    private Quadrilatere quadrilatere;

    /**
     * Constructeur de la classe CalculerPerimetre.
     *
     * @param quadrilatere Le quadrilatère pour lequel on souhaite calculer le périmètre.
     */
    public CalculerPerimetre(Quadrilatere quadrilatere) {
        this.quadrilatere = quadrilatere;
    }

    @Override
    public String getTitle() {
        return "Calcul du périmètre du quadrilatère";
    }

    @Override
    public int getArite() {
        return 1; // Un seul argument, le quadrilatère
    }

    @Override
    public void setArgument(int num, Object o) {
        if (o instanceof Quadrilatere) {
            quadrilatere = (Quadrilatere) o;
        } else {
            throw new IllegalArgumentException("Argument doit être de type Quadrilatere");
        }
    }

    @Override
    public Class<?> getClassArgument(int num) {
        return Quadrilatere.class;
    }

    @Override
    public Object calculer() {
        // Calcul du périmètre du quadrilatère en ajoutant les longueurs de ses côtés
        return quadrilatere.getCote1() + quadrilatere.getCote2() + quadrilatere.getCote3() + quadrilatere.getCote4();
    }

    @Override
    public String getDescriptionArgument(int num) {
        return "Quadrilatère";
    }
}

