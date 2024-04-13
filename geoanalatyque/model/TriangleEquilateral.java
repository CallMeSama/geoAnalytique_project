package model;

public class TriangleEquilateral extends Triangle{
    public TriangleEquilateral(double a) {
        super(a, a, a);
    }

    @Override
    public double surface() {
        return Math.sqrt(3) / 4 * Math.pow(a, 2);
    }
}
