package model.geoobject.operation;

import model.Point;

public interface Operation {
    Point apply(Point p);

    /**
     * Donne le titre de l'opération
     * @return le nom de l'opération
     */
    String getTitle();

    /**
     * Donne le nombre d'arguments de l'opération
     * @return le nombre d'argument d'une opération
     */
    int getArite();

    /**
     * Rajoute un argument à une opération
     * @param num la position de l'argument
     * @param o le type de l'argument
     */

    void setArgument(int num, Object o);

    /**
     * Donne la classe d'un argument
     * @param num la position de l'argument
     * @return la classe de l'argument
     */

    Class getClassArgument(int num);

    Object calculer();

    /**
     * Donne la description de l'argument
     * @param num la position de l'argument
     * @return la description de l'argument
     */
    String getDescriptionArgument(int num);
}
