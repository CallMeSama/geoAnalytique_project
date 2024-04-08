package model;

/**
 * La classe Surface est une classe abstraite qui représente un objet géométrique à deux dimensions.
 * Elle étend la classe abstraite GeoObject.
 */
public abstract class Surface extends GeoObject {


    /**
     * Calcule et retourne l'aire de la surface.
     * @return L'aire de la surface.
     */
    public abstract double calculAire();

    /**
     * Calcule et retourne le périmètre de la surface.
     * @return Le périmètre de la surface.
     */
    public abstract double calculPerimetre();
}
