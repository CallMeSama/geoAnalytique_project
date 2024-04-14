package model;

public abstract class Quadrilatere extends Polygone{
    public Quadrilatere(Point s1, Point s2, Point s3, Point s4) {
        super(new Point[]{s1, s2, s3, s4});
    }
}
