package model.geoobject.operation.droite;

import model.Droite;
import util.Operation;

/**
 * Classe représentant l'opération de vérification de l'intersection entre deux droites.
 */
public class IntersecteAvecDroiteOperation implements Operation {
    private Droite droite1;
    private Droite droite2;

    /**
     * Constructeur de l'opération.
     * 
     * @param droite La droite à vérifier.
     */
    public IntersecteAvecDroiteOperation(Droite droite1, Droite droite2) {
        this.droite1 = droite1;
        this.droite2 = droite2;
    }

    @Override
    public String getTitle() {
        return "Vérifier si la droite intersecte une autre droite";
    }

    @Override
    public int getArite() {
        return 2;
    }

    @Override
    public void setArgument(int num, Object o) {
        if (num == 0) {
            droite1 = (Droite) o;
        } else {
            if (num == 1) {
                droite2 = (Droite) o;
            } else 
                throw new IllegalArgumentException("Numéro d'argument invalide");
        }
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Class getClassArgument(int num) {
        return Droite.class;
    }

    @Override
    public Object calculer() {
        CalculerPenteDroiteOperation penteOperation1 = new CalculerPenteDroiteOperation(droite1);
        CalculerPenteDroiteOperation penteOperation2 = new CalculerPenteDroiteOperation(droite2);
        double pente1 = (double) penteOperation1.calculer();
        double pente2 = (double) penteOperation2.calculer();
        return pente1 != pente2;
    }

    @Override
    public String getDescriptionArgument(int num) {
        if (num == 0) {
            return "1ere droite à vérifier";
        } else {
            if (num == 1) {
                return "2eme droite à vérifier";
            } else 
                throw new IllegalArgumentException("Numéro d'argument invalide");
        }
    }
}
