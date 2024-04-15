package model;

/**
 * Classe abstraite Triangle qui étend la classe Polygone.
 * Un Triangle est défini par trois côtés et trois sommets.
 */
public abstract class Triangle extends Polygone {

    /**
     * Constructeur pour un Triangle.
     *
     * @param s1 Premier sommet du triangle.
     * @param s2 Deuxième sommet du triangle.
     * @param s3 Troisième sommet du triangle.
     */
    public Triangle(Point s1, Point s2, Point s3) {
        super(new Point[]{s1, s2, s3});
    }

}