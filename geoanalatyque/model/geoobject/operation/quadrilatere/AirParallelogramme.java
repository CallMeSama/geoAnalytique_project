package model.geoobject.operation.quadrilatere;

import model.Parallelogramme;
import util.Operation;

/**
 * Classe représentant l'opération de calcul de l'aire d'un parallélogramme.
 */
public class AirParallelogramme implements Operation {
    private Parallelogramme parallelogramme;

    /**
     * Constructeur de la classe AirParallelogramme.
     *
     * @param parallelogramme Le parallélogramme pour lequel on souhaite calculer l'aire.
     */
    public AirParallelogramme(Parallelogramme parallelogramme) {
        this.parallelogramme = parallelogramme;
    }

    @Override
    public String getTitle() {
        return "Aire du parallélogramme";
    }

    @Override
    public int getArite() {
        return 1; // Un seul argument, le parallélogramme
    }

    @Override
    public void setArgument(int num, Object o) {
        if (o instanceof Parallelogramme) {
            parallelogramme = (Parallelogramme) o;
        } else {
            throw new IllegalArgumentException("Argument doit être de type Parallelogramme");
        }
    }

    @Override
    public Class<?> getClassArgument(int num) {
        return Parallelogramme.class;
    }

    @Override
    public Object calculer() {
        return 0;
        /*parallelogramme.getLongueur() * parallelogramme.getHauteur(); // Calcul de l'aire du parallélogramme
    */
    }

    @Override
    public String getDescriptionArgument(int num) {
        return "Parallélogramme";
    }
}
