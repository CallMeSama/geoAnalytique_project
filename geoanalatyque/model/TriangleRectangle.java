package model;

public class TriangleRectangle extends Triangle{
    public TriangleRectangle(double a, double b) {
        super(a, b, Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2)));
    }
    @Override
    public double surface() {
        return 0.5 * a * b;
    }
}
