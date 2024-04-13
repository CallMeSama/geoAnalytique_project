package model.geoobject.operation;

import model.Point;

public class RotationOperation implements Operation{
    private Point origin;
    private double angle;

    public RotationOperation(Point origin, double angle) {
        this.origin = origin;
        this.angle = angle;
    }

    @Override
    public Point apply(Point p) {
        double rad = Math.toRadians(angle);
        double x = origin.getX() + (p.getX() - origin.getX()) * Math.cos(rad) - (p.getY() - origin.getY()) * Math.sin(rad);
        double y = origin.getY() + (p.getX() - origin.getX()) * Math.sin(rad) + (p.getY() - origin.getY()) * Math.cos(rad);
        return new Point(x, y);
    }
}
