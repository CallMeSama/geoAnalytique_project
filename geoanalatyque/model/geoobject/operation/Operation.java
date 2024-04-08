package model.geoobject.operation;

import model.Point;

public interface Operation {
    Point apply(Point p);
}
