package model.geoobject.operation.quadrilatere;


import model.Rectangle;
import util.Operation;

/**
 * Classe représentant l'opération de calcul de l'aire d'un rectangle.
 */
public class AirRectangle implements Operation {
    private Rectangle rectangle;

    /**
     * Constructeur de la classe AirRectangle.
     *
     * @param rectangle Le rectangle pour lequel on souhaite calculer l'aire.
     */
    public AirRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    @Override
    public String getTitle() {
        return "Aire du rectangle";
    }

    @Override
    public int getArite() {
        return 1; // Un seul argument, le rectangle
    }

    @Override
    public void setArgument(int num, Object o) {
        if (o instanceof Rectangle) {
            rectangle = (Rectangle) o;
        } else {
            throw new IllegalArgumentException("Argument doit être de type Rectangle");
        }
    }

    @Override
    public Class<?> getClassArgument(int num) {
        return Rectangle.class;
    }

    @Override
    public Object calculer() {
        return rectangle.getLongueur() * rectangle.getLargeur(); // Calcul de l'aire du rectangle
    }

    @Override
    public String getDescriptionArgument(int num) {
        return "Rectangle";
    }
}

