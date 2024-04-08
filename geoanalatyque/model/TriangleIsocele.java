package model;

public class TriangleIsocele extends Triangle {
    public TriangleIsocele(double a, double b) {
        super(a, a, b);
    }

    @Override
    public double surface() {
        return 0.5 * c * Math.sqrt(Math.pow(a, 2) - Math.pow(c, 2) / 4);
    }
}
