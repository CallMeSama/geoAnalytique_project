package model.geoobject.operation;

import model.Point;

public class TranslationOperation implements Operation {
    private double dx, dy;

    public TranslationOperation(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }
    @Override
    public Point apply(Point p) {
        return new Point(p.getX() + dx, p.getY() + dy);
    }
}
