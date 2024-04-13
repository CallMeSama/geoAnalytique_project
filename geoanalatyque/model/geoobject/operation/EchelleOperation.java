package model.geoobject.operation;

import model.Point;

public class EchelleOperation implements Operation {
    private Point origin;
    private double scale;

    public EchelleOperation(Point origin, double scale) {
        this.origin = origin;
        this.scale = scale;
    }

    @Override
    public Point apply(Point p) {
        double x = origin.getX() + (p.getX() - origin.getX()) * scale;
        double y = origin.getY() + (p.getY() - origin.getY()) * scale;
        return new Point(x, y);
    }
}

