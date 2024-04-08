package model.geoobject.operation;

import model.Point;

public class DistanceOperation implements Operation {
    private Point p2;

    public DistanceOperation(Point p2) {
        this.p2 = p2;
    }

    @Override
    public Point apply(Point p1) {
        double distance = Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
        return new Point(distance, 0);
    }
}