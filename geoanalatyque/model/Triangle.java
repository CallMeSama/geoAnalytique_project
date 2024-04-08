package model;

public abstract class Triangle {
    protected double a;
    protected double b;
    protected double c;
    protected Point s1;
    protected Point s2;
    protected Point s3;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public abstract double surface();
}
